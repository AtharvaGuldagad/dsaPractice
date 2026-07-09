# Permutation in String

## Intuition

### The Frequency Profile Matching

A permutation of a string is simply a rearrangement of its characters. This means if one string is a permutation of another, both must contain the exact same characters with the exact same frequencies.

Instead of generating every possible shuffle of the target string `s1` (which becomes computationally explosive), we can calculate its unique character footprint using a frequency profile. If we can find any continuous window inside `s2` that has a frequency profile matching `s1` exactly, we have discovered a permutation.

### The Exhaustive Scan vs. Fixed Sliding Window

The provided code uses a brute-force approach. It calculates the profile for `s1`, then selects every single index `i` in `s2` as a potential starting anchor. From that anchor, it builds a brand-new frequency profile for a segment from scratch. While accurate, resetting the search at every index creates a massive amount of redundant counting.

Because any valid permutation of `s1` *must* be the exact same length as `s1`, we do not need a variable window. The strictly optimal approach uses a **Fixed-Size Sliding Window** of length `s1.length()`. As you slide this window one step to the right, you do not recreate a map. You simply "absorb" the single new character entering from the right and "evict" the single old character falling out on the left, maintaining a running profile update in $O(N)$ time.

---

## Step-by-Step Guide

1. Grab a basket (your first HashMap) and count the frequency of every letter inside the short target string `s1`.
2. Count how many unique letters are in that basket. This is your target number of matches (`need`).
3. Set up a loop that treats every single position in the long string `s2` as a potential starting anchor `i` for a hidden match.
4. Every time you pick a new starting anchor `i`, grab a brand-new, empty basket (your second HashMap) to record the segment we are about to check. Reset your active matches tracker (`cur`) to zero.
5. Start a second pointer `j` at your active anchor `i` and step it forward to build your substring character by character.
6. For each character `j` lands on, look at your current segment basket:
* Throw the character into your segment basket and increment its count.
* Compare this count to the target basket for `s1`. If your segment basket now contains *more* copies of this letter than `s1` allows, your segment is invalid. Break the inner loop immediately to try a new anchor.
* If your segment basket contains the *exact* right amount of copies required for that specific letter, increment your active matches tracker (`cur`).


7. Check your tracker: "Does my active matching count (`cur`) equal my target requirement (`need`)?"
8. **If YES:** You found a perfect permutation segment. Stop everything and give back `true`.
9. **If NO:** Keep moving `j` forward to expand the window until it either breaks or finishes.
10. If you try anchoring a window at every single index in `s2` and the loop never matches perfectly, hand back `false`.

---

## Complexity Analysis

* **Time Complexity:** $O(M \times N)$
* Let $M$ be the length of `s1` and $N$ be the length of `s2`. In the worst-case scenario, for each of the $N$ starting positions in `s2`, the inner loop expands up to a length bounded by the alphabet or $M$. This nested-loop scanning behavior creates a quadratic worst-case execution path.
* *(Note: The optimal Fixed Sliding Window approach optimizes this down to $O(N)$ time by sliding a window of length $M$ smoothly without re-counting).*


* **Space Complexity:** $O(\Sigma)$
* The auxiliary space is determined by the storage size of our maps. Since the inputs only contain lowercase English letters, the characters are bounded by a fixed alphabet size ($\Sigma = 26$). Because the map size will never exceed this small limit regardless of how long the input strings grow, the auxiliary space complexity is strictly constant, $O(1)$.
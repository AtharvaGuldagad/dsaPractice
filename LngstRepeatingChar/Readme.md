# Longest Repeating Character Replacement

## Intuition

### The Bottleneck Rule

If you look at any window of text and want to turn it into a solid block of identical letters, the smartest strategy is to pick the letter that already appears the most frequently in that window (the `maxfreq`). Every other letter in that window that doesn't match this dominant letter is a "misfit" and must be replaced.

The number of operations required to clean up the window is basic subtraction: $\text{Total Window Length} - \text{Frequency of Dominant Letter}$. If this count of misfits is less than or equal to your allowance ($k$), then that entire window can successfully be converted into a valid repeating sequence.

### The Exhaustive Scan vs. Sliding Window

The provided code uses a brute-force approach. It fixes a starting pointer `i` at every single position in the string, and then pushes a second pointer `j` forward to check every possible sub-segment from scratch. While this works perfectly, it recreates a brand new `HashMap` and recounts letters over and over, leading to repetitive work.

The strictly optimal alternative is a dynamic **Sliding Window** approach. Instead of resetting the window back to zero when we hit too many misfits, we can keep the window expanding to the right, and only shrink it from the left *just enough* to keep the misfit count within our allowance $k$. This allows us to find the absolute longest stretch in a single pass.

---

## Step-by-Step Guide

1. Create a blank notebook to hold your "longest valid sequence found so far" and start it at zero.
2. Setup a loop that treats every single letter in the string as a potential starting anchor `i` for a sequence.
3. Every time you pick a new starting anchor, grab a brand new, empty basket (your HashMap) to count characters, and reset your "dominant letter count" to zero.
4. Start a second pointer `j` at your starting anchor and walk it forward toward the end of the string, character by character.
5. For each character `j` lands on, throw it into your basket and update its count.
6. Check if this character's new count is larger than your recorded dominant letter count. If it is, update your dominant letter count.
7. Calculate the current length of your window (which is $j - i + 1$).
8. Subtract your dominant letter count from this total window length to find out how many characters are currently "misfits".
9. **If the misfits are within your allowance ($\le k$):** This window is valid! Look at its length. If it is bigger than the record in your notebook, update your notebook with this new maximum length.
10. **If the misfits exceed your allowance ($> k$):** This window is impossible to fix with your budget. Stop moving `j` forward, move your starting anchor `i` one step to the right, and start a fresh scan.
11. Once you have tried anchoring a window at every possible starting spot in the string, hand back the maximum length written in your notebook.

---

## Complexity Analysis

* **Time Complexity:** $O(N^2)$
* Because of the nested loops, for every character position `i` in the string of length $N$, the inner loop expands `j` through the remaining portion of the string. In the worst-case scenario (such as a string where every window is valid), the inner loop runs roughly $N/2$ times on average, resulting in a quadratic runtime.
* *(Note: The optimal Sliding Window approach optimizes this to $O(N)$ time by avoiding the reset of the inner loop).*


* **Space Complexity:** $O(1)$ or $O(\Sigma)$
* The memory allocated inside the outer loop is for the `HashMap`. Since the string only contains characters (typically uppercase English letters), the map will hold at most 26 unique keys. Because this upper boundary is completely fixed and independent of the input string length $N$, the auxiliary space is strictly constant.
# Minimum Window Substring

## Intuition

### The Contract and the Budget

Think of the target string `t` as a strict contract: it dictates exactly which characters you need to collect and the minimum quantity required for each. Your goal is to find the shortest continuous window in string `s` that satisfies this entire contract.

### The Expand and Contract Strategy (Sliding Window)

To find the minimum window efficiently without checking every single substring from scratch (which would take quadratic time), we use a two-pointer sliding window approach:

1. **Expand (Right Pointer `i`):** We move our right pointer forward to swallow characters, acting like an eager collector. We keep expanding until our active window has collected all the required characters in the correct amounts (`have == need`).
2. **Shrink (Left Pointer `l`):** Once the contract is fully satisfied, we stop expanding. We record the current window size if it's the smallest we've seen so far. Then, we try to optimize by sliding our left pointer forward to eject characters from the back of our window. We keep shrinking the window until we accidentally eject a vital character that breaks the contract. The moment `have` falls below `need`, we stop shrinking and go back to expanding.

---

## Step-by-Step Guide

1. Check if the target string `t` is empty. If it is, give back an empty piece of text `""`.
2. Grab a target basket (`T`) and count the exact frequency of every letter required by string `t`. Note down how many unique letters are in this basket. This is your target requirement (`need`).
3. Grab an empty window basket (`window`) to keep track of the characters currently trapped between your left and right boundaries.
4. Set up an active match tracker (`have`) at zero, a record for the shortest length found so far at infinity, and place your left boundary pointer `l` at index zero.
5. Start a loop that steps your right boundary pointer `i` forward through string `s`, character by character.
6. For each character `c` that enters your window from the right:
* Toss it into your `window` basket and update its count.
* Check if this character is part of your contract. If the count of this letter in your `window` basket matches the exact count required in your target basket `T`, increment your active match tracker (`have`).


7. **The Optimization Phase:** While your active match tracker perfectly matches the requirement (`have == need`), you have a valid window.
* Calculate the length of this current window ($i - l + 1$). If it is smaller than your historical record, update your record and save the start/end positions.
* Now, try to trim the fat. Look at the character sitting at your left boundary (`leftChar`).
* Decrement its count in the `window` basket.
* Check if losing this character breaks your contract. If `leftChar` was required by `t` and its count drops *below* the target count in basket `T`, decrement your active match tracker (`have`).
* Slide your left boundary pointer `l` one step forward to officially shrink the window.


8. Repeat steps 6 and 7 until your right pointer reaches the end of string `s`.
9. If your shortest length record never changed from infinity, it means no valid window was ever found; return `""`. Otherwise, cut out the exact substring using your saved best boundaries and return it.

---

## Complexity Analysis

* **Time Complexity:** $O(N + M)$
* Let $N$ be the length of string `s` and $M$ be the length of string `t`. Building the initial target map takes $O(M)$ time. During the sliding window phase, both the right pointer `i` and the left pointer `l` only ever move forward, traversing the string `s` at most once each. This guarantees a linear scan behavior, operating in $O(N)$ time.


* **Space Complexity:** $O(\Sigma)$
* The auxiliary space is determined by the storage size of our character frequency maps. Since the inputs are bounded by standard character sets (like ASCII or English alphabets), the maps will hold at most a fixed number of unique keys ($\Sigma$). Because this upper limit is completely independent of the size of inputs $N$ and $M$, the auxiliary space complexity is strictly constant, $O(1)$.
# Maximum Length Substring With at Most Two Occurrences

## Intuition

### Dynamic Sliding Window

The goal is to find the length of the longest contiguous substring where every character appears **at most twice**.

A brute-force solution would examine every possible substring, leading to an $O(N^2)$ runtime. Instead, we use a **two-pointer Sliding Window** approach:

1. **Expand (Right Pointer `j`):** Extend the window by adding the current character `c = s.charAt(j)` and incrementing its frequency in our tracking map.
2. **Contract (Left Pointer `i`):** If the frequency of `c` exceeds the allowed limit (`count.get(c) > 2`), the window becomes invalid. We slide the left pointer `i` forward, decrementing character counts one by one until the count of `c` drops back down to 2.
3. **Record Max Length:** Once the window is guaranteed to be valid, update our maximum length tracker `res = Math.max(res, j - i + 1)`.

---

## Step-by-Step Guide

1. Initialize a hash map `count` to track character frequencies within the current window.
2. Set the left boundary `i = 0` and the maximum length result `res = 0`.
3. Iterate through the string using the right pointer `j` from `0` to `s.length() - 1`:
* Fetch the character `c = s.charAt(j)`.
* Increment its frequency in `count`.
* **Shrink while invalid:** While `count.get(c) > 2`, fetch `left = s.charAt(i)`, decrement its frequency in `count`, and increment `i`.
* **Update result:** Compute the valid window length $(j - i + 1)$ and update `res = Math.max(res, j - i + 1)`.


4. Return `res` after the loop finishes.

---

## Complexity Analysis

* **Time Complexity:** $O(N)$
* Where $N$ is the length of string `s`. The right pointer `j` iterates from $0$ to $N - 1$. The left pointer `i` also only moves forward and advances at most $N$ times across the entire algorithm. Each character is visited at most twice, resulting in a linear runtime.


* **Space Complexity:** $O(1)$ or $O(\Sigma)$
* The hash map stores at most the unique characters present in the string (at most 26 lowercase English letters). Because the alphabet size $\Sigma$ is fixed and independent of $N$, the auxiliary space complexity is strictly constant.
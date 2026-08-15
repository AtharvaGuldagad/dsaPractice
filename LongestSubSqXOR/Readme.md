# Longest Subsequence With Non-Zero XOR

## Intuition

### XOR Properties and Element Removal

The goal is to find the maximum length of a subsequence such that the bitwise XOR sum of its elements is strictly greater than zero ($\ne 0$).

1. **All Zeros Case:** If all elements in `nums` are `0`, no non-empty subsequence can ever produce a non-zero XOR. The answer is immediately `0`.
2. **Total XOR is Non-Zero (`total != 0`):** If the XOR sum of the entire array is already non-zero, the longest valid subsequence is simply the full array itself, with length $n$.
3. **Total XOR is Zero (`total == 0`):** If the total XOR of all elements cancels out to $0$ and at least one non-zero element $x > 0$ exists:
* Removing any single non-zero element $x$ flips the remaining subsequence XOR sum to $0 \oplus x = x \ne 0$.
* Since removing just one element guarantees a non-zero XOR, the maximum possible length is $n - 1$.



---

## Step-by-Step Guide

1. Initialize `total = 0` to accumulate the total XOR sum and `zeroFlag = false` to check if at least one strictly positive element exists.
2. Iterate through each number `x` in `nums`:
* Update `zeroFlag = zeroFlag || (x > 0)`.
* Accumulate the bitwise XOR: `total = total ^ x`.


3. **Edge Case:** If `zeroFlag` remains `false` (meaning the array contains only zeros), return `0`.
4. **Evaluate Result:**
* If `total != 0`, return `n` (the whole array).
* If `total == 0`, return `n - 1` (drop one non-zero element to make the XOR non-zero).



---

## Complexity Analysis

* **Time Complexity:** $O(n)$
* We iterate through the array of length $n$ exactly once to compute the total XOR and check the flag. Each bitwise operation takes $O(1)$ constant time, resulting in linear runtime.


* **Space Complexity:** $O(1)$
* Only a few primitive variables (`total`, `n`, `zeroFlag`) are used. No additional memory or dynamic structures are allocated, keeping the auxiliary space strictly constant.
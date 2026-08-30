# Concatenation of Array

## Intuition

### Simultaneous Array Duplication

The task requires creating an array `ans` of length $2n$ where `ans[i]` and `ans[i + n]` are both equal to `nums[i]` for $0 \le i < n$.

Instead of running two separate loops or copying the array twice, we can populate both halves of `ans` in a single pass:

1. Allocate an array `ans` of size $2n$, where $n = \text{nums.length}$.
2. For every index $i$ in `nums`, place `nums[i]` at index $i$ (first half) and at index $i + n$ (second half) simultaneously.

---

## Step-by-Step Guide

1. Get the length $n$ of the input array `nums`.
2. Create a new integer array `ans` of size $2n$.
3. Loop through `i` from `0` to $n - 1$:
* Assign `ans[i] = nums[i]`.
* Assign `ans[i + n] = nums[i]`.


4. Return `ans`.

---

## Complexity Analysis

* **Time Complexity:** $O(n)$
* We iterate through `nums` of length $n$ exactly once. Each iteration performs $O(1)$ constant-time array assignment operations.


* **Space Complexity:** $O(n)$
* Beyond the allocated result array of size $2n$, no additional auxiliary data structures are used.
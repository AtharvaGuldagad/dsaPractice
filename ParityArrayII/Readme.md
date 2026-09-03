# Replace Elements with Greatest Element on Right Side

## Intuition

### Right-to-Left Single Pass vs. Nested Loops

Your current solution uses a nested loop approach ($O(N^2)$ time), re-scanning and recalculating the maximum of the right subarray for every single position from scratch.

By reversing the traversal direction and working **Right-to-Left**, this can be optimized to $O(N)$ time:

* Traversing backwards from the end of the array to the beginning allows us to maintain a running variable (`maxSoFar`) that tracks the largest element seen to the right.
* At each index `i`, the required replacement value is simply the current `maxSoFar`.
* Before updating the array at `i` with `maxSoFar`, the original value at index `i` is saved temporarily so it can update `maxSoFar` for the next element to the left.

---

## Step-by-Step Guide

1. Initialize a running maximum tracker `maxSoFar = -1`.
2. Iterate through the array backwards from index `i = arr.length - 1` down to `0`:
* Store the original element value at `arr[i]` in a temporary variable.
* Replace `arr[i]` with `maxSoFar`.
* Update `maxSoFar` to be the maximum of `maxSoFar` and the stored temporary value.


3. Return the modified array.

---

## Complexity Analysis

* **Time Complexity:** $O(N)$
* **Current Code:** $O(N^2)$ due to the nested loop scanning remaining elements to the right.
* **Optimized Approach:** $O(N)$, performing a single right-to-left pass over $N$ elements with $O(1)$ constant-time updates per step.


* **Space Complexity:** $O(1)$
* Modifies the array in-place, requiring strictly constant auxiliary space.
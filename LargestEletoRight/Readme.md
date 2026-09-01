# Replace Elements with Greatest Element on Right Side

## Intuition

### Right-to-Left Single Pass vs. Nested Loops

Your current solution uses a nested loop approach ($O(N^2)$ time), recalculating the maximum of the right subarray for every single element from scratch.

By reversing our traversal direction and working **Right-to-Left**, we can optimize this to $O(N)$ time:

* As we traverse backwards from the end of the array to the beginning, we can maintain a running variable `maxSoFar` that tracks the largest element seen to the right.
* At each index `i`, the required replacement value is simply the current `maxSoFar`.
* Before updating `arr[i]` with `maxSoFar`, we save the original `arr[i]` value in a temporary variable so it can be used to update `maxSoFar` for the next element to the left.

---

## Step-by-Step Guide

1. Track the running maximum starting from the last element's replacement value: `maxSoFar = -1`.
2. Iterate through the array backwards from index `i = arr.length - 1` down to `0`:
* Store the original value of `arr[i]` in `tempVal`.
* Assign `arr[i] = maxSoFar`.
* Update `maxSoFar = Math.max(maxSoFar, tempVal)` to prepare for the next element to the left.


3. Return `arr`.

```java
class Solution {
    public int[] replaceElements(int[] arr) {
        int maxSoFar = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int tempVal = arr[i];
            arr[i] = maxSoFar;
            maxSoFar = Math.max(maxSoFar, tempVal);
        }
        return arr;
    }
}

```

---

## Complexity Analysis

* **Time Complexity:** $O(N)$
* **Current Solution:** $O(N^2)$ due to the nested loop scanning remaining right elements.
* **Optimized Solution:** $O(N)$, traversing the array of size $N$ once from right to left with $O(1)$ constant-time updates per element.


* **Space Complexity:** $O(1)$
* The array is modified in-place, using strictly constant auxiliary space.
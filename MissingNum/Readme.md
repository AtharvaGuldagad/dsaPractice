# Missing Number

## Intuition

### Gauss's Sum Formula (Difference Tracking)

The problem asks us to find the single missing number from an array containing $n$ distinct numbers in the range $[0, n]$. Mathematically, the sum of all integers from $0$ to $n$ is given by Gauss's formula:

$$\text{Sum} = \frac{n \times (n + 1)}{2}$$

If we calculate the expected sum of the full range $[0, n]$ and subtract the actual sum of the elements present in the array, the remaining difference is guaranteed to be our missing number.

### Accumulative Index Offset

Instead of summing all elements first and risk overflow on huge inputs, your code cleverly tracks the net difference on the fly in a single loop.

By starting `res` at $n$ (the maximum bound) and continually adding the current index $i$ while subtracting the array value `nums[i]`, every present index $i$ and matching array value eventually offset each other. The single number in the range $[0, n]$ that does not have a matching value in `nums` will be left over in `res`.

---

## Step-by-Step Guide

1. Initialize `res` to the length of the array $n$. (This accounts for the largest number in the expected range $[0, n]$).
2. Start a loop that runs from index $i = 0$ up to $n - 1$.
3. In each iteration, add the current index $i$ to `res` and immediately subtract the array element `nums[i]` from `res`.
4. Observe the math balance out:
* The total addition over all loops will contribute $0 + 1 + 2 + \dots + (n - 1) + n$ (including the initial $n$).
* The total subtraction will remove all numbers actually present in `nums`.


5. After the loop finishes, all numbers present in the array cancel out their corresponding values, leaving only the missing number in `res`.
6. Return `res`.

---

## Complexity Analysis

* **Time Complexity:** $O(n)$

* **Space Complexity:** $O(1)$
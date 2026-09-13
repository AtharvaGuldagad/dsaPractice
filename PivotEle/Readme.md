# Find Pivot Index

## Intuition

### Total Sum & Running Prefix Balance

The pivot index is defined as the index where the sum of all elements strictly to its left equals the sum of all elements strictly to its right.

Instead of computing the left and right sums from scratch at every index using nested loops ($O(N^2)$), we can track the balance in linear time using prefix sums:

1. **Total Sum:** Compute the sum of the entire array `total`.
2. **Right Sum Deduction:** For any current index `i` with a known `leftSum`, the sum of elements to the right is simply:

$$\text{rightSum} = \text{total} - \text{leftSum} - \text{nums}[i]$$


3. **Equilibrium Check:** If $\text{leftSum} == \text{rightSum}$, `i` is the leftmost pivot index. Otherwise, we add $\text{nums}[i]$ to $\text{leftSum}$ and continue forward.

---

## Step-by-Step Guide

1. Calculate the total sum of all elements in `nums` and store it in `total`.
2. Initialize `leftSum = 0`.
3. Iterate `i` from `0` to `nums.length - 1`:
* Calculate `rightSum = total - leftSum - nums[i]`.
* If `leftSum == rightSum`, return index `i`.
* Add `nums[i]` to `leftSum`.


4. If no such pivot index exists, return `-1`.

---

## Complexity Analysis

* **Time Complexity:** $O(N)$
* Where $N$ is the length of `nums`. The algorithm makes two sequential linear passes: one to compute `total` and one to check for the pivot balance point. Each step performs $O(1)$ constant-time arithmetic operations.


* **Space Complexity:** $O(1)$
* Uses only primitive integer variables (`total`, `leftSum`, `rightSum`), requiring strictly constant auxiliary space.
# Permutations

## Intuition

### State Traversal with Boolean Visited Tracking

Unlike combinations or subsets where elements are selected in a fixed forward direction, permutations require exploring **all possible ordering sequences** of the entire input array.

To build permutations of length $N$:

1. At each step in the recursion tree, we iterate through all candidate indices from $0$ to $N - 1$.
2. A boolean array `picked` acts as a visited tracker, ensuring no single element is selected more than once in the active path `curr`.
3. When `curr.size() == nums.length`, a full permutation sequence is complete. We snapshot `curr` into `res` and backtrack by unmarking `picked[i] = false` to explore alternative branch permutations.

---

## Step-by-Step Guide

1. Initialize `res` to hold all generated permutations.
2. Call `bktk` with an empty path `curr`, the input array `nums`, and a boolean array `picked` of size `nums.length`.
3. **Backtracking Function (`bktk`):**
* **Base Case:** If `curr.size() == nums.length`, append a new snapshot `new ArrayList<>(curr)` to `res` and return.
* Iterate $i$ from $0$ to `nums.length - 1`:
* If `picked[i]` is `false`:
* Mark `picked[i] = true` and add `nums[i]` to `curr`.
* Recurse to build the next position: `bktk(curr, nums, picked)`.
* **Backtrack:** Remove the last element from `curr` and reset `picked[i] = false`.

4. Return `res`.

---

## Complexity Analysis

* **Time Complexity:** $O(N \cdot N!)$
* There are $N!$ unique permutations generated for an array of size $N$. At each leaf node of the decision tree, copying `curr` into `res` takes $O(N)$ time, yielding an overall runtime of $O(N \cdot N!)$.


* **Space Complexity:** $O(N)$
* Excluding the $O(N \cdot N!)$ memory needed to store the output list `res`, the extra space used by the `picked` array, `curr` list, and the recursion stack is bounded by $O(N)$ depth.
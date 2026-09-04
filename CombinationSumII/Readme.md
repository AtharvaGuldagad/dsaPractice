# Combination Sum II

## Intuition

### Sorting and Skip-Duplicate Pruning

Unlike Combination Sum I, each number in `nums` may only be used **once** per combination, and `nums` can contain duplicate values.

Your solution combines two key techniques to handle duplicates and prevent generating redundant combinations:

1. **Sorting:** Sorting the input array aligns identical values consecutively (e.g., `[1, 1, 2, 5]`).
2. **Duplicate Skipping via `while` Loop:** When making the **exclude** choice for `nums[i]`, skipping all identical adjacent elements (`while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;`) ensures that a duplicate value isn't selected in the same tree depth level to start a duplicate path.

While your code uses a global `Set<List<Integer>>` as a safety net, the sorting and skipping logic ensures unique combination branches during traversal.

---

## Step-by-Step Guide

1. **Pre-processing:**
* Sort `nums` in ascending order so duplicate numbers are adjacent.
* Initialize `curr = []` to store the current path and `sum = 0`.


2. **Backtracking Function (`bktk`):**
* **Success Base Case:** If `sum == target`, add a new copy of `curr` to the `res` Set and return.
* **Pruning Base Case:** If `sum > target` or `i == nums.length`, backtrack and return.
* **Include Choice:**
* Add `nums[i]` to `curr`.
* Recurse to the next index: `bktk(curr, i + 1, target, nums, sum + nums[i])`.


* **Exclude Choice (Skip Duplicates):**
* Remove the last added element from `curr`.
* Skip all duplicate values: `while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;`.
* Recurse to the next unique index: `bktk(curr, i + 1, target, nums, sum)`.




3. Return `res` converted to a `List`.

---

## Complexity Analysis

* **Time Complexity:** $O(2^N)$
* Sorting takes $O(N \log N)$ time. In the worst-case scenario with unique candidates, the backtracking decision tree has up to $2^N$ states (each element is either included or excluded). Copying valid combinations into `res` takes $O(N)$ time per combination, giving an overall bound of $O(N \cdot 2^N)$.


* **Space Complexity:** $O(N)$
* Excluding the space required for storing the result set, the maximum depth of the recursion stack and the size of `curr` are bounded by $N$ (the number of elements in `nums`).
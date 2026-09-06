# Subsets II

## Intuition

### Sorting and State Deduction

In Subsets II, the input array `nums` may contain duplicate elements, but the resulting power set must contain **no duplicate subsets**.

Your solution leverages a global `Set<List<Integer>>` combined with pre-sorting the array:

1. **Sorting:** Sorting `nums` ensures identical numbers are grouped together consecutively. This guarantees that equivalent subsets generated along different recursion paths (such as `[1, 2]` built from the first `2` vs. `[1, 2]` built from the second `2`) have identical element orderings.
2. **Set Deduplication:** When a leaf node is reached (`ind >= nums.length`), adding `new ArrayList<>(curr)` to the `Set` automatically filters out duplicate subset configurations.

---

## Step-by-Step Guide

1. Sort `nums` in ascending order so duplicate values align next to each other.
2. Initialize `curr` as an empty list to track the active path.
3. Call the recursive helper `backtrack(nums, 0, curr)`.
4. **Backtracking Function (`backtrack`):**
* **Base Case:** If `ind >= nums.length`, insert a copy of `curr` (`new ArrayList<>(curr)`) into the `res` Set and return.
* **Include Choice:**
* Append `nums[ind]` to `curr`.
* Recurse to the next index: `backtrack(nums, ind + 1, curr)`.


* **Exclude Choice (Backtrack):**
* Remove the last added element from `curr`.
* Recurse to the next index without including `nums[ind]`: `backtrack(nums, ind + 1, curr)`.




5. Return `res` converted into a `List`.

---

## Complexity Analysis

* **Time Complexity:** $O(n \cdot 2^n)$
* Sorting takes $O(n \log n)$ time. The decision tree generates $2^n$ leaf states. At each leaf, copying `curr` into the Set and computing its hash code takes $O(n)$ time, resulting in an overall time complexity of $O(n \cdot 2^n)$.


* **Space Complexity:** $O(n \cdot 2^n)$
* Beyond the $O(n)$ recursion call stack and `curr` array, storing all unique subsets inside the `Set` takes $O(n \cdot 2^n)$ space.
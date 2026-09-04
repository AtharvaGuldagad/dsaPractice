# Subsets

## Intuition

### Backtracking (Include / Exclude State Tree)

Generating all $2^n$ subsets (the power set) of a set of unique elements can be modeled as a binary decision tree of depth $n$:

* At each index `ind`, we make two distinct choices:
1. **Include** `nums[ind]` in the current subset `curr`.
2. **Exclude** `nums[ind]` from `curr` by removing it (backtracking).



When `ind` reaches `nums.length`, we have made a decision for every element in the array, representing a complete leaf state in the decision tree. A snapshot copy of `curr` is then saved to the result list `res`.

---

## Step-by-Step Guide

1. **State Tracking:**
* `res`: List of lists to store all valid subsets.
* `curr`: A dynamic list representing the path/subset built so far.


2. **Backtracking Function (`backtrack(nums, ind, curr)`):**
* **Base Case:** If `ind >= nums.length`, add a fresh copy of `curr` (`new ArrayList<>(curr)`) to `res` and return.
* **Include Choice:**
* Add `nums[ind]` to `curr`.
* Recurse to the next decision step: `backtrack(nums, ind + 1, curr)`.


* **Exclude Choice (Backtrack):**
* Remove the last added element from `curr` (`curr.remove(curr.size() - 1)`).
* Recurse to explore the decision path where `nums[ind]` was omitted: `backtrack(nums, ind + 1, curr)`.




3. Return `res`.

---

## Complexity Analysis

* **Time Complexity:** $O(n \times 2^n)$
* There are $2^n$ total subsets generated. For each of the $2^n$ leaf nodes, making a deep copy of `curr` into `res` takes $O(n)$ time, yielding an overall runtime of $O(n \times 2^n)$.


* **Space Complexity:** $O(n)$
* Excluding the $O(n \times 2^n)$ space required to hold the output list `res`, the extra auxiliary space used by the recursion call stack and `curr` list is $O(n)$ (bounded by the depth of the tree).
# Combination Sum

## Intuition

### Backtracking with Unbounded Selection

The goal is to find all unique combinations of candidate numbers that sum to `target`. Since candidates can be chosen an **unlimited number of times**, we model the decision process using a binary choice state space tree at each index `i`:

1. **Include `nums[i]`:** Add `nums[i]` to `curr`, subtract `nums[i]` from `target`, and recurse staying at index `i` (allowing reuse of the same element).
2. **Exclude `nums[i]`:** Backtrack by removing `nums[i]` from `curr`, keep `target` unchanged, and recurse advancing to index `i + 1`.

By restricting element selection to index `i` and forward indices, we naturally prevent duplicate combination permutations (e.g., generating `[2, 2, 3]` and `[3, 2, 2]`).

---

## Step-by-Step Guide

1. **State Tracking:**
* `curr`: Dynamic list tracking the elements in the current path.
* `target`: Remaining sum needed to complete a valid combination.
* `i`: Current array index under consideration.


2. **Backtracking Function (`bktk(curr, i, target, nums)`):**
* **Success Base Case:** If `target == 0`, a valid combination is found. Append a copy of `curr` (`new ArrayList<>(curr)`) to `res` and return.
* **Pruning Base Case:** If `target < 0` or `i >= nums.length`, the current path is invalid; return immediately.
* **Take Current Element (Include):**
* Append `nums[i]` to `curr`.
* Recurse stay at index `i`: `bktk(curr, i, target - nums[i], nums)`.


* **Skip Current Element (Exclude/Backtrack):**
* Remove the last added element from `curr`.
* Recurse to the next candidate: `bktk(curr, i + 1, target, nums)`.




3. Return `res`.

---

## Complexity Analysis

* **Time Complexity:** $O(2^{\frac{T}{M}})$
* Where $T$ is the `target` value and $M$ is the minimum value in `nums`. In the worst-case, the maximum depth of the recursion tree is $\frac{T}{M}$. At each step, we make 2 recursive calls, leading to an exponential runtime upper-bounded by $O(2^{T/M})$.


* **Space Complexity:** $O(\frac{T}{M})$
* Excluding the space required to store the final result combinations, the maximum recursion stack depth and the size of `curr` are bounded by $\frac{T}{M}$.
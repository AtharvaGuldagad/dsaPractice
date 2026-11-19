# Min Cost Climbing Stairs

## Intuition

### Bottom-Up Tabulation & Top-of-Stairs Definition

The goal is to reach the **top of the floor**, which sits one index past the last stair at index `n` (`cost.length`). Because you can start at either index `0` or index `1` for free, reaching steps `0` and `1` costs `0`.

1. **State Definition (`dp[i]`):** Represents the minimum cumulative cost required to *arrive at* step `i`.
2. **Base Cases:** `dp[0] = 0` and `dp[1] = 0` (Java's `new int[n + 1]` initializes these automatically).
3. **State Transition:** To arrive at step `i`, you must either step from `i - 1` (paying `cost[i - 1]`) or jump from `i - 2` (paying `cost[i - 2]`):

$$\text{dp}[i] = \min(\text{dp}[i - 1] + \text{cost}[i - 1], \; \text{dp}[i - 2] + \text{cost}[i - 2])$$


4. **Space Optimization ($O(1)$):** Just like *Climbing Stairs*, `dp[i]` only depends on the two preceding states (`dp[i - 1]` and `dp[i - 2]`), meaning the entire `dp` array can be replaced with two rolling integer variables (`prev1` and `prev2`).

---

## Step-by-Step Guide

1. **Initialize DP Table:**
* Let `n = cost.length`.
* Allocate `int[] dp = new int[n + 1]`, where `dp[0] = 0` and `dp[1] = 0`.


2. **Compute Minimum Cost Iteratively:**
* Loop `i` from `2` up to `n`:
* Set `dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2])`.




3. **Return Final Destination Cost:**
* Return `dp[n]`, representing the minimum cost to reach the top floor beyond `cost[n - 1]`.



---

## Complexity Analysis

* **Time Complexity:** **$O(N)$**
* Where $N$ is `cost.length`. The loop runs $N - 1$ times, performing $O(1)$ arithmetic and comparison operations per step.


* **Space Complexity:** **$O(N)$**
* Allocates an integer array `dp` of size $N + 1$. *(Replacing `dp` with two primitive variables reduces auxiliary space to $O(1)$).*
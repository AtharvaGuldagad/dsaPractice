# Stone Game V

## Intuition

### Interval Dynamic Programming (Min-Sum Split Decision)

Alice divides the current row of stones $[l, r]$ into two non-empty parts: a left section $[l, k]$ and a right section $[k + 1, r]$. Bob then forces Alice to continue the game on the section with the **strictly smaller sum** (Alice scores that smaller sum), discarding the larger section. If the two parts have equal sums, Alice is allowed to choose which part to keep.

Because the decision at range $[l, r]$ depends directly on smaller sub-intervals $[l, k]$ and $[k + 1, r]$, this naturally fits **Interval Dynamic Programming**:

* **$\text{leftSum} < \text{rightSum}$:** Keep the left part $\rightarrow \text{Score} = \text{leftSum} + \text{solve}(l, k)$.
* **$\text{leftSum} > \text{rightSum}$:** Keep the right part $\rightarrow \text{Score} = \text{rightSum} + \text{solve}(k + 1, r)$.
* **$\text{leftSum} == \text{rightSum}$:** Alice picks the better option $\rightarrow \text{Score} = \max(\text{leftSum} + \text{solve}(l, k), \text{rightSum} + \text{solve}(k + 1, r))$.

### Branch-and-Bound Pruning Optimizations

The maximum score Alice can possibly get from keeping a part of sum $S$ is upper-bounded by $S + S = 2S$ (since any further sub-game score cannot exceed the sum of the stones in that sub-game):

1. If $\text{ans} \ge 2 \times \text{leftSum}$, continuing on the left part cannot beat the current best score $\text{ans}$, so we `continue`.
2. As $k$ increases, $\text{rightSum}$ strictly decreases. If $\text{ans} \ge 2 \times \text{rightSum}$, every future split will have an even smaller $\text{rightSum}$, allowing an early `break`.

---

## Step-by-Step Guide

1. Compute the prefix sum array `prefix` where $\text{prefix}[i + 1] = \sum_{j=0}^{i} a[j]$ to allow $O(1)$ range sum lookups.
2. Initialize a 2D memoization table `dp[n][n]` with `-1`.
3. In `solve(l, r)`:
* **Base Case:** If $l \ge r$ (single stone or invalid range), return `0` (no more splits possible).
* **Memoization Check:** If `dp[l][r] != -1`, return the cached result.
* Initialize `leftSum = 0` and `rightSum` as the total sum of range $[l, r]$.
* Iterate split point $k$ from $l$ to $r - 1$:
* Add $a[k]$ to `leftSum` and subtract $a[k]$ from `rightSum`.
* Apply pruning conditions and evaluate the three cases ($\text{leftSum} < \text{rightSum}$, $\text{leftSum} > \text{rightSum}$, or $\text{leftSum} == \text{rightSum}$) to maximize `ans`.




4. Store the maximum answer in `dp[l][r]` and return it.

---

## Complexity Analysis

* **Time Complexity:** $O(N^3)$
* There are $O(N^2)$ distinct intervals $[l, r]$. For each interval, we iterate over $k$ from $l$ to $r - 1$ ($O(N)$ operations). Pruning significantly reduces runtime in practice.


* **Space Complexity:** $O(N^2)$
* The 2D DP array requires $O(N^2)$ auxiliary space, while the recursion call stack takes $O(N)$ depth.
# Climbing Stairs

## Intuition

### Fibonacci Equivalence & Shifted Indexing

The "Climbing Stairs" problem asks for the number of distinct ways to reach step $n$ when taking either $1$ or $2$ steps at a time:

* To reach step $i$, you must either come from step $i - 1$ (taking $1$ step) or step $i - 2$ (taking $2$ steps).
* Thus, the state transition is:

$$\text{dp}[i] = \text{dp}[i - 1] + \text{dp}[i - 2]$$



### Index Shift Analysis

Your code maps the base cases as follows:

* `memo[0] = 1` representing $1$ step ($n = 1$).
* `memo[1] = 2` representing $2$ steps ($n = 2$).

Because step $1$ is stored at index `0` and step $2$ is stored at index `1`, step $n$ resides at index `n - 1`. Returning `memo[n - 1]` produces the correct answer for $n \ge 1$.

---

## Step-by-Step Guide

1. **Base Case Guard:** If $n < 2$, return $n$ directly.
2. **Tabulation Setup:**
* Allocate `memo` array of size $n + 1$.
* Set `memo[0] = 1` (ways to climb 1 step).
* Set `memo[1] = 2` (ways to climb 2 steps).


3. **Transition Iteration (0-indexed):**
* Iterate $i$ from $2$ up to $n - 1$:
* Calculate `memo[i] = memo[i - 1] + memo[i - 2]`.




4. Return `memo[n - 1]`.

---

## Complexity Analysis

* **Time Complexity:** $O(n)$
* Performs a single linear loop from $2$ to $n - 1$, taking $O(1)$ constant time per iteration.


* **Space Complexity:** $O(n)$
* Allocates an array of size $n + 1$.
* *(Can be optimized to $O(1)$ auxiliary space using two dynamic scalar variables).*
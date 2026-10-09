# Fibonacci Number (Bottom-Up Dynamic Programming)

## Intuition

### Tabulation vs. Memoization

Although your function is named `dp` and accepts a `memo` array, this implementation is actually **Bottom-Up Dynamic Programming (Tabulation)** rather than Top-Down Memoization.

1. **State Definition:** `memo[i]` stores the $i$-th Fibonacci number.
2. **Base Cases:** $F(0) = 0$ and $F(1) = 1$.
3. **State Transition:** $F(i) = F(i - 1) + F(i - 2)$ for $i \ge 2$.

By filling the table iteratively from index $2$ up to $n$, we eliminate the recursion stack overhead entirely and solve each subproblem in $O(1)$ time.

---

## Step-by-Step Guide

1. Base Case# Fibonacci Number

## Intuition

### Tabulation (Bottom-Up DP) & Space Optimization

Your implementation converts the basic dynamic programming pattern into an iterative **bottom-up tabulation** solution. Instead of computing subproblems recursively (which risks call stack overflow for large $N$), it builds the Fibonacci sequence sequentially from base cases $0$ and $1$ up to $n$.

Notice that to compute `memo[i]`, you only ever need the two previous states: `memo[i - 1]` and `memo[i - 2]`. Storing the full `memo` array of size $n + 1$ requires $O(n)$ extra memory. We can optimize this space down to **$O(1)$ constant space** by retaining only two dynamic integer variables (`prev2` and `prev1`).

---

## Step-by-Step Guide

1. **Base Case Check:**
* If $n < 2$, return $n$ directly ($F(0) = 0$, $F(1) = 1$).


2. **State Allocation:**
* Initialize `memo[0] = 0` and `memo[1] = 1`.


3. **Bottom-Up Transition Loop:**
* Iterate $i$ from $2$ up to $n$:
* Apply state transition formula: `memo[i] = memo[i - 1] + memo[i - 2]`.




4. Return `memo[n]`.

---

## Complexity Analysis

* **Time Complexity:** $O(n)$
* Computes each index from $2$ to $n$ exactly once in a single linear pass.


* **Space Complexity:** $O(n)$
* Allocates an array `memo` of size $n + 1$.
* *(Space-optimized version achieves $O(1)$ space using two primitive variables).*
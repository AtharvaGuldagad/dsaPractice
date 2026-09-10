# Majority Element

## Intuition

### Boyer-Moore Majority Vote Algorithm

The problem assumes that a majority element always exists (appearing more than $\lfloor n / 2 \rfloor$ times). This allows us to use the **Boyer-Moore Voting Algorithm** to find the majority element in $O(n)$ time and $O(1)$ space, avoiding the $O(n)$ space requirement of a hash map or $O(n \log n)$ sorting.

The algorithm relies on a balance/cancellation principle:

1. Maintain a candidate element `res` and a counter `count`.
2. As we iterate through `nums`:
* If `count == 0`, we pick the current element `num` as our new candidate `res`.
* If `num == res`, increment `count` (supporting vote).
* If `num != res`, decrement `count` (opposing vote).



Because the majority element occurs strictly more than half the time, its total positive votes will outweigh all other non-majority elements combined. Even if its counter gets decremented to 0 along the way, it is guaranteed to be the final candidate standing at the end.

---

## Step-by-Step Guide

1. Initialize candidate tracker `res = 0` and vote balance counter `count = 0`.
2. Traverse through each element `num` in `nums`:
* If `count == 0`, assign `res = num`.
* Increment `count` by `1` if `num == res`; otherwise, decrement `count` by `1`.


3. Return `res`.

---

## Complexity Analysis

* **Time Complexity:** $O(N)$
* Where $N$ is the length of `nums`. Performs a single linear pass over the array with constant-time $O(1)$ state updates per element.


* **Space Complexity:** $O(1)$
* Operates strictly using primitive variables `res` and `count`, taking $O(1)$ auxiliary memory.
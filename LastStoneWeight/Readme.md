# Last Stone Weight

## Intuition

### Sorted Array Simulation vs. Max-Heap

In each turn, the two heaviest stones are smashed together:

* If the weights are equal, both stones are completely destroyed.
* If the weights are unequal ($y > x$), a new stone of weight $y - x$ is formed and added back.

Your current solution maintains a sorted array throughout the simulation:

1. **Initial Sort:** Sort `stones` in ascending order so the two heaviest stones reside at the end (`stones[n - 1]` and `stones[n - 2]`).
2. **Binary Search Insertion:** When a smash leaves a remaining weight `cur = stones[n - 1] - stones[n - 2]`, use binary search (`Arrays.binarySearch` / `l < r`) to locate the insertion index `pos` in $O(\log n)$ time, then shift elements right to maintain the sorted invariant.

---

### Max-Heap / PriorityQueue Alternative

While binary search finds the insertion index in $O(\log n)$, shifting array elements and resizing still takes $O(n)$ time per smash. A **Max-Heap** (`PriorityQueue` with reverse ordering) optimizes both finding the top two elements and reinserting the difference directly in $O(\log n)$ time.

---

## Step-by-Step Guide

1. Sort the input array `stones` in ascending order and track the active count `n = stones.length`.
2. Enter a loop that continues as long as `n > 1`:
* Calculate the difference between the two heaviest stones: `cur = stones[n - 1] - stones[n - 2]`.
* Decrease the active size by $2$ (`n -= 2`).
* **If `cur > 0`:**
* Perform binary search over range $[0, n]$ to find the insertion index `pos` where `cur` should be placed.
* Increment `n++` and expand the array using `Arrays.copyOf(stones, n)`.
* Shift all elements from `n - 1` down to `pos + 1` one step to the right.
* Place `cur` at `stones[pos]`.




3. If $n > 0$, return the last remaining stone `stones[0]`; otherwise, return `0`.

---

## Complexity Analysis

* **Time Complexity:** $O(N^2)$
* Initial sorting takes $O(N \log N)$.
* There are at most $N$ smash rounds. In each round, binary search takes $O(\log N)$, but array resizing and element shifting take $O(N)$ time. This yields an overall time complexity of $O(N^2)$.
* *(Note: Using a `PriorityQueue` / Max-Heap reduces the total time to $O(N \log N)$).*


* **Space Complexity:** $O(N)$
* Memory is reallocated via `Arrays.copyOf` on each insertion, consuming $O(N)$ auxiliary space.
* *(Note: In-place Max-Heap / PriorityQueue takes $O(N)$ auxiliary space).*
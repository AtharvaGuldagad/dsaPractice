# K Closest Points to Origin

## Intuition

### Max-Heap vs. Min-Heap Strategy

Your current implementation uses a **Min-Heap** that stores all $N$ elements and then extracts the top $k$ points. While functionally correct, storing all $N$ elements requires $O(N \log N)$ time and $O(N)$ space.

We can optimize both time and space by using a **Max-Heap bounded to size $k$**:

1. **Squared Distance:** The Euclidean distance to origin $(0,0)$ is $\sqrt{x^2 + y^2}$. To avoid floating-point operations, we compare squared distances directly ($x^2 + y^2$).
2. **Bounded Max-Heap:** By maintaining a Max-Heap configured to compare points by their distance, the root always holds the *farthest* point among our current $k$ closest candidates.
3. **Eviction:** When the heap size exceeds $k$, we evict the top element (`maxHeap.poll()`). This discards the farthest point seen so far, ensuring we only retain the $k$ closest points in $O(N \log k)$ time and $O(k)$ space.

---

## Step-by-Step Guide

1. **Initialize Max-Heap:** Create a `PriorityQueue<int[]>` configured with a custom comparator that sorts points in descending order of their squared distance: `(a, b) -> Integer.compare(b[0]*b[0] + b[1]*b[1], a[0]*a[0] + a[1]*a[1])`.
2. **Iterate Points:** For each point `p` in `points`:
* Push `p` into `maxHeap`.
* If `maxHeap.size() > k`, poll and remove the farthest point from the heap.


3. **Extract Result:** Pop all $k$ remaining points from the heap into the output matrix `res[k][2]`.
4. Return `res`.

---

## Complexity Analysis

* **Time Complexity:**
* **Your Min-Heap Code:** $O(N \log N)$ — Heapifying all $N$ elements takes $O(N \log N)$ time, and extracting $k$ elements takes $O(k \log N)$ time.
* **Optimized Max-Heap:** $O(N \log k)$ — Maintaining a heap of size $k$ across $N$ elements takes $O(\log k)$ time per element.
* *(Note: Quickselect achieves $O(N)$ average time complexity).*


* **Space Complexity:**
* **Your Min-Heap Code:** $O(N)$ auxiliary space to hold all points inside the heap.
* **Optimized Max-Heap:** $O(k)$ auxiliary space, storing at most $k + 1$ elements in memory.
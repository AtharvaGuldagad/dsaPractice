# Kth Largest Element in a Stream

## Intuition

### Fixed-Size Min-Heap Strategy

To keep track of the $k$-th largest element in a continuous stream of numbers, we do not need to store or sort all numbers seen so far. We only need to maintain the **$k$ largest elements** overall.

A **Min-Heap** of capacity $k$ provides the ideal structure:

* The smallest element among the $k$ largest elements is always positioned at the root (`peek()`).
* By keeping the heap size strictly at $k$, the root node naturally represents the $k$-th largest element in the stream.
* When a new value arrives, we push it into the heap. If the size exceeds $k$, we immediately remove the smallest element (`poll()`). This guarantees that only the top $k$ largest values remain in the heap.

---

## Step-by-Step Guide

1. **Class Fields:**
* Initialize a `PriorityQueue<Integer> minHeap` (defaults to natural ascending order in Java).
* Store the target rank `k`.


2. **Constructor (`KthLargest(k, nums)`):**
* Assign `this.k = k`.
* Loop through each number in `nums`:
* Insert into `minHeap` via `minHeap.offer(num)`.
* If `minHeap.size() > k`, evict the root via `minHeap.poll()`.




3. **`add(val)` Method:**
* Push `val` into `minHeap`.
* If `minHeap.size() > k`, remove the smallest element with `minHeap.poll()`.
* Return `minHeap.peek()` (the root is guaranteed to be the $k$-th largest element).



---

## Complexity Analysis

* **Time Complexity:**
* **Constructor:** $O(N \log k)$, where $N$ is the length of `nums`. Each insertion and potential eviction takes $O(\log k)$ time.
* **`add(val)`:** $O(\log k)$. Pushing to and popping from a heap bounded by size $k$ takes logarithmic time relative to $k$.


* **Space Complexity:** $O(k)$
* The `minHeap` holds at most $k$ elements at any given point, requiring $O(k)$ auxiliary memory regardless of how many stream items are processed.
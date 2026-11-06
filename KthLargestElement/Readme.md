# Kth Largest Element in an Array

## Intuition

### Min-Heap for Top-K Element Tracking

To find the $k$-th largest element in an unsorted array, we can use a **Min-Heap** of size $k$:

1. **Size-Bounded Heap:** By keeping at most $k$ elements in the min-heap as we iterate through `nums`, the heap root (`minHeap.peek()`) always holds the smallest element among the top $k$ largest elements seen so far.
2. **Eviction of Smaller Elements:** Whenever the heap size exceeds $k$, we evict the top element (`minHeap.poll()`). Because it is a min-heap, this discards the smallest element overall from our candidate set of top elements.
3. **Result:** After processing all numbers in `nums`, the min-heap contains the $k$ largest elements of the array, and the element at the top is the $k$-th largest.

---

## Step-by-Step Guide

1. **Initialize Min-Heap:** Create a `PriorityQueue<Integer> minHeap = new PriorityQueue<>(k)`.
2. **Process Array Elements:** Iterate over each integer `n` in `nums`:
* Push `n` into `minHeap`: `minHeap.offer(n)`.
* If `minHeap.size() > k`, evict the smallest element: `minHeap.poll()`.


3. **Extract Result:** Return `minHeap.peek()`, which is the $k$-th largest element.

---

## Complexity Analysis

* **Time Complexity:** $O(N \log k)$
* Where $N$ is the number of elements in `nums`. Adding an element to a heap of size at most $k+1$ takes $O(\log k)$ time. We do this for all $N$ elements, resulting in an overall runtime of $O(N \log k)$.


* **Space Complexity:** $O(k)$
* The min-heap stores at most $k + 1$ elements at any point during iteration.
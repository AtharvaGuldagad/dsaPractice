# Find Median from Data Stream

## Intuition

### Two-Heap Partitioning (Max-Heap + Min-Heap)

To retrieve the running median in $O(1)$ time as numbers arrive dynamically, we partition the stream into two balanced halves:

1. **Lower Half (`smolHp` — Max-Heap):** Stores the smaller half of the numbers. Because it is a Max-Heap, `smolHp.peek()` gives the **largest** element of the lower half in $O(1)$ time.
2. **Upper Half (`bigHp` — Min-Heap):** Stores the larger half of the numbers. Because it is a Min-Heap, `bigHp.peek()` gives the **smallest** element of the upper half in $O(1)$ time.
3. **Two Core Invariants:**
* **Order Invariant:** Every element in `smolHp` must be $\le$ every element in `bigHp` (`smolHp.peek() <= bigHp.peek()`).
* **Size Invariant:** The sizes of the two heaps differ by at most `1` (`|smolHp.size() - bigHp.size()| <= 1`).


4. **Integer Overflow Note in Comparator:** Writing `(a, b) -> b - a` can overflow if `b` is a large positive integer (e.g., `Integer.MAX_VALUE`) and `a` is a large negative integer (e.g., `Integer.MIN_VALUE`). Using `Collections.reverseOrder()` or `Comparator.reverseOrder()` avoids integer subtraction overflow entirely.

---

## Step-by-Step Guide

1. **Initialize Heaps (`MedianFinder()`):**
* `smolHp = new PriorityQueue<>(Collections.reverseOrder())` (Max-Heap for the lower half).
* `bigHp = new PriorityQueue<>()` (Min-Heap for the upper half).


2. **Insert Number (`addNum(int num)`):**
* Push `num` into `smolHp` first.
* **Enforce Order & Size Balance:** If `smolHp.size() - bigHp.size() > 1` OR (`!bigHp.isEmpty() && smolHp.peek() > bigHp.peek()`), pop the top element from `smolHp` and move it into `bigHp`.
* **Rebalance if `bigHp` Grew Too Large:** If `bigHp.size() - smolHp.size() > 1`, pop the top element from `bigHp` and move it back into `smolHp`.


3. **Compute Median (`findMedian()`):**
* If `smolHp.size() == bigHp.size()`, return `(smolHp.peek() + bigHp.peek()) / 2.0` (note: casting to `double` before addition, e.g., `((double) bigHp.peek() + smolHp.peek()) / 2`, also prevents `int` addition overflow if two large values are summed).
* Otherwise, return the `.peek()` of whichever heap currently holds one extra element.



---

## Complexity Analysis

* **Time Complexity:**
* `addNum`: **$O(\log N)$** — At most two heap insertions and two heap extractions occur per call, each taking $O(\log(N/2)) = O(\log N)$ time.
* `findMedian`: **$O(1)$** — Directly peeks at the root(s) of the two heaps.


* **Space Complexity:** **$O(N)$**
* All $N$ elements from the stream are stored across `smolHp` and `bigHp`.
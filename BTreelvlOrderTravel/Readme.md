# Binary Tree Level Order Traversal

## Intuition

### Breadth-First Search (BFS) with Queue

Level order traversal visits a binary tree level by level from top to bottom, left to right. This natural horizontal order maps directly to a **Breadth-First Search (BFS)** algorithm managed by a First-In, First-Out (FIFO) **Queue**.

---

### Key Mechanism: Snapshotted Queue Length

The critical design pattern in level order traversal is separating nodes level by level instead of flattening them into a single list.

To do this, we measure the size of the queue at the start of each level iteration (`int i = q.size()`). That snapshot tells us *exactly* how many nodes belong to the current depth level. As we dequeue and process those specific nodes, any new child nodes added to the queue will automatically wait for the *next* level iteration to be processed.

---

## Step-by-Step Guide

1. Create a master list `res` to collect sublists for each tree level.
2. Initialize a FIFO `Queue` and enqueue the `root` node.
3. Begin a loop that continues as long as the queue is not empty:
* Create an empty list `lvl` to hold values for the active level.
* Snapshot the current queue size (`int i = q.size()`) to determine how many elements belong strictly to this level.
* Run a loop from this snapshot size down to 1:
* Dequeue (`poll()`) the next node from the queue.
* If the node is valid (`non-null`), add its value to `lvl` and enqueue its left and right children.


* If `lvl` contains elements, append it to `res`.


4. Return `res` after processing all levels.

---

## Complexity Analysis

* **Time Complexity:** $O(N)$
* Every node in the binary tree is enqueued and dequeued exactly once. Reading node values and enqueueing children takes $O(1)$ constant time per node, yielding linear time overall relative to total nodes $N$.


* **Space Complexity:** $O(W)$
* The auxiliary space is determined by the maximum number of nodes stored in the queue at any single point, which equals the maximum width $W$ of the binary tree.
* In a fully balanced binary tree, the bottom level holds up to $\lceil N / 2 \rceil$ nodes, making the worst-case auxiliary space $O(N)$.
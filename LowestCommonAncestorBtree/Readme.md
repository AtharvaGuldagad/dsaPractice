# Lowest Common Ancestor of a Binary Search Tree

## Intuition

### The Split Point in a BST

In a Binary Search Tree (BST), every node follows a strict ordering property:

* All values in the **left subtree** are strictly smaller than the node's value.
* All values in the **right subtree** are strictly larger than the node's value.

Because of this property, finding the Lowest Common Ancestor (LCA) of two nodes $p$ and $q$ boils down to finding the **split point** where $p$ and $q$ diverge:

1. **Both $p$ and $q$ are smaller than `curr`:** The LCA must lie somewhere in the left subtree. We step left.
2. **Both $p$ and $q$ are larger than `curr`:** The LCA must lie somewhere in the right subtree. We step right.
3. **One node is smaller and the other is larger (or `curr` equals $p$ or $q$):** `curr` is the exact split point where $p$ and $q$ branch off in opposite directions (or one is an ancestor of the other). Thus, `curr` is guaranteed to be the Lowest Common Ancestor.

By converting the recursive approach into an **iterative loop**, we eliminate the function call stack entirely, achieving optimal $O(1)$ constant auxiliary space.

---

## Step-by-Step Guide

1. Start a traversal pointer `curr` at the `root` node of the BST.
2. Enter a loop that continues as long as `curr` is not `null`:
* Compare the values of $p$ and $q$ against `curr.val`.
* **If both values are strictly smaller (`p.val < curr.val && q.val < curr.val`):** Both target nodes reside in the left branch. Move `curr` to `curr.left`.
* **If both values are strictly larger (`p.val > curr.val && q.val > curr.val`):** Both target nodes reside in the right branch. Move `curr` to `curr.right`.
* **Otherwise (The Split Point):** You have found the lowest node that serves as a common ancestor. Return `curr` immediately.


3. If the loop terminates without finding a split point, return `null`.

---

## Complexity Analysis

* **Time Complexity:** $O(H)$
* Where $H$ is the height of the Binary Search Tree. At each step of the traversal, we eliminate one whole subtree (either left or right), moving down one level in the tree.
* **Balanced Tree:** $H = O(\log N)$, where $N$ is the total number of nodes.
* **Skewed Tree (Worst-Case):** $H = O(N)$, when the tree degenerates into a single long line.


* **Space Complexity:**
* **Iterative Approach:** $O(1)$ constant auxiliary space, as it only uses a single pointer (`curr`) without allocating call stack memory.
* **Recursive Approach:** $O(H)$ auxiliary space to maintain the recursion call stack.

# Maximum Depth of Binary Tree

## Intuition

### Post-Order Recursive Traversal

The maximum depth of a binary tree represents the length of the longest path from the root node down to the farthest leaf node.

Because a binary tree is inherently recursive, the depth of any tree rooted at a given node can be broken down into a simple formula:

$$\text{Depth}(\text{node}) = 1 + \max(\text{Depth}(\text{left child}), \text{Depth}(\text{right child}))$$

We use a post-order Depth-First Search (DFS) traversal:

1. Traverse down to the bottom-most subtrees until hitting empty nodes (`null`).
2. Calculate the maximum depth between the left and right subtrees.
3. Add `1` to account for the current node itself as the unwinding stack returns values up to the root.

---

## Step-by-Step Guide

1. **Base Case Check:** Look at the current node `root`. If it is `null`, there are no nodes along this path, so return `0`.
2. **Recursive Steps:**
* Call `maxDepth(root.left)` to recursively compute the maximum depth of the left subtree.
* Call `maxDepth(root.right)` to recursively compute the maximum depth of the right subtree.


3. **Combine Results:**
* Take the maximum of the left depth and right depth: `Math.max(leftDepth, rightDepth)`.
* Add `1` for the current node itself (`1 + Math.max(...)`).


4. **Return:** Hand the calculated depth value back up to the parent caller.

---

## Complexity Analysis

* **Time Complexity:** $O(N)$
* We visit every node in the binary tree of size $N$ exactly once. At each node, calculating the maximum between its children's depths takes $O(1)$ constant time operations. Thus, execution time scales strictly linearly with $N$.


* **Space Complexity:** $O(H)$
* The auxiliary space is determined by the maximum depth of the implicit recursive call stack, where $H$ is the height of the tree.
* In the worst-case scenario (a completely skewed tree like a linked list), $H = N$, resulting in $O(N)$ space complexity.
* In the best-case scenario (a completely balanced tree), $H = \log N$, giving $O(\log N)$ space complexity.
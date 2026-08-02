# Invert Binary Tree

## Intuition

### The Mirror Reflection Strategy

Inverting a binary tree (often jokingly referred to as the infamous Homebrew interview question) means swapping every node's left and right subtrees so that the whole tree becomes its mirror image.

The process is inherently recursive: to mirror a binary tree rooted at `root`, we simply:

1. Recursively mirror its entire left subtree.
2. Recursively mirror its entire right subtree.
3. Swap the left and right pointers of the current `root` node.

### A Subtle Detail in Your Implementation

Your code successfully solves the problem! However, notice how `temp` is instantiated as `new TreeNode()` on every function call. While `temp.left = root.left` works perfectly to store the reference, instantiating a whole new node object isn't necessary. You can simplify this by using a plain node pointer reference variable (`TreeNode temp = root.left`), which avoids creating extra unused objects in memory.

---

## Step-by-Step Guide

1. **Base Case Check:** Look at the current node `root`. If it is `null`, there's nothing to mirror. Return `null` immediately.
2. **Recursive Descent:**
* Recursively call `invertTree(root.left)` to flip the entire left branch.
* Recursively call `invertTree(root.right)` to flip the entire right branch.


3. **Pointer Swap:**
* Store a temporary reference to the inverted left subtree.
* Point `root.left` to the inverted right subtree.
* Point `root.right` to the stored left subtree reference.


4. **Return:** Hand back the modified `root` node to its parent.

---

## Complexity Analysis

* **Time Complexity:** $O(N)$
* We visit every node in the binary tree exactly once. At each node, swapping pointers takes $O(1)$ constant time. Thus, execution time scales strictly linearly with the total number of nodes $N$.


* **Space Complexity:** $O(H)$
* The auxiliary space is determined by the call stack created by recursion, where $H$ is the height of the tree.
* In the worst-case scenario (a completely skewed tree like a linked list), $H = N$, resulting in $O(N)$ space.
* In the best-case scenario (a balanced tree), $H = \log N$, giving $O(\log N)$ space complexity.
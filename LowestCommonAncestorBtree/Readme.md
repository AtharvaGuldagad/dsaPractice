# Subtree of Another Tree

## Intuition

### Tree Matching via Recursive Search

To determine if `subRoot` is a valid subtree of `root`, we need to find a node somewhere inside `root` that acts as the starting point for a tree structure identical to `subRoot`.

The problem naturally breaks down into two core checks:

1. **Primary Search (`isSubtree`):** Traverses through every node in `root` to test if that node could be the root of a matching subtree.
2. **Structural Equality (`sameTree`):** A helper function that takes two node references and checks if the trees rooted at those nodes are exact matches in both structure and node values.

For every node we visit in `root`, we check if `sameTree(root, subRoot)` is true. If it matches, we are done. If it doesn't, we recursively search down `root.left` and `root.right` to see if a match exists further down.

---

## Step-by-Step Guide

1. **Base Cases (`isSubtree`):**
* If `subRoot` is `null`, it is trivially a subtree of any tree—return `true`.
* If `root` is `null` (and `subRoot` is not), `subRoot` cannot exist inside an empty tree—return `false`.


2. **Current Node Check:**
* Call `sameTree(root, subRoot)`. If it returns `true`, we found an exact match starting at the current node. Return `true`.


3. **Recursive Search:**
* If the current node doesn't match, check if `subRoot` is a subtree of the left child (`isSubtree(root.left, subRoot)`) **OR** the right child (`isSubtree(root.right, subRoot)`).


4. **Helper Logic (`sameTree`):**
* If both nodes are `null`, return `true`.
* If both nodes are non-null and have identical values (`root.val == subRoot.val`), recursively verify that both their left subtrees and right subtrees match.
* Otherwise, return `false`.



---

## Complexity Analysis

* **Time Complexity:** $O(N \times M)$
* Let $N$ be the number of nodes in `root` and $M$ be the number of nodes in `subRoot`. In the worst-case scenario (such as a tree where many nodes share identical values with `subRoot`), `isSubtree` visits all $N$ nodes, and for each node, `sameTree` scans up to $M$ nodes.


* **Space Complexity:** $O(H_{root})$
* The auxiliary space is determined by the call stack depth, where $H_{root}$ is the height of `root`. In a completely skewed tree, this requires $O(N)$ space, whereas a balanced tree requires $O(\log N)$ space.
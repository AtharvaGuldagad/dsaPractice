# Diameter of Binary Tree

## Intuition

### Path Length vs. Tree Height

The diameter of a binary tree is defined as the length of the longest path between **any two nodes**. This path may or may not pass through the root node.

The length of a path passing *through* a given node as its highest point is equal to:

$$\text{Path Length} = \text{Height of Left Subtree} + \text{Height of Right Subtree}$$

### Bottom-Up DFS Optimization

A naive approach might compute the left and right subtree heights for every single node individually, leading to an $O(N^2)$ algorithm.

Instead, we can use a bottom-up Depth-First Search (DFS) post-order traversal to calculate heights and track the maximum diameter simultaneously:

1. Every recursive call computes and returns the **height** of the current subtree: $1 + \max(\text{left}, \text{right})$.
2. Before returning that height to its parent, the node evaluates the potential diameter passing through itself ($\text{left} + \text{right}$) and updates a global/mutable maximum variable (`res[0]`).

By bundling these operations into a single traversal, we calculate the tree's maximum diameter in a single pass.

---

## Step-by-Step Guide

1. Create a single-element array `res = new int[1]` initialized to zero. This serves as a mutable integer passed by reference to store the maximum diameter found anywhere in the tree.
2. Start the recursive `dfs` helper function at the root of the tree.
3. **Base Case:** If the current node is `null`, return `0` (the height of an empty tree is zero).
4. **Recursive Steps:**
* Recursively call `dfs(root.left, res)` to calculate the height of the left subtree.
* Recursively call `dfs(root.right, res)` to calculate the height of the right subtree.


5. **Update Maximum Diameter:**
* Calculate the longest path passing through the current node: `left + right`.
* Update `res[0]` if this path length is greater than the best diameter recorded so far (`Math.max(res[0], left + right)`).


6. **Return Height:**
* Hand back the height of the current subtree ($1 + \max(\text{left}, \text{right})$) up to the parent node.


7. Once the recursion unwinds back to the top, return `res[0]`, which contains the overall maximum diameter.

---

## Complexity Analysis

* **Time Complexity:** $O(N)$
* Every node in the binary tree of size $N$ is visited exactly once during the DFS traversal. At each node, computing the maximum path and returning the height takes $O(1)$ constant time operations. Thus, execution time scales strictly linearly with $N$.


* **Space Complexity:** $O(H)$
* The auxiliary space is determined by the maximum depth of the recursive call stack, where $H$ is the height of the tree.
* In the worst-case scenario (a completely skewed tree like a linked list), $H = N$, resulting in $O(N)$ space complexity.
* In the best-case scenario (a balanced tree), $H = \log N$, giving $O(\log N)$ space complexity.
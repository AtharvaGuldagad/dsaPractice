# Construct Binary Tree from Preorder and Inorder Traversal

## Intuition

### Dividing Subtrees via Root Mapping

The two traversal arrays give us complementary pieces of structural information:

* **Preorder ($\text{Root} \rightarrow \text{Left} \rightarrow \text{Right}$):** The first unprocessed element in `preorder` is always the root of the current subtree.
* **Inorder ($\text{Left} \rightarrow \text{Root} \rightarrow \text{Right}$):** Finding the root's value splits the array into two halves—all elements to the left of the root belong strictly to the left subtree, and all elements to the right belong strictly to the right subtree.

By maintaining a global or class-level index pointer `preIdx` for the `preorder` array and using a hash map to look up root indices in `inorder` in $O(1)$ time, we can recursively construct the tree in a Divide and Conquer fashion.

---

## Step-by-Step Guide

1. Populate a hash map `ind` mapping each value in `inorder` to its corresponding array index.
2. Initialize a pointer `preIdx = 0` to track the current root element in `preorder`.
3. Call the recursive helper function `dfs(preorder, 0, inorder.length - 1)` with the initial inorder boundaries $[l, r]$.
4. **Base Case:** If $l > r$, the current subtree is empty, so return `null`.
5. **Root Creation:**
* Extract the current root value: `root_val = preorder[preIdx++]`.
* Instantiate a new `TreeNode(root_val)`.


6. **Subtree Partitioning:**
* Look up the root's index `mid` in `inorder` using the hash map: `mid = ind.get(root_val)`.
* Recursively build the left subtree with boundary $[l, \text{mid} - 1]$ and assign it to `root.left`.
* Recursively build the right subtree with boundary $[\text{mid} + 1, r]$ and assign it to `root.right`.


7. Return `root`.

---

## Complexity Analysis

* **Time Complexity:** $O(N)$
* Building the hash map takes $O(N)$ time. Each of the $N$ nodes is created and placed once, with hash map lookups and boundary checks operating in $O(1)$ constant time per node.


* **Space Complexity:** $O(N)$
* The hash map stores all $N$ elements, taking $O(N)$ auxiliary memory.
* The recursive call stack takes $O(H)$ space, where $H$ is the height of the tree ($O(\log N)$ for balanced trees, $O(N)$ for skewed trees).
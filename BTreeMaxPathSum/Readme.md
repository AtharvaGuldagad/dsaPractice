# Binary Tree Maximum Path Sum

# HARD (but not really)

## Intuition

### Split Path vs. Return Path

A path in a binary tree is a sequence of adjacent nodes where each node can appear at most once. The challenge is finding the path that yields the maximum sum of node values.

For any node, there are two distinct ways it contributes to a path sum:

1. **The Turn/Split Point (Global Candidate):** The path curves through the current node, combining its value with both its left and right subtrees:

$$\text{Path Sum} = \text{root.val} + \text{leftMax} + \text{rightMax}$$



Because a valid path cannot branch twice, this combined shape cannot be extended further up to parent nodes. We use it only to update our global maximum (`res[0]`).
2. **The Branch (Upward Contribution):** To extend the path to its parent node, the parent can pick at most **one branch** (either left or right) along with the current node:

$$\text{Return Value} = \text{root.val} + \max(\text{leftMax}, \text{rightMax})$$



### Pruning Negative Subtrees

If a subtree produces a net negative sum, including it will only decrease the overall path sum. We can safely ignore negative branch gains by clamping them to zero using `Math.max(..., 0)`.

---

## Step-by-Step Guide

1. Initialize `res = new int[]{root.val}` to track the global maximum path sum (starting with the root node value to handle trees where all node values are negative).
2. Run a post-order Depth-First Search (`dfs`) starting at `root`:
* **Base Case:** If `root == null`, return `0`.
* **Subtree Computation:** Recursively find the max branch gain from `root.left` and `root.right`, clamping negative values to `0` (`Math.max(dfs(...), 0)`).
* **Update Global Maximum:** Calculate the sum assuming the path peaks at the current node: `root.val + leftMax + rightMax`. Update `res[0]` if this sum exceeds the current best.
* **Return Upward Path:** Return `root.val + Math.max(leftMax, rightMax)` to allow higher parent nodes to form their own paths.


3. Return `res[0]` once the traversal finishes.

---

## Complexity Analysis

* **Time Complexity:** $O(N)$
* Every node in the tree is visited exactly once during the post-order DFS. At each node, computing the maximums and updating the global tracker takes $O(1)$ constant-time operations, scaling linearly with the number of nodes $N$.


* **Space Complexity:** $O(H)$
* The auxiliary memory is determined by the recursion call stack, where $H$ is the height of the binary tree.
* **Balanced Tree:** $H = O(\log N)$ space.
* **Skewed Tree (Worst-Case):** $H = O(N)$ space.
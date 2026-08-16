# Serialize and Deserialize Binary Tree

## Intuition

### Pre-Order Depth-First Search (DFS) with Null Markers

A standard pre-order traversal alone is not sufficient to reconstruct a general binary tree because the shape of the tree is ambiguous without knowing where child branches end.

By explicitly recording a sentinel/null marker (such as `"N"`) whenever a pointer reaches `null`, the pre-order sequence $(\text{Node} \rightarrow \text{Left} \rightarrow \text{Right})$ uniquely identifies both the node values and the exact tree topology:

1. **Serialization:** Traverse pre-order. Record node values, and write `"N"` whenever hitting a `null` leaf. Join the elements with a delimiter like `","`.
2. **Deserialization:** Split the string into an array/stream of tokens. In pre-order fashion, read the next token: if it is `"N"`, return `null`; otherwise, create the node and recursively construct its left and right subtrees in the exact same sequence.

---

## Step-by-Step Guide

### Serialization (`serialize`)

1. Create a list `res` to hold the string tokens.
2. Run a pre-order `dfsSerial` starting at `root`:
* If `node == null`, append `"N"` to `res` and return.
* Otherwise, append `String.valueOf(node.val)` to `res`.
* Recursively call `dfsSerial(node.left, res)`.
* Recursively call `dfsSerial(node.right, res)`.


3. Return the tokens joined by commas: `String.join(",", res)`.

### Deserialization (`deserialize`)

1. Split the serialized string by delimiter: `String[] vals = data.split(",")`.
2. Use an array pointer `int[] i = {0}` to track the current token index across recursive calls.
3. Run `dfsDeserial(vals, i)`:
* Read the token at `vals[i[0]]` and advance the pointer `i[0]++`.
* If the token equals `"N"`, return `null`.
* Otherwise, create a new `TreeNode` initialized with `Integer.parseInt(token)`.
* Recursively assign `node.left = dfsDeserial(vals, i)`.
* Recursively assign `node.right = dfsDeserial(vals, i)`.
* Return `node`.



---

## Complexity Analysis

* **Time Complexity:** $O(N)$
* **Serialize:** We visit every node and `null` reference exactly once, taking $O(N)$ time to generate the list and join strings.
* **Deserialize:** Splitting the string and processing each token during reconstruction takes $O(N)$ time, where $N$ is the total number of nodes in the binary tree.


* **Space Complexity:** $O(N)$
* **Serialize:** $O(N)$ auxiliary space for the recursion call stack ($O(H)$) and the serialized token list.
* **Deserialize:** $O(N)$ space to store the token array `vals` and maintain the reconstruction call stack.
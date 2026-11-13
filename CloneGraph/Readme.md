# Clone Graph

## Intuition

### Graph Deep-Copy & Cycle Handling via HashMap

Cloning an undirected connected graph requires creating a deep copy of every node and preserving all neighbor relationships without getting trapped in infinite recursion when cycles exist.

1. **Original-to-Clone Mapping (`Map<Node, Node>`):** A `HashMap` maps each original `Node` reference to its newly instantiated `Node` clone. This serves two critical purposes:
* **Cycle Detection / Visited Tracking:** If a node is already present in `map`, it has already been cloned (or is currently being cloned in an active recursive frame). Returning `map.get(node)` immediately prevents infinite loops and ensures shared neighbor references point to the exact same cloned instance.
* **O(1) Lookup:** Allows instant retrieval of previously created clones when wiring edges.


2. **Pre-Recursion Registration:** Inserting `map.put(node, copy)` **before** iterating through `node.neighbors` is essential. If an edge loops back to `node` (self-loop or multi-node cycle), the recursive call hits the `map.containsKey(node)` base case and resolves cleanly.

---

## Step-by-Step Guide

1. **State Initialization:** Create `Map<Node, Node> map = new HashMap<>()` to store `original -> clone` mappings.
2. **DFS Traversal (`dfs(node, map)`):**
* **Null Guard:** If `node == null`, return `null`.
* **Memoization / Cycle Check:** If `map.containsKey(node)`, return the existing clone `map.get(node)`.
* **Clone & Register:** Instantiate `Node copy = new Node(node.val)` and immediately register `map.put(node, copy)` before exploring edges.
* **Clone Neighbors:** Iterate through each neighbor `n` in `node.neighbors`:
* Recursively clone `n` via `dfs(n, map)` and append the returned node to `copy.neighbors`.


* Return `copy`.



---

## Complexity Analysis

* **Time Complexity:** $O(V + E)$
* Where $V$ is the number of vertices (nodes) and $E$ is the number of edges in the graph. Each node is cloned once, and each edge is traversed once (twice total for undirected edges) during neighbor iteration.


* **Space Complexity:** $O(V)$
* The `HashMap` stores $V$ entries mapping original nodes to cloned nodes, and the recursion call stack reaches a depth of at most $O(V)$ in the worst case (e.g., a linear chain graph).
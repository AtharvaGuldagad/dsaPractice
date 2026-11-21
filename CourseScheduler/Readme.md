# Course Schedule (Cycle Detection in Directed Graph)

## Intuition

### DFS Cycle Detection & Graph Pruning (Memoization)

Determining whether all `numCrs` courses can be finished reduces to checking if the directed prerequisite graph is a **Directed Acyclic Graph (DAG)**—meaning it contains **no cycles**.

1. **Adjacency List Construction (`preMap`):** Maps each course `c` to the list of prerequisite courses required before taking `c`.
2. **Active Recursion Path (`visiting` Set):** Tracks nodes currently on the active DFS call stack. If DFS encounters a course already in `visiting`, a back-edge exists, confirming a circular dependency (`return false`).
3. **In-Place Pruning (`preMap.put(crs, new ArrayList<>())`):** Once all prerequisites of `crs` are verified cycle-free, clearing `preMap.get(crs)` (or calling `preMap.get(crs).clear()` to avoid allocating a new `ArrayList`) acts as $O(1)$ memoization. If another course later depends on `crs`, `preMap.get(crs).isEmpty()` triggers immediately and skips redundant traversal.
4. **Array-Based State Optimization (`int[] state`):** Because courses are labeled `0` to `numCrs - 1`, replacing `Map<Integer, List<Integer>>` and `Set<Integer>` with `List<Integer>[] adj = new ArrayList[numCrs]` and a 3-state `int[] state` array (`0` = unvisited, `1` = visiting, `2` = visited/safe) eliminates hashing and autoboxing overhead.

---

## Step-by-Step Guide

1. **Build Directed Adjacency List:**
* Initialize `preMap` with an empty `ArrayList` for every course from `0` to `numCrs - 1`.
* For each `[course, prereq]` pair in `prerequisites`, append `prereq` to `preMap.get(course)`.


2. **Check All Components (`canFinish`):**
* Loop `c` from `0` to `numCrs - 1` (necessary because the prerequisite graph may be disconnected):
* If `!dfs(c)` returns `false`, immediately return `false`.


* Return `true` once every course is verified.


3. **Recursive DFS with Backtrack & Pruning (`dfs(int crs)`):**
* **Cycle Guard:** If `visiting.contains(crs)`, a cycle is detected—return `false`.
* **Memoized / Leaf Guard:** If `preMap.get(crs).isEmpty()`, `crs` has no remaining unverified prerequisites—return `true`.
* **Mark Active:** Add `crs` to `visiting`.
* **Explore Prerequisites:** Recurse on every `pre` in `preMap.get(crs)`; propagate `false` immediately if any sub-call detects a cycle.
* **Backtrack & Memoize:** Remove `crs` from `visiting`, clear its prerequisite list (`preMap.get(crs).clear()`), and return `true`.



---

## Complexity Analysis

* **Time Complexity:** **$O(V + E)$**
* Where $V$ is `numCrs` and $E$ is `prerequisites.length`. Building the adjacency list takes $O(V + E)$. Because verified courses have their prerequisite lists cleared, each vertex and each directed edge is processed at most once across all DFS calls.


* **Space Complexity:** **$O(V + E)$**
* `preMap` stores $V$ lists and $E$ total edges, while `visiting` and the recursion call stack each reach a maximum depth of $O(V)$.
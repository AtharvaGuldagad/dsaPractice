# Pacific Atlantic Water Flow

## Intuition

### Reverse Flow from Ocean Borders & `boolean[][]` Optimization

Instead of checking whether water can flow *downhill* from every individual cell to both oceans—which leads to redundant $O((M \times N)^2)$ traversals—we reverse the flow direction and climb **uphill** starting from the ocean coastlines:

1. **Uphill Reachability:** Water flows from cell $A$ to neighbor $B$ if `height[A] >= height[B]`. Reversing this, water can reach an ocean from cell $B$ if we can walk from the ocean border into $B$ along a non-decreasing height path (`grid[r][c] >= prevH`).
2. **Dual Reachability Sets:** Running two separate border traversals—one seeded from the **Pacific** borders (top row & left column) and one from the **Atlantic** borders (bottom row & right column)—identifies all cells capable of draining into each ocean. Their intersection yields the answer.
3. **Memory & Lookup Optimization (`boolean[][]` vs. `Set<List<Integer>>`):**
Your current implementation allocates `List.of(r, c)` objects on every recursive call, set insertion, and intersection check, triggering unnecessary heap allocations and hash computations. Replacing `Set<List<Integer>>` with two primitive `boolean[rows][cols]` matrices eliminates object overhead and reduces visited checks to $O(1)$ array indexing.

---

## Step-by-Step Guide

1. **Initialize Reachability Grids:**
* Store `rows = grid.length` and `cols = grid[0].length`.
* Allocate `boolean[][] pac = new boolean[rows][cols]` and `boolean[][] atl = new boolean[rows][cols]`.


2. **Launch Border DFS Traversals:**
* Iterate column `c` from `0` to `cols - 1`:
* Trigger `dfs(0, c, pac, grid[0][c], grid)` (top Pacific edge).
* Trigger `dfs(rows - 1, c, atl, grid[rows - 1][c], grid)` (bottom Atlantic edge).


* Iterate row `r` from `0` to `rows - 1`:
* Trigger `dfs(r, 0, pac, grid[r][0], grid)` (left Pacific edge).
* Trigger `dfs(r, cols - 1, atl, grid[r][cols - 1], grid)` (right Atlantic edge).




3. **Uphill DFS (`dfs(r, c, visited, prevH, grid)`):**
* **Base Case:** Return immediately if `(r, c)` is out of bounds, `visited[r][c]` is already `true`, or `grid[r][c] < prevH` (cannot climb downhill in reverse).
* Mark `visited[r][c] = true`.
* Recurse in all 4 cardinal directions passing `grid[r][c]` as the new `prevH`.


4. **Collect Intersection:**
* Scan every cell `(r, c)`: if `pac[r][c] && atl[r][c]`, append `List.of(r, c)` to `res`.



---

## Complexity Analysis

* **Time Complexity:** $O(M \times N)$
* Where $M$ is the number of rows and $N$ is the number of columns. Each cell is visited at most once during the Pacific DFS and at most once during the Atlantic DFS, followed by a single $O(M \times N)$ pass to collect intersecting coordinates.


* **Space Complexity:** $O(M \times N)$
* Using `boolean[][]` matrices requires $2 \times M \times N$ bits/bytes of auxiliary memory, and the recursion stack depth is bounded by $O(M \times N)$ in the worst case (e.g., a spiral monotonic path).
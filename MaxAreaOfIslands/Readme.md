# Max Area of Island

## Intuition

### Recursive DFS & In-Place Area Accumulation

Finding the maximum area of an island builds directly on the connected-components pattern from *Number of Islands*, shifting from counting distinct components to measuring the **size (node count)** of each connected component.

1. **In-Place Sinking:** When visiting a land cell (`grid[r][c] == 1`), we immediately overwrite `grid[r][c] = 0`. This acts as an $O(1)$ visited check, preventing infinite loops and avoiding the memory overhead of a separate `boolean[][] visited` matrix.
2. **Recursive Size Aggregation:** Each valid land cell contributes an area of `1` plus the sum of areas returned by its 4-directional neighbors (Up, Down, Left, Right). Out-of-bounds coordinates or water cells (`0`) serve as base cases returning `0`.
3. **Running Maximum:** As each island is completely explored and sunk, its total area is compared against `maxA` to track the largest island encountered.

---

## Step-by-Step Guide

1. **Initialization:** Store grid dimensions `rows = grid.length` and `cols = grid[0].length`. Initialize `maxA = 0`.
2. **Grid Traversal:** Iterate through every row $r$ and column $c$:
* If `grid[r][c] == 1`:
* Invoke `dfs(r, c, grid)` to compute the full area of the connected island.
* Update `maxA = Math.max(maxA, area)`.




3. **DFS Area Calculation (`dfs`):**
* **Base Case:** If $r$ or $c$ is out of bounds, or `grid[r][c] == 0`, return `0`.
* **Mark Visited:** Set `grid[r][c] = 0`.
* **Recurse & Sum:** Return `1 + dfs(r + 1, c, grid) + dfs(r - 1, c, grid) + dfs(r, c + 1, grid) + dfs(r, c - 1, grid)`.


4. Return `maxA`.

---

## Complexity Analysis

* **Time Complexity:** $O(M \times N)$
* Where $M$ is the number of rows and $N$ is the number of columns. Every cell in the grid is visited at most once during the outer scan and at most once inside `dfs` before being flipped to `0`.


* **Space Complexity:** $O(M \times N)$
* In the worst case where the entire grid is a single connected island of `1`s, the recursion call stack depth can reach $M \times N$. No extra heap allocations are made beyond the call stack.
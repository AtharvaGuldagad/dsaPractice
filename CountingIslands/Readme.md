# Number of Islands

## Intuition

### BFS Connected Components & In-Place Sinking

An island is a 4-directionally connected group of `'1'`s (land) surrounded by `'0'`s (water). Finding the total number of islands reduces to counting the **connected components** in an unweighted grid graph.

1. **Grid Traversal:** Iterate through each cell $(r, c)$ in the grid.
2. **Component Discovery:** When encountering an unvisited land cell (`grid[r][c] == '1'`), we increment our island count and launch a Breadth-First Search (BFS) to visit all reachable connected land cells.
3. **In-Place Sinking (Visited Marking):** Rather than allocating an auxiliary `boolean[][] visited` matrix, we mark land cells as visited in-place by "sinking" them—reassigning `grid[r][c] = '0'`.
4. **Queue Invariant:** To prevent duplicate grid entries from being added to the queue (which causes unnecessary allocations and time limit exceeded errors), cells are marked as `'0'` immediately when placed into the queue—not when polled.

---

## Step-by-Step Guide

1. **Grid Initialization:** Store `rows = grid.length` and `cols = grid[0].length`. Initialize `island = 0`.
2. **Outer Traversal:** Iterate $r$ from $0$ to $\text{rows} - 1$ and $c$ from $0$ to $\text{cols} - 1$:
* If `grid[r][c] == '1'`:
* Execute `bfs(grid, r, c)` to sink the entire connected island.
* Increment `island++`.




3. **BFS Execution (`bfs`):**
* Create a `Queue<int[]> q = new LinkedList<>()`.
* Sink the initial cell `grid[r][c] = '0'` and offer `new int[]{r, c}` to `q`.
* While `!q.isEmpty()`:
* Poll element `[row, col]` from `q`.
* For each directional offset `dir` in `{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}`:
* Calculate neighbor coordinates `nr = row + dir[0]` and `nc = col + dir[1]`.
* If $(nr, nc)$ is within grid bounds AND `grid[nr][nc] == '1'`:
* Mark `grid[nr][nc] = '0'` immediately.
* Offer `new int[]{nr, nc}` to `q`.








4. Return `island`.

---

## Complexity Analysis

* **Time Complexity:** $O(M \times N)$
* Where $M$ is the number of rows and $N$ is the number of columns. Every grid cell is visited at most a constant number of times (once by the outer loop, and at most once during a BFS traversal when being converted from `'1'` to `'0'`).


* **Space Complexity:** $O(\min(M, N))$
* In the worst case (a grid completely filled with land `'1'`), the maximum size of the BFS queue is bounded by the length of the diagonal, requiring $O(\min(M, N))$ auxiliary space. Space is saved by avoiding a separate $O(M \times N)$ visited array.
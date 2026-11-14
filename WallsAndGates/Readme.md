# Islands and Treasure (Walls and Gates)

## Intuition

### Multi-Source BFS from Target Destinations

Instead of running a separate Breadth-First Search from every empty land cell (`Integer.MAX_VALUE`) to find the nearest treasure chest (`0`)—which would result in redundant traversals and $O((M \times N)^2)$ time—we invert the perspective using **Multi-Source BFS**:

1. **Simultaneous Wavefront Expansion:** Enqueue all treasure chests (`grid[r][c] == 0`) at the very beginning. Because standard BFS explores nodes level-by-level in order of increasing distance, expanding outward from all `0`s simultaneously guarantees that the **first time** any empty land cell (`INF`) is reached, it is via the shortest possible path from its nearest treasure chest.
2. **In-Place Distance & Visited Tracking:** Overwriting `grid[r][c] = grid[row][col] + 1` upon discovery both records the shortest distance and marks the cell as visited (`!= Integer.MAX_VALUE`), eliminating the need for a separate `visited` matrix and naturally ignoring walls (`-1`).

---

## Step-by-Step Guide

1. **Seed Queue with All Sources:**
* Initialize `Queue<int[]> q = new LinkedList<>()`.
* Scan the grid and offer coordinates `{r, c}` for every cell where `grid[r][c] == 0`.
* If `q.isEmpty()`, no treasure chests exist; return immediately.


2. **Level-Order Expansion (`while (!q.isEmpty())`):**
* Poll the current cell `[row, col]` from `q`.
* Check all 4 adjacent neighbors (`{-1,0}`, `{0,-1}`, `{1,0}`, `{0,1}`):
* Skip if the neighbor `(r, c)` is out of bounds or `grid[r][c] != Integer.MAX_VALUE` (meaning it is a wall `-1`, a treasure chest `0`, or an already-visited land cell).
* Update `grid[r][c] = grid[row][col] + 1`.
* Enqueue `{r, c}` to propagate the wavefront further.





---

## Complexity Analysis

* **Time Complexity:** $O(M \times N)$
* Where $M$ is the number of rows and $N$ is the number of columns. Scanning the grid to enqueue initial sources takes $O(M \times N)$, and each empty land cell is enqueued and processed at most once during BFS.


* **Space Complexity:** $O(M \times N)$
* In the worst case (e.g., a grid filled entirely with treasure chests `0`s, or a single chest expanding across an open grid), the BFS queue holds up to $O(M \times N)$ coordinate pairs.
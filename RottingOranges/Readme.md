# Rotting Oranges

## Intuition

### Level-Synchronized Multi-Source BFS

Like *Islands and Treasure*, this problem simulates simultaneous spread across a grid using **Multi-Source BFS**, with two key additions:

1. **Level-by-Level Minute Tracking:** Because all currently rotten oranges (`2`) infect adjacent fresh oranges (`1`) simultaneously every minute, we snapshot the current queue size (`int len = q.size()`) at the start of each `while` iteration. Processing all `len` nodes constitutes exactly one elapsed minute (`min++`).
2. **Fresh Orange Counter (`gud`) Guard:** Tracking the remaining count of fresh oranges (`gud`) solves two edge cases cleanly:
* **Loop Termination (`gud > 0 && !q.isEmpty()`):** Once `gud` hits `0`, the loop terminates immediately—preventing an extra false minute increment on the final frontier wave after the last fresh orange has already rotted.
* **Unreachable Oranges:** After BFS finishes, if `gud > 0`, some fresh oranges were isolated by empty cells (`0`) and can never rot, returning `-1`.



---

## Step-by-Step Guide

1. **Grid Scan & Queue Seeding:**
* Initialize `Queue<int[]> q = new LinkedList<>()`, fresh counter `gud = 0`, and elapsed time `min = 0`.
* Iterate over every cell `(r, c)`:
* If `grid[r][c] == 2`, enqueue `{r, c}` as an initial rotten source.
* If `grid[r][c] == 1`, increment `gud`.




2. **Wavefront Simulation (`while (gud > 0 && !q.isEmpty())`):**
* Capture the current level size `len = q.size()`.
* Loop `len` times to process all oranges rotting in the current minute:
* Poll `[row, col]` and check all 4 orthogonal neighbors.
* If a neighbor `(r, c)` is within bounds and `grid[r][c] == 1`:
* Mutate `grid[r][c] = 2` in-place (preventing duplicate enqueues).
* Decrement `gud--` and offer `{r, c}` to `q`.




* Increment `min++` after completing the level.


3. **Final Verification:** Return `min` if `gud == 0`; otherwise return `-1`.

---

## Complexity Analysis

* **Time Complexity:** $O(M \times N)$
* Where $M$ is the number of rows and $N$ is the number of columns. Scanning the grid takes $O(M \times N)$, and each fresh orange transitions from `1` to `2` at most once, bounding total BFS queue operations to $O(M \times N)$.


* **Space Complexity:** $O(M \times N)$
* In the worst case where the grid starts filled with rotten oranges (`2`), the BFS queue holds up to $O(M \times N)$ coordinate pairs. In-place mutation avoids allocating a separate `visited` matrix.
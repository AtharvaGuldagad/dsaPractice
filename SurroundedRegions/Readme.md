# Surrounded Regions

## Intuition

### Reverse Border Traversal & In-Place State Tagging

Instead of checking whether every interior `'O'` region is completely enclosed by `'X'`s, we invert the problem by finding all `'O'`s that **cannot** be captured—specifically, any `'O'` connected to the perimeter of the board:

1. **Perimeter Seeding:** Any `'O'` on the first/last row or first/last column is uncapturable, along with every `'O'` 4-directionally connected to it. Seeding a multi-source BFS queue from these border `'O'`s isolates every safe component.
2. **In-Place Temporary Marker (`'T'`):** Marking safe `'O'`s as `'T'` directly inside `board` avoids allocating a separate `boolean[][] visited` matrix. Once BFS finishes, any remaining `'O'` is guaranteed to be completely surrounded and can be flipped to `'X'`, while `'T'` cells are restored to `'O'`.
3. **Queue Insertion Optimization:** Notice in your `while` loop that neighbors are enqueued before checking `board[nr][nc] == 'O'` and before mutating `board[nr][nc] = 'T'`. While checking `board[r][c] == 'O'` on poll keeps the output accurate, it allows `'X'` cells and duplicate `'O'` cells to enter the queue. Marking `board[nr][nc] = 'T'` **at enqueue time** prevents duplicate queue entries and reduces memory overhead.

---

## Step-by-Step Guide

1. **Seed Border `'O'`s (`capture`):**
* Initialize `Queue<int[]> q = new LinkedList<>()`.
* Scan the four outer edges (`r == 0`, `r == rows - 1`, `c == 0`, `c == cols - 1`). For every `'O'`, mark it `'T'` immediately and offer `{r, c}` to `q`.


2. **Propagate Safe Markers via BFS:**
* While `!q.isEmpty()`:
* Poll `[r, c]` and explore all 4 orthogonal neighbors `(nr, nc)`.
* If `(nr, nc)` is within bounds and `board[nr][nc] == 'O'`, set `board[nr][nc] = 'T'` and enqueue `{nr, nc}`.




3. **Final Board Sweep (`solve`):**
* Iterate over every cell `(r, c)`:
* Flip unreached interior `'O'` cells to `'X'`.
* Restore protected `'T'` cells back to `'O'`.





---

## Complexity Analysis

* **Time Complexity:** **$O(M \times N)$**
* Where $M$ is `rows` and $N$ is `cols`. Border scanning, BFS traversal (when cells are marked `'T'` upon enqueue), and the final restoration sweep each visit every cell at most once.


* **Space Complexity:** **$O(M \times N)$**
* In the worst case (a grid filled predominantly with `'O'`s), the BFS queue can hold up to $O(M \times N)$ coordinate pairs. In-place tagging with `'T'` avoids extra `visited` grid allocations.
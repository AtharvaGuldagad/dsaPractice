# Spiral Matrix

## Intuition

### Recursive Step-Shrinking and 90° Turn

A spiral traversal moves in the pattern: **Right $\rightarrow$ Down $\rightarrow$ Left $\rightarrow$ Up**, repeating inwards until all elements are visited.

Instead of tracking four separate boundary pointers (`top`, `bottom`, `left`, `right`), this recursive approach uses two key insights:

1. **Alternating Step Counts:** After moving horizontally along $n$ columns, the remaining vertical movement requires $m - 1$ steps. After moving vertically along $m - 1$ rows, the next horizontal movement requires $n - 1$ steps. The dimension of the current direction always decrements by 1 after a turn.
2. **Direction Rotation Matrix:** Rotating clockwise by $90^\circ$ maps direction vectors $(dr, dc)$ to $(dc, -dr)$:
* Right $(0, 1) \rightarrow$ Down $(1, 0)$
* Down $(1, 0) \rightarrow$ Left $(0, -1)$
* Left $(0, -1) \rightarrow$ Up $(-1, 0)$
* Up $(-1, 0) \rightarrow$ Right $(0, 1)$



---

## Step-by-Step Guide

1. Extract matrix dimensions $m$ (rows) and $n$ (cols).
2. Start recursion with `dfs(m, n, 0, -1, 0, 1, matrix, res)`:
* Current segment length: `col` (initially $n$).
* Orthogonal remaining length: `row` (initially $m$).
* Starting coordinates: $(r = 0, c = -1)$ (so the first step lands on $(0, 0)$).
* Initial direction: $(dr = 0, dc = 1)$ (moving Right).


3. **Base Case:** If `row == 0` or `col == 0`, return immediately (no remaining elements to traverse in this direction).
4. **Traverse Segment:** Loop `col` times:
* Update coordinates: `r += dr`, `c += dc`.
* Add `matrix[r][c]` to `res`.


5. **Rotate & Recurse:**
* Swap and decrement dimensions: pass `col` as the next orthogonal length and `row - 1` as the new segment length.
* Rotate direction by $90^\circ$: new direction becomes $(dc, -dr)$.
* Call `dfs(col, row - 1, r, c, dc, -dr, matrix, res)`.



---

## Complexity Analysis

* **Time Complexity:** $O(m \times n)$
* Every cell in the $m \times n$ matrix is visited and added to `res` exactly once. Each step takes $O(1)$ constant time operations.


* **Space Complexity:** $O(\min(m, n))$
* The recursion depth corresponds to the number of directional turns, which is bounded by $2 \times \min(m, n)$. Thus, the call stack requires $O(\min(m, n))$ auxiliary space.
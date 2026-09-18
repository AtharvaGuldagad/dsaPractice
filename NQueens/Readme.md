# N-Queens (HashSet Solution Analysis)

## Intuition

### Mathematical Diagonal Tracking

This implementation correctly resolves the syntax issue from the previous attempt and successfully places $N$ queens on an $N \times N$ chessboard without conflicts.

By advancing row-by-row ($r = 0, 1, \dots, n-1$), row conflicts are eliminated automatically. $O(1)$ constant-time safety checks for columns and diagonals are maintained via three `HashSet` structures:

* **`col`:** Tracks occupied column indices $c$.
* **`posDiag`:** Tracks occupied anti-diagonals (bottom-left to top-right), where every cell on the same diagonal shares a constant sum $r + c$.
* **`negDiag`:** Tracks occupied main diagonals (top-left to bottom-right), where every cell on the same diagonal shares a constant difference $r - c$.

---

## Step-by-Step Guide

1. **Initialization:**
* Create an $n \times n$ character matrix `board` filled with `'.'`.
* Clear or initialize `col`, `posDiag`, `negDiag` sets, and output list `res`.


2. **Backtracking Execution (`bktk(r, n, board)`):**
* **Base Case:** If $r == n$, convert each row of `board` into a `String` to form a `List<String>` configuration and append to `res`. Return.
* **Column Traversal:** Loop $c$ from $0$ to $n - 1$:
* Check if `c`, `r + c`, or `r - c` exist in `col`, `posDiag`, or `negDiag`. If any match exists, `continue`.
* **Make Choice:** Add $c$ to `col`, $r + c$ to `posDiag`, $r - c$ to `negDiag`, and set `board[r][c] = 'Q'`.
* **Recurse:** Step to the next row with `bktk(r + 1, n, board)`.
* **Backtrack:** Remove $c$, $r + c$, and $r - c$ from their respective sets, and reset `board[r][c] = '.'`.




3. Return `res`.

---

## Complexity Analysis

* **Time Complexity:** $O(N!)$
* Place options drop from $N$ choices in the first row down to at most $N-2$, $N-4$, etc., in subsequent rows. The search tree size is bounded by $O(N!)$. Converting and copying valid board states of size $N \times N$ into string lists at each leaf node takes $O(N^2)$ time.


* **Space Complexity:** $O(N^2)$
* Excluding the $O(N! \cdot N^2)$ space consumed by the solution output `res`, storing the `board` matrix takes $O(N^2)$ space. The three sets and the recursion call stack each scale linearly with depth, taking $O(N)$ space.
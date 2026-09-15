# Word Search

## Intuition

### In-Place Grid Backtracking vs. `HashSet` Tracking

Your implementation uses backtracking to explore paths character-by-character. However, using a `Set<Pair<Integer, Integer>> rasta` to track visited cells introduces significant overhead:

1. Object creation (`new Pair<>(r, c)`) for every visited cell triggers frequent memory allocations.
2. Hash calculations and set operations add constant-factor overhead.

### In-Place Board Modification

We can optimize memory and execution time by temporarily modifying `board[r][c]` directly during DFS:

* Mark the current cell with an invalid character like `'*'` before making recursive calls.
* Restore the original character `board[r][c]` during the backtrack step.

---

## Step-by-Step Guide

1. **Grid Traversal:**
* Store grid dimensions `row = board.length` and `col = board[0].length`.
* Iterate through every cell $(r, c)$. If `dfs(board, word, r, c, 0)` returns `true`, immediately return `true`.


2. **DFS Execution (`dfs`):**
* **Base Case:** If `i == word.length()`, the entire word has been matched; return `true`.
* **Boundary & Matching Check:** Return `false` if $(r, c)$ is out of bounds or `board[r][c] != word.charAt(i)`.
* **In-Place Marking:** Save `char temp = board[r][c]` and set `board[r][c] = '*'` to mark it as visited in the current path.
* **4-Directional Search:** Recursively invoke `dfs` for all four neighbors with index `i + 1`. Short-circuit on the first successful match using logical OR (`||`).
* **Backtrack:** Restore `board[r][c] = temp`.
* Return the combined boolean result.



---

## Complexity Analysis

* **Time Complexity:** $O(M \times N \times 4^L)$
* Where $M \times N$ is the grid size and $L$ is the length of `word`.
* From each starting cell, we explore up to 4 directions initially and at most 3 directions for subsequent steps (since we cannot re-enter the visited cell).


* **Space Complexity:** $O(L)$
* **Current Code:** $O(L)$ space consumed by both the call stack and `rasta` Set allocations.
* **Optimized In-Place Approach:** $O(L)$ space, bounded purely by the depth of the recursion stack without auxiliary collections.
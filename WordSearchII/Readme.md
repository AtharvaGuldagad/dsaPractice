# Word Search II

## Intuition

### Backtracking with Trie and Branch Pruning

Searching for multiple target words on a 2D grid using independent DFS runs leads to excessive TLE (Time Limit Exceeded) because identical path prefixes across different words are explored repeatedly.

Combining **Backtracking** with a **Prefix Tree (Trie)** drastically optimizes this process:

1. **Prefix Matching:** Before stepping into an adjacent cell on the grid, we check if the cell's character exists as a valid child in the Trie. If not, the current path is abandoned immediately.
2. **Duplicate Prevention:** When a word's terminal node is reached (`node.idx != -1`), we add the word to `res` and set `node.idx = -1` to avoid registering the same word multiple times from different paths.
3. **Reference Counting & Dynamic Pruning:** Each node tracks how many active words pass through it (`refs`). When a word is completely matched, we decrement `refs` across all its constituent nodes. If a child node's `refs` drops to `0`, we detach it from its parent (`prev.children[...] = null`). This dynamic pruning prevents future grid paths from searching down already-exhausted Trie branches.

---

## Step-by-Step Guide

1. **Build Trie with Reference Counts:**
* Insert each word from `words` into the Trie, assigning its index `i` to the terminal node (`cur.idx = i`).
* Increment `refs` at every node along the insertion path to track active subwords.


2. **Grid Traversal:**
* Iterate over every coordinate $(r, c)$ in the grid `board`.
* Trigger the DFS traversal starting from the root node: `root.refs -= dfs(board, root, r, c, words)`.


3. **DFS Execution (`dfs`):**
* **Boundary & Match Guard:** Return `0` if $(r, c)$ is out of bounds, visited (`board[r][c] == '*'`), or lacks a child path in `node.children`.
* **In-Place Cell Marking:** Save `temp = board[r][c]` and mark `board[r][c] = '*'` to avoid revisiting the same cell in the current path.
* **Word Discovery:** Move `node` to the child node. If `node.idx != -1`, collect `words[node.idx]`, set `node.idx = -1`, and increment `found`.
* **4-Directional Exploration:** Recursively call `dfs` for all 4 neighboring cells (up, down, left, right) and accumulate `found` counts.
* **Backtrack & Prune:**
* Restore `board[r][c] = temp`.
* Subtract `found` from `node.refs`.
* **Prune Branch:** If `node.refs == 0`, prune this dead node by setting `prev.children[temp - 'a'] = null`.


* Return total `found` words removed from this subtree.



---

## Complexity Analysis

* **Time Complexity:** $O(M \times N \times 4^L)$
* Where $M \times N$ is the size of the grid and $L$ is the maximum length of a word.
* In the worst case without pruning, DFS explores up to $4^L$ paths per starting cell. However, Trie lookup limits exploration strictly to valid words, and node pruning (`refs == 0`) reduces practical runtime dramatically toward $O(\sum K_i)$ (total length of all words).


* **Space Complexity:** $O(\sum K_i + L)$
* **Trie Structure:** Stores total characters across all words, using $O(\sum K_i)$ space.
* **Recursion Stack:** Bounded by the maximum word length $L$, requiring $O(L)$ stack depth.
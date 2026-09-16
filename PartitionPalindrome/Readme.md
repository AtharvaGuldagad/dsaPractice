# Palindromic Partitioning

## Intuition

### Backtracking with Dynamic Substring Partitioning

To partition a string $s$ into all possible combinations where every substring is a palindrome, we build partitions incrementally using a decision tree:

1. **State Space Tree:** Starting at index `i`, we test all potential end boundaries `j` from `i` to `s.length() - 1`.
2. **Palindrome Validation:** If the candidate substring `s.substring(i, j + 1)` forms a palindrome, we choose to include it in the current path `part` and recursively call `dfs(j + 1, ...)` to partition the remaining tail of the string.
3. **Backtracking:** After exploring the recursive branch for a valid palindrome, we remove the last appended substring from `part` and continue the loop to evaluate longer substrings starting at `i`.
4. **Base Case:** Reaching `i >= s.length()` indicates that the entire string has been successfully decomposed into valid palindromic substrings. We snapshot `part` into `res`.

---

## Step-by-Step Guide

1. **State Initialization:**
* `res`: Output list to store all valid palindromic partitions.
* `part`: Dynamic list storing the current partition path.


2. **DFS Function (`dfs(i, s, part, res)`):**
* **Base Case:** If `i >= s.length()`, add a new copy `new ArrayList<>(part)` to `res` and return.
* Iterate `j` from `i` up to `s.length() - 1`:
* Check `isPalin(s, i, j)`:
* If true, slice `s.substring(i, j + 1)` and append to `part`.
* Recurse forward: `dfs(j + 1, s, part, res)`.
* **Backtrack:** Remove the last element from `part`.






3. **Two-Pointer Palindrome Verification (`isPalin`):**
* Maintain pointers `l = i` and `r = j`.
* Compare `s.charAt(l)` and `s.charAt(r)` moving inward (`l++`, `r--`). Return `false` on mismatch, or `true` if pointers cross.



---

## Complexity Analysis

* **Time Complexity:** $O(N \cdot 2^N)$
* In the worst-case scenario (e.g., a string of identical characters like `"aaaa"`), there are $2^{N-1}$ possible partitions.
* For each partition state, validating the palindrome and slicing the substring takes $O(N)$ time, yielding an overall upper bound of $O(N \cdot 2^N)$.
* *(Note: Precomputing a 2D boolean dynamic programming table `dp[i][j]` reduces palindrome checks from $O(N)$ to $O(1)$, though the total runtime remains bounded by $O(N \cdot 2^N)$ due to generating and copying result paths).*


* **Space Complexity:** $O(N)$
* Excluding the memory required to store the answer list `res`, the extra auxiliary space used by the `part` list and the recursion call stack depth is $O(N)$.
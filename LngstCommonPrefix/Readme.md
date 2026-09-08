# Longest Common Prefix

## Intuition

### Lexicographical Sorting Trick

To find the longest common prefix across an array of strings, we do not need to compare every character of every string.

By sorting the array lexicographically:

1. The strings become ordered alphabetically.
2. The **first string** (`strs[0]`) and the **last string** (`strs[strs.length - 1]`) will have the maximum possible dissimilarity among all pairs in the array.
3. Therefore, any common prefix shared by the entire array must be shared between the first and last strings. Finding the common prefix of just these two extreme strings yields the common prefix for all strings in the set.

---

## Step-by-Step Guide

1. **Edge Case Guard:** If `strs.length == 1`, return `strs[0]` immediately.
2. **Sort Array:** Sort the strings in lexicographical order: `Arrays.sort(strs)`.
3. **Determine Boundary Length:** Set `N = Math.min(strs[0].length(), strs[strs.length - 1].length())`.
4. **Compare Extremes:** Iterate `i` from `0` to `N - 1`:
* Compare `strs[0].charAt(i)` with `strs[strs.length - 1].charAt(i)`.
* At the first mismatch, return the prefix substring `strs[0].substring(0, i)`.


5. If no mismatch is found after `N` characters, `strs[0]` itself is the common prefix. Return `strs[0]`.

---

## Complexity Analysis

* **Time Complexity:** $O(S \cdot N \log N)$
* Where $N$ is the number of strings and $S$ is the maximum length of a string. Sorting $N$ strings of length $S$ takes $O(S \cdot N \log N)$ time for string comparisons. The character matching loop takes at most $O(S)$ time.
* *(Note: Vertical scanning or horizontal scanning achieves $O(S \cdot N)$ time without sorting).*


* **Space Complexity:** $O(1)$ or $O(\log N)$
* Modifies the array order in-place, using $O(\log N)$ auxiliary stack space for Dual-Pivot Quicksort.
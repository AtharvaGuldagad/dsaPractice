# Append Characters to String to Make Subsequence

## Intuition

### Greedy Two-Pointer Matching

To make string `t` a subsequence of string `s` with the minimum number of appended characters, we need to match as many characters of `t` inside `s` as possible, in order, starting from the beginning of `t`.

1. **Greedy Matching:** We use two pointers: `i` for `s` and `j` for `t`. Whenever `s.charAt(i) == t.charAt(j)`, we advance both pointers because finding a match as early as possible in `s` never hurts our chances of matching subsequent characters of `t`.
2. **Advancing `s`:** If the characters do not match, we only advance `i` to keep searching for `t.charAt(j)` further down in `s`.
3. **Appended Suffix Length:** Once `i` reaches the end of `s`, `j` represents the maximum number of prefix characters of `t` successfully matched as a subsequence. The remaining unmatched suffix of `t` must be appended to the end of `s`, which requires exactly:

$$\text{Appended Count} = t.\text{length}() - j$$



---

## Step-by-Step Guide

1. **Initialize Pointers:** Set `i = 0` (for traversing `s`) and `j = 0` (for traversing `t`).
2. **Two-Pointer Traversal:** Loop while `i < s.length()` and `j < t.length()`:
* If `s.charAt(i) == t.charAt(j)`, advance both `i++` and `j++`.
* Otherwise, advance only `i++`.


3. **Calculate Remaining Characters:** Return `t.length() - j`.

---

## Complexity Analysis

* **Time Complexity:** $O(N)$
* Where $N$ is the length of string `s`. In the worst case, pointer `i` traverses string `s` at most once, performing $O(1)$ comparisons per character.


* **Space Complexity:** $O(1)$
* Uses only primitive integer variables (`i`, `j`), taking strictly constant auxiliary memory.
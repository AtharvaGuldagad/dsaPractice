# Letter Combinations of a Phone Number

## Intuition

### String Concatenation vs. `StringBuilder` Backtracking

Your current solution correctly generates all letter combinations using a decision tree where each level corresponds to a digit in `digits`. However, there is a minor bug in your mapping array and a string concatenation performance issue:

1. **Mapping Bug:** For digit `'7'`, the mapping string in your array is `"qprs"`. The standard phone keypad letters for `'7'` are `"pqrs"`.
2. **String Immutability Overhead:** Passing `curStr + c` creates a brand-new `String` object at every recursive call, leading to unnecessary memory allocations and garbage collection overhead. Using a mutable `StringBuilder` with explicit `append()` and `deleteCharAt()` calls avoids intermediate string allocations during search tree traversal.

---

## Step-by-Step Guide

1. **Edge Case Check:** If `digits` is empty, return an empty list immediately.
2. **Keypad Mapping:** Define a mapping array where index `2` maps to `"abc"`, `3` to `"def"`, ..., `7` to `"pqrs"`, `8` to `"tuv"`, and `9` to `"wxyz"`.
3. **Backtracking (`bktk`):**
* **Base Case:** If `index == digits.length()`, convert the `StringBuilder` path to a string and add it to `res`.
* Retrieve the character string corresponding to `digits.charAt(index)`.
* Iterate over each character:
* Append the character to `sb`.
* Recurse to `index + 1`.
* Backtrack by removing the last appended character (`sb.deleteCharAt(sb.length() - 1)`).




4. Return `res`.

---

## Complexity Analysis

* **Time Complexity:** $O(N \cdot 4^N)$
* Where $N$ is the length of `digits`.
* Each digit maps to at most 4 letters (digits 7 and 9). The maximum number of leave states in the decision tree is $4^N$. Constructing the final string of length $N$ at each leaf takes $O(N)$ time, leading to an upper bound of $O(N \cdot 4^N)$.


* **Space Complexity:** $O(N)$
* Excluding the $O(N \cdot 4^N)$ space required to hold the output list `res`, the extra space used by the `StringBuilder` buffer and the recursion stack depth is bounded by $N$.
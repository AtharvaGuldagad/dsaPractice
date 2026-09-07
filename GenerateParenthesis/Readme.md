# Generate Parentheses

## Intuition

### Backtracking with Catalan Validity Constraints

To generate all combinations of $n$ pairs of well-formed parentheses, we construct strings character-by-character using two fundamental rules:

1. **Add `(` if `open < n`:** We can always add an opening parenthesis as long as we haven't reached the total count of $n$.
2. **Add `)` if `closed < open`:** We can only add a closing parenthesis if there are unclosed opening parentheses available. This rule guarantees that every prefix maintains valid balance and prevents invalid sequences like `")("`.

A `StringBuilder` acts as a dynamic stack buffer (`stk`). We append a character, recurse down that decision branch, and backtrack by deleting the last character (`stk.deleteCharAt(...)`).

---

## Step-by-Step Guide

1. **State Tracking:**
* `open`: Count of `'('` appended so far.
* `closed`: Count of `')'` appended so far.
* `stk`: `StringBuilder` building the current string path.


2. **Backtracking Function (`bktk`):**
* **Base Case:** If `open == n` and `closed == n`, the parenthesis string is fully formed and valid. Add `stk.toString()` to `res` and return.
* **Branch 1 (Add Open):**
* If `open < n`, append `'('` to `stk` and call `bktk(res, n, open + 1, closed, stk)`.
* Backtrack: delete the last character from `stk`.


* **Branch 2 (Add Close):**
* If `closed < open`, append `')'` to `stk` and call `bktk(res, n, open, closed + 1, stk)`.
* Backtrack: delete the last character from `stk`.




3. Return `res`.

---

## Complexity Analysis

* **Time Complexity:** $O\left(\frac{4^n}{\sqrt{n}}\right)$
* The total number of valid parenthesis combinations generated for $n$ pairs is given by the $n$-th Catalan Number:

$$C_n = \frac{1}{n + 1} \binom{2n}{n} \approx \frac{4^n}{n^{3/2} \sqrt{\pi}}$$


* Since each combination takes $O(n)$ time to convert from `StringBuilder` to string, the overall time bound is $O\left(\frac{4^n}{\sqrt{n}}\right)$.


* **Space Complexity:** $O(n)$
* Excluding the space required to store the final result list, the extra space used by the `StringBuilder` and recursion stack is bounded by the maximum string depth of $2n$.
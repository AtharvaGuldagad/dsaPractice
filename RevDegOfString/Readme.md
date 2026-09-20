# Reverse Degree of a String

## Intuition

### Alphabet Reversal & Position Weighting

The degree contribution of each character in the string is calculated based on two components:

1. **Reverse Alphabetical Value:** Standard alphabetical order maps `'a'` to $1$, `'b'` to $2$, ..., `'z'` to $26$. Reversing this scale maps `'z'` to $1$, `'y'` to $2$, ..., `'a'` to $26$. This value is computed directly as `'z' - s.charAt(i) + 1`.
2. **1-Based Index Weighting:** Each character's reverse alphabetical value is multiplied by its 1-based position index in the string (`i + 1`).

Accumulating this product across all characters yields the total reverse degree sum.

---

## Step-by-Step Guide

1. Initialize `ans = 0` to store the running sum.
2. Loop $i$ from $0$ to `s.length() - 1`:
* Compute the reverse alphabetical value: `value = 'z' - s.charAt(i) + 1`.
* Multiply `value` by the 1-based index `(i + 1)`.
* Add the resulting product to `ans`.


3. Return `ans`.

---

## Complexity Analysis

* **Time Complexity:** $O(N)$
* Where $N$ is the length of string `s`. Performs a single linear traversal over $N$ characters with constant $O(1)$ arithmetic operations per index.


* **Space Complexity:** $O(1)$
* Operates strictly using primitive variables (`ans`, `i`, `value`), consuming constant auxiliary memory.
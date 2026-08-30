# Score of a String

## Intuition

### Adjacent Character Absolute Difference

The score of a string is defined as the sum of the absolute differences between the ASCII values of adjacent characters.

1. **Pairwise Traversal:** We iterate through the string from index `0` up to `s.length() - 2`, pairing each character `s.charAt(i)` with its right neighbor `s.charAt(i + 1)`.
2. **ASCII Arithmetic:** In Java, subtracting two `char` primitives (e.g., `s.charAt(i) - s.charAt(i + 1)`) automatically promotes them to their integer ASCII values.
3. **Accumulate:** Taking `Math.abs(...)` of this difference ensures a non-negative distance, which is accumulated into `res`.

---

## Step-by-Step Guide

1. Initialize `res = 0` to hold the running total score.
2. Iterate `i` from `0` to `s.length() - 2`:
* Compute the absolute difference between `s.charAt(i)` and `s.charAt(i + 1)` using `Math.abs(s.charAt(i) - s.charAt(i + 1))`.
* Add the calculated difference to `res`.


3. Return `res`.

---

## Complexity Analysis

* **Time Complexity:** $O(N)$
* Where $N$ is the length of string `s`. The loop executes $N - 1$ times, performing $O(1)$ constant-time character access and arithmetic operations in each iteration.


* **Space Complexity:** $O(1)$
* Only a single primitive integer variable `res` is used, requiring strictly constant auxiliary space.
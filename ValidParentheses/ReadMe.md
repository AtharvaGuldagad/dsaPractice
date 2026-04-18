# Valid Parentheses

## Intuition
This problem requires us to ensure that brackets are closed in the correct order. This naturally follows a **Last-In-First-Out (LIFO)** pattern, making a **Stack** the ideal data structure. 

* When we encounter an **open bracket** (`(`, `[`, `{`), we push it onto the stack to remember it.
* When we encounter a **closing bracket** (`)`, `]`, `}`), we check the top of the stack. If it is the matching open bracket, we pop it off. If it doesn't match, or if the stack is empty (meaning there's no open bracket to match), the string is invalid.
* At the very end, if the stack is completely empty, it means every open bracket found its matching pair.

## Complexity

* **Time Complexity:** `O(n)`
  We iterate through the given string of length `n` exactly once. Pushing to and popping from a stack are `O(1)` operations.
  
* **Space Complexity:** `O(n)`
  In the worst-case scenario (e.g., a string of entirely open brackets like `(((((`), the stack will end up storing all `n` characters.

[Link-To-Problem](https://neetcode.io/problems/validate-parentheses/question?list=neetcode150)
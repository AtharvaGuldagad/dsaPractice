# Evaluate Reverse Polish Notation

## Intuition

### The Number Pile

Reverse Polish Notation looks strange at first, but it is actually perfectly set up for a stack. Instead of holding a math equation in your head waiting for parentheses and second numbers, you just pile up the numbers as they come. The moment a math symbol appears, it immediately acts on the last two numbers you just piled up.

### Order Matters

For addition and multiplication, the order does not matter. But for subtraction and division, you have to be careful. Because you are pulling from the top of the pile, the very first number you grab is actually the second part of the math equation, and the next number you grab is the first part.

---

## Step-by-Step Guide

1. Get a tall, empty bucket to hold numbers.
2. Look at the pieces you were given, one by one, from left to right.
3. If the piece is a number, drop it straight into the bucket.
4. If the piece is a math symbol (+, -, *, /), reach into the bucket and pull out the top two numbers.
5. Do the math on those two numbers. (Crucial detail: the first number you pull out goes on the right side of the math symbol, the second number pulled out goes on the left).
6. Take the result of that math and drop it right back into the bucket.
7. Repeat this until you have looked at every single piece.
8. When you are totally finished, there will be exactly one number left sitting in the bucket. Give back that number.

---

## Complexity Analysis

* **Time and Space Complexity:** Both are $O(N)$ because you evaluate every token exactly once and might need to temporarily store all of them in your bucket before an operator appears.
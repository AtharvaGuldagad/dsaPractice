sadas

# Single Number

## Intuition

### The Canceling Nature of XOR

The Bitwise XOR (Exclusive OR) operation, represented by `^`, possesses three unique mathematical properties that make it perfect for this problem:

1. **Self-Cancellation:** $A \oplus A = 0$ (Any number XORed with itself cancels out completely and becomes zero).
2. **Identity Element:** $A \oplus 0 = A$ (Any number XORed with zero remains unchanged).
3. **Commutative and Associative:** $A \oplus B \oplus A = (A \oplus A) \oplus B = 0 \oplus B = B$ (Order does not matter).

Because every element in the array appears **twice** except for one single unique element, we do not need to keep track of frequencies using extra memory like a set or map. If we XOR all the numbers together in a single pass, every duplicate pair will pair up and cancel itself out into zero. The single number will remain untouched as the final standing result.

---

## Step-by-Step Guide

1. Get a blank notepad to track your running XOR total (`res`). Initialize it to zero.
2. Walk through the array of numbers one by one, from left to right.
3. For each number you encounter, perform a bitwise XOR between your current running total and the number ($res = res \oplus num$).
4. Observe the math in action:
* When a number appears for the first time, its bits are blended into the running total.
* When that same number appears for the second time, the XOR operation reverses its previous effect, wiping those bits back to zero.


5. Once you have walked through the entire array, all duplicated numbers will have completely negated each other.
6. Hand back the final value remaining on your notepad, which is guaranteed to be the single unique number.

---

## Complexity Analysis

* **Time Complexity:** $O(N)$
* We iterate through the array of length $N$ exactly once. Inside the loop, the bitwise XOR operation takes $O(1)$ constant time. Therefore, the total runtime scales linearly with the size of the input array.


* **Space Complexity:** $O(1)$
* We only allocate a single integer variable (`res`) to store the running XOR accumulator. No extra data structures (like arrays or hash maps) are created, keeping the auxiliary space footprint strictly constant.
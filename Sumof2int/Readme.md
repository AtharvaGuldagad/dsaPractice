# Sum of Two Integers

## Intuition

### Simulating Addition Without `+` or `-`

When adding two numbers by hand, you add the matching digits together and write down a carry if the sum exceeds 9. The exact same process applies at the hardware level in binary using logic gates:

1. **Sum without carry:** The **XOR (`^`)** operator acts like a half-adder for binary digits. It returns `1` when bits are different and `0` when they are the same—effectively adding two bits while ignoring any carry (e.g., $1 \oplus 1 = 0$, $1 \oplus 0 = 1$, $0 \oplus 0 = 0$).
2. **Carry calculation:** The **AND (`&`)** operator identifies positions where both bits are `1`, generating a carry bit. Because carries shift left into the next higher place value, we left-shift the result by 1 (`<< 1`).

By repeatedly calculating the uncarried sum (`a ^ b`) and shifting the carry (`(a & b) << 1`), the carry value progressively shifts left until it becomes zero, leaving the total sum in variable `a`.

---

## Step-by-Step Guide

1. Start a loop that runs as long as there is a remaining carry (`b != 0`).
2. Calculate the carry bitmask:
* Perform bitwise AND between `a` and `b` (`a & b`) to find where both numbers have `1`s.
* Left-shift the result by 1 space (`<< 1`) to position the carry for the next place value.


3. Calculate the sum without carries:
* Perform bitwise XOR between `a` and `b` (`a ^ b`) and assign the result to `a`.


4. Update `b` with the calculated carry from step 2.
5. Repeat steps 2 through 4. On each iteration, the carry is processed and shifted further left.
6. Once `b` reduces to `0` (meaning no more carries remain), exit the loop and return `a`.

---

## Complexity Analysis

* **Time Complexity:** $O(1)$
* Because Java `int` types are strictly 32-bit signed integers, the `while` loop can run at most 32 times before the carry completely shifts out of bounds and becomes zero. Since the maximum number of operations is fixed, the time complexity is constant.


* **Space Complexity:** $O(1)$
* Only a single primitive variable (`carry`) is allocated to hold the temporary carry state. No heap memory or dynamic data structures are used, making auxiliary space strictly constant.
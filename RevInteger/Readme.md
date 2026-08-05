# Reverse Integer

## Intuition

### Digit Extraction and Rebuilding

Reversing an integer is mathematically straightforward: you pull digits off the end of the input number one by one using the modulo operator (`x % 10`) and attach them to a new running total by multiplying it by 10 (`res = res * 10 + digit`).

### Overflow Prevention Without 64-Bit Integers

The primary challenge of this problem is preventing **32-bit signed integer overflow**. Standard 32-bit integers are bounded strictly within:

$$[\text{Integer.MIN\_VALUE}, \text{Integer.MAX\_VALUE}] = [-2147483648, 2147483647]$$

If the reversed number exceeds these bounds, the program must return `0`. Instead of building the number first and checking for overflow after (which would cause undefined behavior or silent wrapping in 32-bit environments), we perform a **pre-check** before multiplying `res` by 10:

1. **Upper Bound Check:** If `res > MAX / 10`, then multiplying `res` by 10 will immediately breach `MAX`. If `res == MAX / 10`, we can only safely append a digit up to `7` (`MAX % 10`).
2. **Lower Bound Check:** If `res < MIN / 10`, then multiplying `res` by 10 will drop below `MIN`. If `res == MIN / 10`, we can only safely append a digit down to `-8` (`MIN % 10`).

---

## Step-by-Step Guide

1. Define the 32-bit signed integer boundaries: `max = 2147483647` and `min = -2147483648`.
2. Set up a variable `res = 0` to accumulate the reversed number.
3. Start a loop that runs as long as `x != 0`:
* Extract the last digit of `x`: `digit = x % 10`.
* Truncate `x` to drop its last digit: `x = x / 10`.
* **Check Positive Overflow:** If `res > max / 10` (or `res == max / 10` and `digit > 7`), return `0`.
* **Check Negative Overflow:** If `res < min / 10` (or `res == min / 10` and `digit < -8`), return `0`.
* Safely append the digit: `res = (res * 10) + digit`.


4. Return `res` once `x` reaches zero.

---

## Complexity Analysis

* **Time Complexity:** $O(\log_{10} \vert{}x\vert{})$
* We process the input number digit by digit. Since a 32-bit integer has at most 10 decimal digits, the loop runs at most 10 times. This guarantees $O(1)$ constant time execution.


* **Space Complexity:** $O(1)$
* Only a few primitive integer variables (`min`, `max`, `res`, `digit`) are used. No additional data structures are allocated, keeping auxiliary space strictly constant.
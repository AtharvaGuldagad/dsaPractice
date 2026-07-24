# Counting Bits

## Intuition

### Brian Kernighan's Algorithm

Counting the set bits (1s) in a number can be done by inspecting each bit individually, but Brian Kernighan's bit manipulation trick accelerates this process dramatically:

$$\text{num} = \text{num} \ \& \ (\text{num} - 1)$$

Performing a bitwise AND between a number and itself minus one automatically flips its absolute rightmost set bit (the lowest 1) to `0`, leaving all higher bits untouched. By repeating this operation in a loop until the number becomes zero, the number of steps taken is strictly equal to the exact count of 1 bits, bypassing any trailing or intermediate zeros completely.

### The Dynamic Programming Alternative

The provided solution applies Brian Kernighan's algorithm individually for every number from $1$ to $n$.

However, we can optimize this further using **Dynamic Programming**. Because $\text{num} \ \& \ (\text{num} - 1)$ drops the lowest set bit, the remaining value is guaranteed to be a strictly smaller number whose bit count we have already calculated. Thus, we can compute the set bits for every number in $O(1)$ time per element:

$$\text{res}[i] = \text{res}[i \ \& \ (i - 1)] + 1$$

---

## Step-by-Step Guide

1. Create an integer array `res` of size $n + 1$ initialized to all zeros. (Since $0$ has zero 1 bits, `res[0]` is naturally `0`).
2. Start a loop from $i = 1$ up to $n$.
3. For each number $i$, copy it to a temporary variable `num`.
4. Start a nested loop that continues as long as `num` is not zero:
* Clear the rightmost set bit using `num = num & (num - 1)`.
* Increment `res[i]` by 1 for every bit cleared.


5. Once `num` becomes zero, move to the next number $i$.
6. Return the completed `res` array containing bit counts for all values from $0$ to $n$.

---

## Complexity Analysis

* **Time Complexity:** $O(n \log n)$ worst-case / $O(n \cdot k)$ average
* Let $k$ be the average number of set bits per integer. Brian Kernighan's loop runs $k$ times for each $i$. Since a 32-bit integer has at most $\log_2(n)$ bits set to 1, the overall time complexity is bounded by $O(n \log n)$.
* *(Note: The $O(1)$ Dynamic Programming approach reduces this strictly to $O(n)$ time).*


* **Space Complexity:** $O(1)$
* Excluding the returned output array of size $n + 1$, the auxiliary memory used purely for computation is $O(1)$ constant (storing only `num` and loop indices).
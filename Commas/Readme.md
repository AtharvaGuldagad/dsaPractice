# Count Commas in Range

## Intuition

### Position-Based Digit Grouping

In standard numerical formatting, commas are inserted every three digits from right to left (at thousands, millions, billions, etc.):

* Numbers from **1 to 999** have **0** commas.
* Numbers from **1,000 to 999,999** have **1** comma each (located at the thousands separator).
* Numbers from **1,000,000 to 999,999,999** have **2** commas each, and so on.

Your code directly computes the number of commas for values up to $999,999$. For any integer $n$ in the range $[1000, 999999]$, every number from $1000$ up to $n$ contributes exactly $1$ comma to the total count. The total count of such numbers is given by:

$$\text{Count} = (n - 1000) + 1$$

---

## Step-by-Step Guide

1. Check if $n < 1000$. If true, return `0` immediately (no numbers have commas).
2. For $1000 \le n \le 999999$, calculate the total number of values in the range $[1000, n]$ by taking $(n - 1000) + 1$.
3. Return the result.

*(Note: If $n \ge 1,000,000$, additional ranges for 2 or more commas would need to be added using similar positional range formulas).*

---

## Complexity Analysis

* **Time Complexity:** $O(1)$
* The operation executes in constant time using direct arithmetic without any loops or iterations.


* **Space Complexity:** $O(1)$
* Uses strictly constant auxiliary memory.
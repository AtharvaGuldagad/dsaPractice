# Stone Game IX

## Intuition

### Remainder Classification (Modulo 3)

The actual values of the stones do not matter—only their remainders modulo 3 ($0, 1, \text{ or } 2$) determine whether the running sum becomes divisible by 3.

* **Type 0 ($i \% 3 == 0$):** Adding a type 0 stone does not change the running sum modulo 3. It simply consumes a turn and passes the turn to the other player.
* **Type 1 ($i \% 3 == 1$) & Type 2 ($i \% 3 == 2$):** Alter the running sum. To avoid reaching a multiple of 3:
* If the game starts with **1**, the sequence of choices must alternate: $1 \rightarrow 1 \rightarrow 2 \rightarrow 1 \rightarrow 2 \rightarrow 1 \dots$
* If the game starts with **2**, the sequence must alternate: $2 \rightarrow 2 \rightarrow 1 \rightarrow 2 \rightarrow 1 \rightarrow 2 \dots$



---

### Game Parity Analysis

1. **Even Number of Type 0 Stones (`c0 % 2 == 0`):**
* An even count of $0$-remainder stones cancels out naturally as players trade turns on them without altering the game's flow.
* Alice wins as long as both $1$ and $2$ remainders exist (`c1 > 0 && c2 > 0`), because she can choose whichever starting stone forces Bob to run out of matching pairs first.


2. **Odd Number of Type 0 Stones (`c0 % 2 != 0`):**
* An odd count of $0$-remainder stones gives the second player (Bob) a chance to flip the turn parity by using the last type 0 stone.
* For Alice to win despite this parity disadvantage, one remainder type must outnumber the other by a significant margin: $\vert{}c1 - c2\vert{} > 2$.



---

## Step-by-Step Guide

1. Count the occurrences of stones based on their modulo 3 remainders:
* `c0`: count of stones where `stone % 3 == 0`
* `c1`: count of stones where `stone % 3 == 1`
* `c2`: count of stones where `stone % 3 == 2`


2. **Case 1 (Even `c0`):**
* If `c0 % 2 == 0`, return `true` if `c1 > 0 && c2 > 0`; otherwise, return `false`.


3. **Case 2 (Odd `c0`):**
* If `c0 % 2 != 0`, return `true` if `Math.abs(c1 - c2) > 2`; otherwise, return `false`.



---

## Complexity Analysis

* **Time Complexity:** $O(n)$
* We iterate through the array of length $n$ once to categorize and count remainder frequencies. The decision check at the end executes in $O(1)$ constant time.


* **Space Complexity:** $O(1)$
* Only three integer counter variables (`c0`, `c1`, `c2`) are used, requiring strictly constant auxiliary space.
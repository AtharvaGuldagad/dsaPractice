# Plus One

## Intuition

### The Grade School Math

When you add exactly one to any large number, you always start at the very end (the rightmost digit). If that last digit is anything between 0 and 8, the math is trivial: you just increase it by one, and the rest of the number remains completely untouched. The only time the math requires extra work is when the digit is a 9.

### The Chain Reaction

Because 9 + 1 equals 10, you have to write down a 0 and "carry" the 1 over to the next column to the left. Since we are only ever adding a single 1, this carry-over creates a chain reaction that only survives as long as it keeps hitting more 9s. The absolute moment the carry-over hits a digit that is not a 9, the digit absorbs the 1, the chain reaction dies instantly, and the math is finished.

---

## Step-by-Step Guide

1. Start at the very end of your list of numbers (the far right side) and plan to walk backward toward the front.
2. Look at the number you are currently standing on. Ask: "Is this number smaller than 9?"
3. **If YES:** Simply add one to this number. The math is completely done. Stop everything and give back your list.
4. **If NO:** The number must be exactly 9. Adding one makes it a 10. Erase the 9, write down a 0 in its place, and carry the 1 over in your head.
5. Take one step to the left to look at the next number, and repeat steps 2 through 4 to process the carry-over.
6. **The Overflow Problem:** What if you walk all the way past the front of the list and never stopped? That means every single number you looked at was a 9 (for example, 99 or 9999). Every spot on your list is now a 0, and you are standing holding a carried 1 with nowhere to put it.
7. To fix this, get a brand new blank list that is exactly one space longer than your old list. Write a 1 in the very first space. (Because the rest of a new list defaults to 0s, you have perfectly created numbers like 100 or 10000).
8. Give back this brand new list.

---

## Complexity Analysis

* **Time Complexity:** $O(N)$
* In the best-case scenario (the last digit is not a 9), the algorithm finishes instantly in $O(1)$ time. However, in the worst-case scenario (all 9s), you must walk backward through every single digit exactly once. Therefore, the maximum time it takes scales linearly with the number of digits $N$.


* **Space Complexity:** $O(1)$ or $O(N)$
* Most of the time, the space complexity is $O(1)$ because you are simply modifying the existing array in place without using any extra memory. However, in the worst-case scenario where the number rolls over (like 99 to 100), you are forced to allocate a completely new array of size $N + 1$, resulting in an $O(N)$ auxiliary space requirement.
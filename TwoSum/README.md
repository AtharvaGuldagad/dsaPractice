# Two Sum #

---

### Brute force ###

> Time Comp O(n^2)

> Space Comp O(1)

the classic brute force approach, using 2 loops and checking the whole array one by one

---

### Optimized ###

> Time Comp O(n)

> Space Comp O(n)

The optimized sol uses a hashmap to reduce the Time Comp,
*Checking the difference between the target and current val, if it exists in the map, return those two indices, else add the current val to the map*
this sacrifices Space for saving time
---
[Link-To-Problem](https://neetcode.io/problems/two-integer-sum/question)
# Valid Anagram #

---

### Brute force ###

> Time Comp O(n^2)

> Space Comp O(1)

Sort the string and compare them one on one as anagrams are the same letters rearranged
sorting takes O(n^2) while taking no extra memory

---

### Optimized ###

> Time Comp O(nlogn)

> Space Comp O(2n)

The optimized sol uses 2 **HashMaps** to reduce the Time Comp,
*We take 2 HashMaps, for both the strings, and check if there already exists the current letter (key)*
*Yes? increment the value (this is a counter for the number of instances that key appeared)*
*No? add this char (key) to the respective map*
*return the equality of these Maps*

this sacrifices Space for saving time
---
[Link-To-Problem](https://neetcode.io/problems/is-anagram/question)
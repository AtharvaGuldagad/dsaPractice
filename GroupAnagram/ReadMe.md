# Valid Anagram #
---

This was a medium difficulty question and it took me quite a while to understand it
I was fighting the syntax of predifined functions i saw on the internet

---
### Thought Process ###

    what does the output want?
     |- anagrams grouped together
     |- original words

    Solution
    |- create a HashMap
    |- convert the string into an array
    |- sort this array (letters)
    |- create a new string (sortedKey) and add this sorted array
    |- check the map if it has the sorted version of this Key (current string)?
     \- if yes then add it to the list of these strings
     /- if no then add a new key (original word) and create a dynamic array for it and add the word regardless (current word)
    |- return the Map values

    Failed but possible approach:
        we may use the previous is-anagram function and use it
        to check if the current word has any other anagrams in the list
        and add it to the map list
        the main challenge to encounter here would be to ignore the already added words
        otherwise the program will check the already added words when it comes up next

---

### Optimized ###

> Time Comp O(n * klogk)

> Space Comp O(n * k)

---
[Link-To-Problem](https://neetcode.io/problems/anagram-groups/question)
# Encode and Decode Strings

## Intuition

### The Delimiter Problem
When combining a list of strings into a single string, the most obvious approach is to use a special character (like a comma or a dash) to separate them. However, this creates a major flaw: if the original strings contain that special character, the decoding process will break because it won't know if the character is part of the word or a separator. 

### The Length-Prefix Solution
To safely pack and unpack the strings regardless of their content, we must tell the decoder exactly how many characters to read for the next word. We achieve this by prefixing every string with its exact character count, followed by a designated separator (like `#`) to distinguish where the number ends and the word begins. Even if the word itself contains `#` or numbers, the decoder will not be confused because it will strictly read the exact number of characters specified.

---

##Step-by-Step Guide

### Encode Process
1. Make big empty text box to hold everything.
2. Look at first word in the list.
3. Count how many letters are in the word.
4. Write that number down in the big box.
5. Write a special mark `#` right after the number.
6. Write the actual word right after the mark.
7. Repeat steps 2 through 6 for every word in the list.
8. Give back the big text box.

### Decode Process
1. Make an empty list to hold the found words.
2. Look at the big long text. Start at the very beginning.
3. Walk forward letter by letter until you see the `#` mark.
4. Look at the numbers you passed before hitting the mark. That tells you the size of the next word.
5. Step one space past the `#` mark.
6. Grab exactly that size of letters. You found a word. Put it in the list.
7. Jump your starting point past the word you just grabbed.
8. Repeat steps 3 through 7 until you reach the end of the big text.
9. Give back the list of words.

---

## Complexity Analysis

* **Time Complexity:** O(N)
    * Both the encoding and decoding processes require iterating through every character exactly once. $N$ represents the total number of characters across all strings combined. String concatenation using a StringBuilder keeps the appending operations efficient.
* **Space Complexity:** O(N)
    * For the encode function, we allocate memory for a single string of length $N$ to store the combined result. For the decode function, we allocate memory for an array/list that will hold all the separated strings, which also scales linearly with the total number of characters N.
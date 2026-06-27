# Longest Substring Without Repeating Characters

## Intuition

### The Exhaustive Search Approach

The code provided uses a brute-force methodology. To find the longest sequence of unique characters, it treats every single character in the string as a potential starting point. From each starting point, it looks ahead character by character, building a sequence and checking a memory set to ensure no letter is repeated. The moment it sees a letter that is already in the set, it abandons that starting point and moves on to the next one.

### The Optimal Sliding Window Alternative

While the exhaustive search works perfectly, checking every possible starting point from scratch causes a lot of repetitive work. The strictly optimal way to solve this is using a "Sliding Window" approach, which achieves an $O(N)$ time complexity. Instead of starting over when a duplicate is found, a sliding window uses two pointers (left and right) to expand a window until a duplicate is found, and then slowly shrinks the window from the left until the duplicate is removed, passing through the string only once.

---

## Step-by-Step Guide

1. Check the word. If it is completely empty, give back a zero.
2. Keep a record of the longest chain of unique letters you have found. Start this record at one.
3. Start walking through the word. Pick a letter to be the starting point of your chain.
4. Get an empty bag to hold the letters for this specific chain. Throw your starting letter into the bag.
5. Look at the very next letter in the word.
6. Ask the bag: "Do you already have this letter inside you?"
7. **If the bag says NO:** Throw the letter into the bag. Count how many letters are now inside. If this count is bigger than your longest record, erase the old record and write down this new number. Step forward to the next letter and repeat step 6.
8. **If the bag says YES:** Your chain is broken. Stop looking forward.
9. Move your starting point to the next letter in the word, grab a brand new empty bag, and repeat the whole process.
10. Once you have tried building a chain from every single letter in the word, give back your longest record.

---

## Complexity Analysis

* **Time Complexity:** $O(N^2)$

* **Space Complexity:** $O(K)$
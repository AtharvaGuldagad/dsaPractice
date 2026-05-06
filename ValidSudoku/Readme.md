# Valid Sudoku

## Intuition

### The Core Rules
To verify if a Sudoku board is valid, we do not need to solve it. We only need to check the current numbers on the board against three specific rules. A number can only appear once per row, once per column, and once per 3x3 sub-box. 

### The "Nametag" HashSet Trick
The standard approach is to create separate lists or sets for every single row, column, and box. However, a clever trick allows us to use just one single, unified `HashSet`. 

We can do this by converting every number we find into three unique "nametags" (strings). For example, if we find the number '5' at row 0 and column 2, we create three distinct sentences:
* "5 at row 0"
* "5 at col 2"
* "5 in box 0-0" (We find the box by dividing the row and column coordinates by 3).

When we try to add these nametags to our single set, the set will automatically reject any tag it has already seen. If a tag is rejected, it means that exact number was already logged in that exact row, column, or box, proving the board is invalid.

---

## Step-by-Step Guide

1. Get one big, empty bag to hold special nametags.
2. Start looking at the grid. Go row by row, from top to bottom, checking every single square.
3. If a square is completely empty, ignore it and walk to the next square.
4. If you find a number in a square, make three unique nametags for it:
    * Write down the number and what row it lives in.
    * Write down the number and what column it lives in.
    * Write down the number and what big 3x3 block it lives in (you find the block by dividing its row and column by 3).
5. Try to throw all three of these nametags into your big bag.
6. The bag checks if it already has an identical nametag inside. 
    * If the bag says "I already have this tag," that means the number broke a rule. Stop everything and declare the board broken.
    * If the bag accepts the tags, move to the next square.
7. If you finish walking through all 81 squares and the bag never rejected a single tag, the board is perfectly fine.

---

## Complexity Analysis

* **Time Complexity:** $O(1)$
    * Because a standard Sudoku board is always exactly 9x9, the number of operations never changes. We iterate exactly 81 times, making the time complexity mathematically constant. (If this were an infinitely scaling $N \times N$ board, the time complexity would be $O(N^2)$).
* **Space Complexity:** $O(1)$
    * Similar to the time complexity, the maximum amount of data we can store in our memory bag is capped. At most, we will store 3 nametags for all 81 squares, meaning our set will never exceed 243 strings. Since this upper limit is fixed, the space required is constant.
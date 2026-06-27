# Rotate Image

## Intuition

### The Geometry Trick

Rotating a square grid exactly 90 degrees clockwise in a single step requires keeping track of four different moving pieces at once, which can be mathematically confusing. However, any 90-degree rotation can be broken down into two much simpler mirror reflections.

### Transpose and Reverse

Instead of rotating, we can flip the matrix twice:

1. **Transpose (Diagonal Flip):** First, we flip the grid across its main diagonal (the line from the top-left to the bottom-right). This action turns every row into a column. The numbers are now grouped correctly, but they are arranged from left to right instead of right to left.
2. **Reverse (Horizontal Flip):** Second, we look at each row individually and reverse it, flipping the grid horizontally. This pushes the correct columns into their final clockwise positions.

---

## Step-by-Step Guide

1. Imagine a diagonal line drawn from the top-left corner of your grid all the way down to the bottom-right corner.
2. Walk through the top-right triangle of your grid.
3. For every number you stand on, find its exact mirror reflection on the other side of that diagonal line (the bottom-left triangle). Swap those two numbers.
4. Once you have swapped across the diagonal, all of your original rows are now standing up as vertical columns.
5. Next, look at the very first row of your grid.
6. Swap the first number in that row with the last number. Swap the second number with the second-to-last number. Stop when you hit the middle.
7. Move down to the next row and repeat step 6.
8. Once you have horizontally reversed every single row from top to bottom, your entire grid is perfectly rotated.

---

## Complexity Analysis

* **Time Complexity:** $O(N^2)$
* Let $N$ be the length of one side of the matrix, meaning there are $N^2$ total cells. We perform two separate passes over the grid. The first pass swaps elements across the diagonal, touching about half the cells. The second pass reverses each row, again touching about half the cells. Overall, the time taken scales linearly with the total number of cells in the grid.


* **Space Complexity:** $O(1)$
* The problem strictly requires rotating the image in place. We only use one temporary integer variable to swap the numbers. No new grids or arrays are created, meaning the auxiliary memory used is perfectly constant regardless of the matrix size.
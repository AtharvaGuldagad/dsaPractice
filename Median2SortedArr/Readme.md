# Median of Two Sorted Arrays

## ONE OF THE HARDEST QUESTIONS I'VE SOLVED :(

## Intuition

### The Perfect Split

The fundamental definition of a median is a number that splits a dataset perfectly in half: every number to the left is smaller, and every number to the right is larger.

Because our two input arrays are already sorted, we do not actually need to merge them to find this midpoint. If we can draw a vertical dividing line through both arrays in such a way that the total number of elements on the left side of the lines equals the total number of elements on the right side, we are very close. If we can additionally ensure that every element on the left side of both lines is smaller than every element on the right side of both lines, we have found the perfect median boundary without ever sorting a single new array.

### Binary Searching the Partition

To find where to draw these lines quickly, we can use binary search on the *smaller* of the two arrays. If we guess a dividing line for the smaller array, the dividing line for the larger array is automatically dictated by math (because the left side must always contain exactly half of the total elements).

By checking the elements immediately adjacent to our dividing lines, we can instantly tell if our guess was correct:

* If the left elements are smaller than the opposite right elements, the split is perfect.
* If a left element is too big, it means our dividing line is too far to the right, and we must adjust our binary search to the left.

---

## Step-by-Step Guide

1. Compare your two lists. Identify the shorter list. You will only do your guessing on the shorter list because it requires fewer steps.
2. Figure out the total number of items across both lists. Calculate exactly how many items need to sit on the "left half" of the final combined dataset.
3. Place a start marker at the beginning of the short list and an end marker at the end of the short list.
4. Guess a spot exactly in the middle of your markers to "chop" the short list into a left piece and a right piece.
5. Because you know exactly how many items the left half needs in total, subtract the number of items in your short list's left piece to find out exactly where you MUST chop the long list.
6. Now you have chopped both lists. Look at the four numbers touching the chop lines:
* The biggest number on the left side of list A.
* The smallest number on the right side of list A.
* The biggest number on the left side of list B.
* The smallest number on the right side of list B.


7. Check if the split is valid by asking: "Is A's biggest left number smaller than or equal to B's smallest right number? AND is B's biggest left number smaller than or equal to A's smallest right number?"
8. **If YES:** You found the perfect split.
* If the total number of items is odd, the median is simply the biggest number out of all the left-side numbers.
* If the total number of items is even, find the biggest left-side number and the smallest right-side number, add them together, and divide by 2.0. Stop here.


9. **If NO:** Your chop on the short list was in the wrong spot.
* If A's biggest left number was too large, your chop is too far to the right. Move your end marker to the left.
* If B's biggest left number was too large, your chop on A is too far to the left. Move your start marker to the right.


10. Repeat steps 4 through 9 until you find the perfect split.

---

## Complexity Analysis

* **Time Complexity:** $O(\log(\min(M, N)))$

* **Space Complexity:** $O(1)$

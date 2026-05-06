# Find Minimum in Rotated Sorted Array

## Intuition

### The Two Slopes
When a sorted array is rotated, it forms two distinct, increasing sequences—think of them as two slopes or a cliff. The left sequence consists of large numbers, and the right sequence consists of smaller numbers. The smallest number in the entire array is exactly where the cliff drops off, which is the very first number of the right sequence.

### Finding the Drop-off
To find this drop-off quickly without checking every single number, we can use binary search. By picking a number in the middle and comparing it to the *very last* number in the array, we can figure out which slope we are currently standing on:
* **If the middle number is larger than the last number:** We are standing on the high, left slope. Since the array drops off eventually, the smallest number must be somewhere to our right.
* **If the middle number is smaller than the last number:** We are standing on the low, right slope. This means the drop-off already happened, so the smallest number must be to our left (or we are standing exactly on it).

By repeating this, we trap the smallest number.

---

## Step-by-Step Guide

1. Set up two markers: one at the very start of the list and one at the very end.
2. Check if the number at the start is smaller than or equal to the number at the end. If it is, the list is not rotated at all. The very first number is the smallest. Stop and give back that first number.
3. If the list is rotated, find the exact middle point between your start and end markers.
4. Look at the number at this middle point. Compare it to the very last number in the entire list.
5. If the middle number is bigger than the last number, the smallest number is hiding to the right. Move your start marker to the spot just past the middle.
6. If the middle number is smaller than the last number, the smallest number is to the left (or you are exactly on it). Move your end marker to the spot just before the middle.
7. Repeat steps 3 through 6 until your start and end markers squeeze together.
8. When the markers meet, they will be pointing directly at the smallest number. Give back the number at the start marker.

---

## Complexity Analysis

* **Time Complexity:** $O(\log N)$
    * Because we find the middle point and discard half of the remaining numbers at every step, the search area shrinks exponentially. Even for a massive list, it takes very few steps to pinpoint the minimum value.
* **Space Complexity:** $O(1)$
    * We are only using three integer variables for our pointers and the middle index. No new arrays or extra memory are created, so the space used remains constant regardless of the list size.
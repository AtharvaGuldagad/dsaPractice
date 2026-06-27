# Search in Rotated Sorted Array

## Intuition

### The Half-Sorted Guarantee

When you cut a rotated sorted array exactly in half, it is a mathematical guarantee that at least one of those halves will be perfectly sorted. It is impossible to have the rotational "drop-off" point in both halves at the same time.

### The Process of Elimination

Instead of blindly searching or trying to find the drop-off point first, we can use this half-sorted guarantee to our advantage. At every step, we first identify which half of our current search area is the normally sorted half. Once we know which side is normal, it becomes trivial to check if our target belongs in there. If the target's value falls strictly within the minimum and maximum boundaries of the sorted half, we safely discard the messy half. If it doesn't fit in the sorted half, we know it *must* be hiding in the messy half, so we discard the sorted side.

---

## Step-by-Step Guide

1. Place a marker at the very beginning of the list and another at the very end.
2. Find the exact middle point between your two markers.
3. Look at the number at the middle point. If it is exactly the number you are looking for, stop and give back its position.
4. If it is not your number, you must figure out which half of your current list is perfectly normal (not rotated). Compare the start number to the middle number.
5. **If the start number is smaller than or equal to the middle number:** You know the left side is perfectly normal.
* Ask: "Is my target number larger than the start number AND smaller than the middle number?"
* If YES, the target is trapped in this normal left side. Move your end marker to the spot just before the middle.
* If NO, the target must be in the right side. Move your start marker to the spot just after the middle.


6. **If the start number is bigger than the middle number:** You know the right side is perfectly normal.
* Ask: "Is my target number larger than the middle number AND smaller than the end number?"
* If YES, the target is trapped in this normal right side. Move your start marker to the spot just after the middle.
* If NO, the target must be in the left side. Move your end marker to the spot just before the middle.


7. Repeat steps 2 through 6 until your markers cross each other.
8. If the markers cross and you still haven't found the number, it does not exist in the list. Give back -1.

---

## Complexity Analysis

* **Time and Space Complexity:** Time complexity is $O(\log N)$ because the search space is aggressively cut in half during every single iteration, and space complexity is $O(1)$ because we only utilize a few integer variables to track our boundary pointers.
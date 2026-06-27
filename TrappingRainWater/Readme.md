# Trapping Rain Water

## Intuition

### The Bottleneck Principle

To figure out how much water can be trapped above any given block of land, you need to look at the tallest walls to its left and right. The water level is always bottlenecked by the shorter of these two boundaries. The actual water held at that specific spot is simply the height of that bottleneck minus the height of the land itself.

### The Two-Pointer Squeeze

Instead of scanning the entire array multiple times to find the tallest left and right boundaries for every single block, we can use two pointers starting at the absolute edges and moving inward.

By comparing the heights at the left and right pointers, we can confidently decide which side is the limiting factor:

* If the left pointer's height is smaller, we know the water level on the left side is strictly bounded by whatever the maximum left wall we've seen so far is, regardless of what lies further right.
* If the right pointer's height is smaller, the water level is strictly bounded by the maximum right wall.

We process the shorter side, add any trapped water, and move that pointer inward until the two pointers meet in the middle.

---

## Step-by-Step Guide

1. Set up two workers: place one at the far left edge of the map and the other at the far right edge.
2. Give each worker a notepad to record the tallest wall they have encountered on their respective sides.
3. Get a large bucket to keep a running total of all the water collected.
4. Compare the walls where the two workers are currently standing. Whichever worker is standing on the smaller wall must take a turn.
5. The active worker checks their current wall against the tallest wall recorded on their notepad.
6. If their current wall is shorter than their notepad wall, water can be trapped here. Pour water to fill the gap up to the notepad height, and add this amount to the bucket.
7. If their current wall is taller than or equal to their notepad wall, no water can pool here. The worker updates their notepad with this new, taller height.
8. The active worker takes one step inward toward the middle.
9. Repeat steps 4 through 8 until the left and right workers bump into each other.
10. Give back the total amount of water collected in the bucket.

---

## Complexity Analysis

* **Time Complexity:** $O(N)$



* **Space Complexity:** $O(1)$

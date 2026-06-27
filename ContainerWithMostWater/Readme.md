# Container With Most Water

## Intuition

### The Width vs. Height Trade-off

The amount of water a container can hold is dictated by its width (the distance between the two walls) multiplied by its height. However, the water can only ever be as high as the shorter of the two walls.

To maximize the area, it makes sense to start with the widest possible container by selecting the very first and very last walls. From this starting point, any move we make to bring the walls closer together will strictly decrease the width. Therefore, to ever beat our initial area, we must find taller walls to compensate for the lost width.

### The Shorter Wall Rule

Because the shorter wall is the absolute bottleneck for the water level, keeping it and moving the taller wall inward is a mathematically guaranteed loss. Moving the taller wall inward decreases the width without any possible chance of increasing the height limit. The only logical choice is to discard the shorter wall and move its pointer inward, hoping to encounter a taller wall that might offset the shrinking width.

---

## Step-by-Step Guide

1. Place one marker at the far left edge of the lines and another marker at the far right edge.
2. Keep a blank record of the biggest area of water you have found so far. Start this at zero.
3. Look at the two walls your markers are currently pointing to. Identify which of the two walls is shorter.
4. Calculate the current area. Find the distance between your two markers, and multiply that distance by the height of the shorter wall.
5. If this calculated area is larger than your current record, erase the old record and write down this new, larger number.
6. To look for a better combination, you must give up the shorter wall.
* If the left wall is the shorter one, move your left marker one step inward.
* If the right wall is the shorter one, move your right marker one step inward.


7. Repeat steps 3 through 6 over and over until your left and right markers touch each other.
8. Give back the largest area record you wrote down.

---

## Complexity Analysis

* **Time Complexity:** $O(N)$

* **Space Complexity:** $O(1)$
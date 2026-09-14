# Rectangle Overlap

## Intuition

### 1D Projection Intersection (Axis-Aligned Bounding Box)

Two axis-aligned rectangles overlap if and only if their projections along **both** the X-axis and Y-axis overlap simultaneously.

Each rectangle is represented by bottom-left and top-right coordinates: `[x1, y1, x2, y2]`.

1. **X-Axis Overlap:** Rectangles `r1` and `r2` overlap horizontally if `r1` starts to the left of `r2`'s right edge (`r1[0] < r2[2]`) **and** `r2` starts to the left of `r1`'s right edge (`r2[0] < r1[2]`).
2. **Y-Axis Overlap:** Similarly, they overlap vertically if `r1` starts below `r2`'s top edge (`r1[1] < r2[3]`) **and** `r2` starts below `r1`'s top edge (`r2[1] < r1[3]`).

Checking strict inequality (`<` instead of `<=`) ensures that touching edges or corners (zero area overlap) are correctly identified as non-overlapping.

---

## Step-by-Step Guide

1. Compare horizontal interval ranges `[r1[0], r1[2]]` and `[r2[0], r2[2]]`:
* Verify `r1[0] < r2[2]` AND `r2[0] < r1[2]`.


2. Compare vertical interval ranges `[r1[1], r1[3]]` and `[r2[1], r2[3]]`:
* Verify `r1[1] < r2[3]` AND `r2[1] < r1[3]`.


3. Return `true` if all four conditions hold; otherwise, return `false`.

---

## Complexity Analysis

* **Time Complexity:** $O(1)$
* Performs a fixed number of primitive coordinate comparisons in constant time.


* **Space Complexity:** $O(1)$
* Uses strictly constant auxiliary memory without allocating extra data structures.
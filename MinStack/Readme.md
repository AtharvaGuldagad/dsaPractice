# Min Stack

## Intuition

### The Bottleneck of a Standard Stack

A standard stack easily gives you the most recently added item in constant time. However, if you want to find the absolute minimum value hiding inside that stack, you would normally have to dig through all the items one by one, which takes $O(N)$ time.

### The Shadow Stack Strategy

To get the minimum value instantly, we can maintain a second, "shadow" stack alongside our main stack. This shadow stack's only job is to keep a historical record of the smallest numbers.

When a new number arrives, we add it to our main stack. If that new number is smaller than or equal to our current minimum, we also add it to the shadow stack. The brilliance of this approach is in the removal process: when we pop an item off the main stack, we check if it matches the top of our shadow stack. If it does, we pop it from there too, instantly exposing the *previous* minimum value that was sitting right underneath it.

---

## Step-by-Step Guide

1. Get two buckets: one regular bucket for holding everything you are given, and one special bucket for holding only the smallest things you have seen.
2. **When given a new item:** * Throw it into the regular bucket.
* Look at the top of your special bucket. If the special bucket is completely empty, or if your new item is smaller than (or exactly the same size as) the item sitting on top, throw a copy of your new item into the special bucket too.


3. **When asked to remove an item:**
* Take the top item out of your regular bucket.
* Look at the item you just took out. If it is exactly the same as the item sitting on top of your special bucket, remove the top item from the special bucket as well.


4. **When asked what the top item is:**
* Just peek at the top of your regular bucket and report what it is. Do not remove it.


5. **When asked what the smallest item is:**
* Just peek at the top of your special bucket and report what it is. Because of how you built it, the smallest item will always be sitting right at the top.



---

## Complexity Analysis

* **Time Complexity:** $O(1)$

* **Space Complexity:** $O(N)$

# Largest Rectangle in Histogram

## Intuition

### The Bottleneck Bar

The height of any rectangle you try to draw inside a histogram is strictly limited by the shortest bar enclosed within it. To find the absolute largest rectangle, you could theoretically treat every single bar as the ultimate "bottleneck" (the shortest bar), and see how far you can stretch a rectangle to its left and right before hitting something shorter. However, doing this manually for every bar requires looking back and forth constantly, which is highly inefficient.

### The Monotonic Stack Strategy

To do this in a single pass, we can use a stack to keep track of bars that are still "open" to being stretched to the right. We only keep bars in the stack if they are continuously getting taller.

The moment we encounter a shorter bar, it acts as a concrete wall. We instantly know that the taller bars currently sitting at the top of our stack cannot stretch any further right. Because of how we stacked them, we also already know their left limit: the bar directly underneath them in the stack. With both boundaries instantly defined, we can pop the tall bar out, calculate its maximum area, and confidently move on.

---

## Step-by-Step Guide

1. Get a blank notepad to record the "biggest area found so far" and start it at zero.
2. Get a tall, empty bucket. This bucket will hold the position numbers of the bars as you walk past them.
3. Start walking past the bars from left to right. Pretend there is one extra, completely flat bar (height of zero) sitting at the very end of the line. This fake bar is a trick to force you to evaluate everything left in your bucket at the very end.
4. For the bar you are currently standing at, look at its height.
5. Look inside your bucket. If the bucket is not empty, look at the position number sitting right at the top. Ask: "Is the bar I am currently standing at *shorter* than the bar at the top of the bucket?"
6. **If YES:** The tall bar from the bucket has hit a wall. It cannot stretch any further forward.
* Pull its position out of the bucket. This is your active "bottleneck" bar.
* Look at how tall it is.
* Calculate how wide it can stretch. Its forward boundary is where you are currently standing. Its backward boundary is whatever position is now sitting at the top of the bucket. (If the bucket is empty, it means the bar stretches all the way back to the very beginning).
* Multiply the height by this width to get the area.
* If this area is bigger than the record on your notepad, erase the old number and write down this new one.
* *Do not step forward yet.* Keep looking down into the bucket and repeating steps 5 and 6. Your current short bar might be a wall for several tall bars piled up inside.


7. **If NO (or after you finish pulling out the taller bars):** Drop the position of your current bar into the bucket so it can see how far forward it can stretch.
8. Step forward to the next bar and repeat steps 4 through 7.
9. Once you walk past the final fake flat bar and your bucket is empty, give back the biggest area number from your notepad.

---

## Complexity Analysis

* **Time Complexity:** $O(N)$

* **Space Complexity:** $O(N)$
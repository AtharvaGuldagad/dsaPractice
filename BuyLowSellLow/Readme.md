# Best Time to Buy and Sell Stock

## Intuition

### The Time Travel Problem

The fundamental rule of the stock market is that you must buy a stock before you can sell it. This means you cannot just find the absolute highest price and the absolute lowest price in the array, because the lowest price might occur *after* the highest price. For any given day you are considering selling, you only care about the absolute lowest price you could have bought it for *in the past*.

### The Running Minimum Strategy

To avoid repeatedly looking backward to find the best buying opportunity, we can simply maintain a running record of the lowest price we have encountered so far as we move forward in time. For each day, we calculate how much profit we would make if we sold at today's price, having bought at our recorded historical minimum. By constantly updating both the minimum price seen and the maximum profit calculated, we can find the optimal transaction in a single pass.

---

## Step-by-Step Guide

1. Get a notepad. Look at the very first day's price and write it down as your "cheapest price seen".
2. Write down your "best profit" as zero.
3. Start walking through the timeline, looking at the price for every single day.
4. When you look at today's price, ask yourself: Is today's price cheaper than the "cheapest price seen" on your notepad? If it is, cross out the old number and write down today's price.
5. Next, calculate what would happen if you sold your stock today. Subtract your "cheapest price seen" from today's price to find your hypothetical profit for the day.
6. Look at your hypothetical profit. Is it larger than the "best profit" on your notepad? If it is, cross out the old record and write down this new, larger profit.
7. Step forward to the next day and repeat steps 4 through 6 until you have evaluated every single day in the sequence.
8. Once you reach the end of the timeline, give back the "best profit" you recorded.

---

## Complexity Analysis

* **Time Complexity:** $O(N)$

* **Space Complexity:** $O(1)$
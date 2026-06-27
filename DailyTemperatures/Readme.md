# Daily Temperatures

## Intuition

### The Waiting Game

If you stand on day one and look forward at every single future day until you find a warmer one, and then repeat that exact same process for day two, day three, etc., you end up doing a massive amount of repetitive checking. This brute-force method takes $O(N^2)$ time. Instead of looking forward, it is much more efficient to just hold onto the days that are currently waiting for a warm up, and let the future days resolve them as they arrive.

### The Monotonic Stack Strategy

We can use a stack to remember the *indexes* (the day numbers) of the days we are waiting to resolve. We only leave a day in the stack if we haven't found a warmer day yet. This means the temperatures represented in the stack will always be decreasing from bottom to top.

The moment a warm day arrives, we compare it to the top of the stack. If today is warmer, the waiting is over for that past day. We pop it out, calculate how many days passed, and immediately check the next day underneath it. A single very hot day can instantly resolve the waiting period for multiple cold days piled up in the stack.

---

## Step-by-Step Guide

1. Get a notepad to write down your final answers. It will hold exactly one answer for every day in the forecast.
2. Get a tall, empty bucket. This bucket will hold the "day numbers" that are currently freezing and waiting for a warmer day.
3. Start walking through the weather forecast, looking at the temperatures day by day.
4. When you look at today's temperature, check your bucket.
5. If the bucket is not empty, look at the day number sitting right at the top. Ask: "Is today's temperature hotter than the temperature it was on that past day?"
6. **If YES:** That past day is finally done waiting. Pull it out of the bucket. Figure out how long it waited by subtracting the past day number from today's day number. Write that wait time down on your notepad in the spot for that past day.
7. Don't stop there. Keep looking down into the bucket and repeating step 6. Today might be hot enough to solve the waiting problem for several consecutive past days piled up in the bucket. Stop pulling days out only when the bucket is empty, or when the day at the top of the bucket was actually hotter than today.
8. **If NO (or after you finish pulling out the colder days):** Drop today's day number into the bucket so it can begin its own wait for a warmer day.
9. Step forward to the next day in the forecast and repeat steps 4 through 8.
10. Once you reach the end of the forecast, hand back your notepad. Any days left stuck in the bucket just never get a warmer day, so their answer on the notepad defaults to zero.

---

## Complexity Analysis

* **Time Complexity:** $O(N)$
* We iterate through the array of temperatures exactly once. Although there is a `while` loop nested inside the `for` loop, the work done inside the `while` loop is strictly bounded. Every single day index is pushed into the stack exactly once, and it is popped out of the stack at most once. Therefore, the operations scale linearly with the number of days $N$.


* **Space Complexity:** $O(N)$
* We allocate memory for the results array, which requires $N$ spaces. Additionally, the stack itself can grow to size $N$ in the worst-case scenario (for example, if the temperatures are strictly decreasing every day, meaning no day is ever resolved and popped out until the end).
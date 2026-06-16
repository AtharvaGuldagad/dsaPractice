# Koko Eating Bananas

## Intuition

### The Speed Boundaries

Koko can only eat from one single pile per hour. This creates a hard ceiling on how fast she actually needs to eat. The absolute fastest speed she would ever need to adopt is eating the single largest pile in exactly one hour. Eating any faster than that provides zero benefit, because even if she finishes a small pile in five minutes, she has to sit and wait for the next hour to start the next pile. On the flip side, the absolute slowest she can eat is 1 banana per hour.

### Binary Searching the Answer

Our perfect eating speed is a number trapped somewhere between 1 and the size of the largest pile. Instead of testing every single speed from 1 counting upward, we can use binary search on the range of possible speeds.

We guess the middle speed and calculate how many hours it takes to eat everything.

* If she finishes within the time limit, that speed is valid. However, since we want the *minimum* speed, we discard all faster speeds and search the lower half to see if she can afford to eat even slower.
* If she runs out of time, that speed is too slow. We discard all slower speeds and search the upper half.

---

## Step-by-Step Guide

1. Walk through all the piles of bananas and find the absolute biggest pile.
2. Write down your minimum possible speed as 1. Write down your maximum possible speed as the size of that biggest pile you just found.
3. Keep a notepad to record the "best working speed".
4. Pick a test speed that is exactly halfway between your minimum and maximum speeds.
5. Do a test run: Walk through every single pile and calculate how many hours it takes to eat it at your current test speed. (Remember, if a pile has fewer bananas than your speed, it still takes exactly 1 full hour. If a pile has a remainder, it takes an extra hour to finish those leftovers).
6. Add up all the hours from your test run to get a total time.
7. Compare your total time to the time limit you were given.
8. **If your total time is less than or equal to the limit:** Koko finishes in time. This speed works. Write it down on your notepad as the new "best working speed". But maybe she can eat slower. Change your maximum speed to be just under your current test speed.
9. **If your total time is strictly greater than the limit:** Koko is eating too slowly and ran out of time. Change your minimum speed to be just above your current test speed.
10. Repeat steps 4 through 9 until your minimum and maximum speeds squeeze together and cross.
11. Give back the number written on your notepad.

---

## Complexity Analysis

* **Time Complexity:** $O(N \log M)$
* Let $N$ be the total number of banana piles, and let $M$ be the size of the single largest pile. We perform a binary search on the range of possible speeds from 1 to $M$, which takes $O(\log M)$ iterations. During every single one of those iterations, we must loop through all $N$ piles to calculate the total hours required. Multiplying the search steps by the evaluation steps gives us $O(N \log M)$.


* **Space Complexity:** $O(1)$
* We are only using a handful of integer variables to track our minimum speed, maximum speed, test speed, and total time. No new arrays or complex data structures are created, meaning the auxiliary memory used is strictly constant.
# Car Fleet

### REVISIT & REVISE

## Intuition

### The Traffic Jam Principle

On a single-lane road where passing is impossible, a fast car starting behind a slow car will inevitably catch up. Once it catches up, it gets stuck bumper-to-bumper and is forced to slow down to match the speed of the car ahead. These grouped cars become a single "fleet." To determine how many fleets arrive at the destination, the only metric that truly matters is time.

### Working Backwards

If we evaluate the cars starting from the ones furthest away, the logic gets incredibly tangled because we don't know what kind of traffic is piled up ahead of them yet.

The easiest way to solve this is to sort the cars by their starting position and evaluate them from the front of the pack (closest to the target) to the back. The car closest to the target sets the absolute baseline pace. We calculate how long it takes to reach the target. Then, we look at the car immediately behind it. If the car behind has a calculated arrival time that is *less than or equal to* the car in front, a collision is guaranteed before the finish line. The faster car's arrival time is completely erased by reality, and it joins the slower car's fleet.

---

## Step-by-Step Guide

1. Get a fresh piece of paper. For every single car, write down its starting spot right next to its speed so the information is paired together.
2. Sort your list of cars based on their starting spots. Put the car that is closest to the finish line at the very top of the list, and the car furthest away at the very bottom.
3. Get an empty bucket. This bucket will hold the confirmed "arrival times" for the separate groups of cars.
4. Start reading your list from top to bottom (closest car to furthest car).
5. For the car you are looking at, calculate how long it would take to reach the finish line if the road were completely empty. You do this by finding the distance to the target (target minus position) and dividing it by the car's speed.
6. Drop this calculated time into your bucket.
7. Look into your bucket. If there are at least two times inside, look at the top two. The very top time belongs to the car you just processed. The time right below it belongs to the car physically in front of it on the road.
8. Compare the two times: "Is the car I just processed going to arrive in less time (or the exact same time) as the car in front of it?"
9. **If YES:** That means the car behind drives faster and crashes into the back of the car ahead before crossing the finish line. They merge into one group. Pull the faster time out of the bucket and throw it away, because that car is now permanently stuck going the slower speed.
10. Repeat steps 4 through 9 for every single car on your list.
11. Once you have checked every car, count how many times are left sitting in your bucket. That number is exactly how many separate groups cross the finish line. Give back that number.

---

## Complexity Analysis

* **Time Complexity:** $O(N \log N)$

* **Space Complexity:** $O(N)$

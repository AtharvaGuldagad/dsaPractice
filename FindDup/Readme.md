# Find the Duplicate Number

## Intuition

### The Memory Trade-off

The most natural way to find a repeating number is to keep a history of every element you've seen so far. By storing numbers inside a `HashSet`, we can check if a number has appeared before in constant time. The moment we process a number that already exists in our set, we have found our duplicate.

### The Optimal Constant Space Alternative

While this `HashSet` approach is highly intuitive and runs efficiently, it breaks the strict $O(1)$ auxiliary space constraint often demanded by this problem (such as on LeetCode). The optimal way to solve this in $O(1)$ space without modifying the array is **Floyd's Tortoise and Hare (Cycle Detection) algorithm**. Because the values in the array are bounded between 1 and $n$, we can treat the array values as pointers to other indices. A duplicate value means multiple indices point to the same slot, which mathematically creates a cycle in a linked-list-like structure that we can trace using a fast and slow pointer.

---

## Step-by-Step Guide

1. Get an empty bag (your HashSet) to keep track of every number you inspect.
2. Start walking through the array from the first number to the last.
3. Pick up the current number and ask the bag: "Have you seen this specific number before?"
4. **If YES:** The search is over. You have successfully caught the duplicate number. Stop immediately and give this number back.
5. **If NO:** Drop the number inside the bag so you can remember it if it appears again later.
6. Step forward to the next number in the array and repeat steps 3 through 5.
7. If you check every single slot in the array and the bag never finds a match, give back -1 (though the problem guarantees a duplicate always exists).

---

## Complexity Analysis

* **Time Complexity:** $O(N)$
* We iterate through the array of numbers at most once. Inside the loop, checking for containment and adding elements to a `HashSet` takes $O(1)$ average time. Therefore, the total execution time scales linearly with the size of the input array $N$.


* **Space Complexity:** $O(N)$
* We allocate extra memory for the `HashSet` to store the unique numbers. In the worst-case scenario (where the duplicate number is at the very end of the array), the set will store $N - 1$ unique integers before finding the duplicate, resulting in a linear auxiliary space requirement.
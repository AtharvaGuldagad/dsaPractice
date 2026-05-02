# Longest Consecutive Sequence

## Intuition

### The Optimal HashMap Approach vs. Sorting
The strictly optimal way to solve this problem is using a `HashSet` to achieve an $O(N)$ time complexity by checking if each number is the start of a sequence. However, a highly intuitive and practical alternative—especially if we don't have strict $O(N)$ constraints—is to sort the array first. 

### The Sorting Approach
By sorting the array, all duplicate numbers will be adjacent, and consecutive numbers will appear right next to each other in increasing order. 

Once the array is sorted, we can iterate through it while maintaining a "streak" counter. We track the `curr` (the expected next number in our sequence) and compare it against the array elements:
* **If we see duplicates:** We simply skip over them to avoid breaking or falsely inflating our streak.
* **If the sequence breaks:** We reset our streak and update our `curr` expected number to the new element we just found.
* **If we find the expected consecutive number:** We increment our streak and check if it's the highest maximum streak we've seen so far.

---

## Algorithm Pseudocode

```text
IF array is empty:
    RETURN 0

Sort the array in ascending order

Initialize max_streak = 0
Initialize current_expected = array[0]
Initialize current_streak = 0
Initialize index i = 0

WHILE i < length of array:
    // If the sequence is broken, reset the tracking variables
    IF current_expected != array[i]:
        current_expected = array[i]
        current_streak = 0
    
    // Skip past any duplicates of the current expected number
    WHILE i < length of array AND array[i] == current_expected:
        INCREMENT i
    
    // Valid part of the sequence found
    INCREMENT current_streak
    INCREMENT current_expected
    
    // Keep track of the longest streak seen so far
    max_streak = MAX(max_streak, current_streak)

RETURN max_streak
```

---

## Complexity Analysis

* **Time Complexity:** $O(N \log N)$
    * The dominant operation in this solution is sorting the array, which takes $O(N \log N)$ time. The subsequent `while` loop iterates through the array, skipping duplicates. Every element is processed a constant number of times, resulting in an $O(N)$ traversal. Overall, the time complexity is bottlenecked by the sorting step.
* **Space Complexity:** $O(1)$ or $O(\log N)$
    * We are only using a few primitive integer variables to keep track of the streaks, which takes $O(1)$ auxiliary space. However, it is worth noting that many under-the-hood sorting algorithms for primitives require $O(\log N)$ space for the call stack.
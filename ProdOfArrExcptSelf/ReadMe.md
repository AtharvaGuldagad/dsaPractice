# Product of Array Except Self #
---

This was a stupid and a question that deserves a hard difficulty, cuz no way in hell someone can intuitively think of this algorithm without having seen this problem beforehand

---
### Thought Process ###

    what does the output want?
     |- an array where each element is the product of all other elements
     |- to achieve O(n) time complexity strictly without using the division operator

    Solution
    |- create a result array (op) of the same length and fill it with 1s
    |- set up two pointers: 'i' moving forward (start to end) and 'j' moving backward (end to start)
    |- initialize 'pre' and 'post' product trackers to 1
    |- loop through the array simultaneously from both sides:
     \- for the forward pass: multiply op[i] by the current 'pre' product, then update 'pre' by multiplying it with nums[i]
     /- for the backward pass: multiply op[j] by the current 'post' product, then update 'post' by multiplying it with nums[j]
    |- return the populated op array

    Failed but possible approach:
        we could multiply every single number in the array to get a total product
        and then loop through again, dividing the total product by the current number
        the main challenge to encounter here is that the problem strictly forbids using the division operator!
        additionally, handling arrays with zeros (especially multiple zeros) requires messy edge-case logic with this approach.
        another failed approach is a brute-force nested loop to calculate the product for every index independently, but that results in O(n^2) time and hits a Time Limit Exceeded error.

---

### Optimized ###

> Time Comp O(n)

> Space Comp O(1) 
*(Note: O(1) extra space because the problem description usually states that the output array does not count towards space complexity)*
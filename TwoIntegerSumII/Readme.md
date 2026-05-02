***

# LeetCode 167: Two Sum II - Input Array Is Sorted

##  Intuition

### The Brute Force Approach
The naive way to solve this problem is to use a nested loop to check every possible pair of numbers to see if they add up to the target. However, this approach yields a time complexity of $O(N^2)$. More importantly, it completely ignores the most crucial hint provided in the problem description: **the array is already sorted**. 

### The Optimized Two-Pointer Approach
Because the array is sorted in non-decreasing order, we can strategically search for the target sum using two pointers—one starting at the smallest value (the beginning) and one at the largest value (the end).

By calculating the sum of the elements at these two pointers, we can make guaranteed decisions:
* **If the sum is too large:** The only way to decrease the sum is to move the right pointer to the left (pointing to a smaller number).
* **If the sum is too small:** The only way to increase the sum is to move the left pointer to the right (pointing to a larger number).
* **If the sum equals the target:** We have found our solution.

This eliminates the need to check every combination, narrowing the search space in a single pass.

---

##  Algorithm Pseudocode

```text
Initialize left_pointer at index 0
Initialize right_pointer at the last index (array length - 1)

WHILE left_pointer < right_pointer:
    Calculate current_sum = array[left_pointer] + array[right_pointer]
    
    IF current_sum == target:
        // Problem requires 1-indexed array, so add 1 to both indices
        RETURN [left_pointer + 1, right_pointer + 1]
        
    ELSE IF current_sum > target:
        // Sum is too big, decrease it by shifting the right pointer left
        DECREMENT right_pointer
        
    ELSE IF current_sum < target:
        // Sum is too small, increase it by shifting the left pointer right
        INCREMENT left_pointer

// Default return if no solution is found (though problem guarantees exactly one solution)
RETURN [1, 2] 
```
---

##  Complexity Analysis

* **Time Complexity:** $O(N)$
    * In the worst-case scenario, the left and right pointers will meet in the middle. We traverse the array exactly once, meaning the time complexity scales linearly with the size of the array.
* **Space Complexity:** $O(1)$
    * We are only using two integer variables (`i` and `j`) for our pointers, regardless of the size of the input array. No additional data structures are created.
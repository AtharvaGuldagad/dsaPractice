***

# LeetCode 15: 3Sum

## Intuition

### The Brute Force Approach
The most obvious way to solve this is to use three nested loops to check every single possible triplet in the array to see if they sum to zero. However, this results in a time complexity of $O(N^3)$, which will easily trigger a "Time Limit Exceeded" error on LeetCode for larger arrays. Furthermore, managing duplicate triplets with a brute-force approach requires a heavy hash set implementation.

### The Optimized Two-Pointer Approach
We can reduce this problem to a slightly modified version of "Two Sum II" by adding one critical preliminary step: **sorting the array**. 

Once the array is sorted, we can iterate through it, locking in one number at a time (let's call it `nums[i]`). Our goal then becomes finding two other numbers in the remaining portion of the array that sum up to `-nums[i]`. 

Because the rest of the array is sorted, we can use the efficient **Two-Pointer technique**:
* Set a left pointer (`j`) just after our locked number.
* Set a right pointer (`k`) at the end of the array.
* Calculate the sum of all three. If it's too small, move the left pointer up. If it's too large, move the right pointer down.
* **The Duplicate Catch:** Because the array is sorted, duplicate numbers will be adjacent. We can easily prevent duplicate triplets by checking if our current pointer is looking at the same number it just looked at, and simply skipping it if so.

---

##  Algorithm Pseudocode

```text
Sort the input array in ascending order

FOR i = 0 to length - 2:
    // Skip duplicate values for our first number
    IF i > 0 AND array[i] == array[i - 1]:
        CONTINUE

    Initialize left_pointer (j) = i + 1
    Initialize right_pointer (k) = array length - 1

    WHILE left_pointer < right_pointer:
        Calculate sum = array[i] + array[left_pointer] + array[right_pointer]
        
        IF sum == 0:
            ADD [array[i], array[left_pointer], array[right_pointer]] to results
            
            // Move both pointers inward
            INCREMENT left_pointer
            DECREMENT right_pointer
            
            // Skip duplicate values for the second and third numbers
            WHILE left_pointer < right_pointer AND array[left_pointer] == array[left_pointer - 1]:
                INCREMENT left_pointer
            WHILE left_pointer < right_pointer AND array[right_pointer] == array[right_pointer + 1]:
                DECREMENT right_pointer
                
        ELSE IF sum < 0:
            // Need a larger sum, move left pointer right
            INCREMENT left_pointer
            
        ELSE:
            // Need a smaller sum, move right pointer left
            DECREMENT right_pointer

RETURN results
```

---

---

##  Complexity Analysis

* **Time Complexity:** $O(N^2)$
    * Sorting the array takes $O(N \log N)$ time.
    * The outer `for` loop runs $O(N)$ times. Inside it, the `while` loop processes the remaining elements using two pointers, which takes $O(N)$ time per iteration. This results in $O(N^2)$ operations. 
    * Overall Time Complexity: $O(N \log N + N^2)$, which asymptotically simplifies to $O(N^2)$.
* **Space Complexity:** $O(1)$ to $O(N)$
    * The space complexity depends heavily on the sorting algorithm used by the language (Java's `Arrays.sort()` uses a variation of Quicksort/Timsort which takes $O(\log N)$ to $O(N)$ space). 
    * Excluding the space required to store the output `sol` list, we only use a few integer variables for pointers, which takes $O(1)$ auxiliary space.
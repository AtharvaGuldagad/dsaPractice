# Search a 2D Matrix

## Intuition

### The Two-Pass Binary Search Approach
Given that each row is sorted and the first integer of each row is guaranteed to be greater than the last integer of the previous row, we can optimize our search to run in logarithmic time. Instead of traversing every element or searching row-by-row linearly, we can perform two distinct binary searches.

First, we determine which row might potentially contain our target. We accomplish this by comparing the target against the minimum (first) and maximum (last) values of the middle row in our search space. 
* If the target is smaller than the row's first element, the target must be in the rows above. 
* If the target is larger than the row's last element, it must be in the rows below. 
* If the target falls between these two values, we have successfully isolated the correct row.

Once the target row is identified, we execute a standard one-dimensional binary search strictly within that specific row to check if the target element exists.

---

## Algorithm Pseudocode

```text
Initialize top_row = 0 
Initialize bottom_row = total_rows - 1
Initialize last_col_index = total_columns - 1
Initialize target_row = 0

// Phase 1: Binary search vertically to find the correct row
WHILE top_row <= bottom_row:
    Calculate mid_row = (top_row + bottom_row) / 2
    
    IF target < matrix[mid_row][0]:
        // Target is too small for this row, search the upper half
        bottom_row = mid_row - 1
    ELSE IF target > matrix[mid_row][last_col_index]:
        // Target is too large for this row, search the lower half
        top_row = mid_row + 1
    ELSE:
        // Target falls within the bounds of this row
        target_row = mid_row
        BREAK

// Phase 2: Binary search horizontally within the isolated row
Initialize left_pointer = 0 
Initialize right_pointer = last_col_index

WHILE left_pointer <= right_pointer:
    Calculate mid_col = (left_pointer + right_pointer) / 2
    
    IF matrix[target_row][mid_col] == target:
        RETURN true
    ELSE IF matrix[target_row][mid_col] < target:
        left_pointer = mid_col + 1
    ELSE:
        right_pointer = mid_col - 1

// Target was not found in the identified row
RETURN false
```

---

## Complexity Analysis

* **Time Complexity:** $O(\log M + \log N)$
    * We perform an initial binary search on the vertical axis to find the row, which takes $O(\log M)$ time where $M$ is the total number of rows. Subsequently, we perform a second binary search horizontally on the identified row, taking $O(\log N)$ time where $N$ is the number of columns. This equates to an overall time complexity of $O(\log(M \times N))$.
* **Space Complexity:** $O(1)$
    * We are only using a constant number of primitive integer variables to store index pointers and boundaries. No additional data structures are created, making the auxiliary space requirement constant regardless of the input matrix dimensions.
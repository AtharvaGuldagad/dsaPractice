# Binary Search

## Intuition
This solution employs the classic **Binary Search** algorithm, utilizing a **Divide and Conquer** strategy to efficiently find a target value in a sorted array.

* Instead of scanning the array from start to finish, we maintain a search window defined by two pointers: `min` (start) and `max` (end).
* We calculate the `mid` point of this window. If the middle element is our target, we are done.
* If the target is greater than the middle element, we know it must lie in the right half of the window, so we move our `min` pointer up.
* If the target is smaller, it must lie in the left half, so we bring our `max` pointer down.
* This process effectively halves the search space in every single step, repeating until the target is found or the boundaries converge (meaning the target doesn't exist in the array).

## Complexity

* **Time Complexity:** `O(log n)`
  Where `n` is the number of elements in the array. Because we divide the search space by 2 during each iteration of the `while` loop, the number of steps required grows logarithmically with the size of the array. This makes it significantly faster than a linear search for large datasets.
  
* **Space Complexity:** `O(1)`
  The algorithm only allocates a few primitive integer variables (`min`, `max`, `mid`) to keep track of the indices. This requires a constant amount of extra memory, entirely independent of how large the input array is.

  [Link-To-Problem](https://neetcode.io/problems/binary-search/question?list=neetcode150)
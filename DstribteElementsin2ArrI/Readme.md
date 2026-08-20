# Distribute Elements Into Two Arrays I

## Intuition

### Simulation via Tail Comparisons

The problem requires distributing array elements sequentially into two arrays, `arr1` and `arr2`, based on the values of their most recently added elements (their "tails"):

1. The first element `nums[0]` goes to `arr1`.
2. The second element `nums[1]` goes to `arr2`.
3. For each subsequent element `nums[i]`:
* If the last element of `arr1` is strictly greater than the last element of `arr2` (`last1 > last2`), append `nums[i]` to `arr1`.
* Otherwise, append `nums[i]` to `arr2`.



After all elements are distributed, concatenating `arr1` followed by `arr2` produces the final result.

---

## Step-by-Step Guide

1. Initialize two dynamic lists, `arr1` and `arr2`.
2. Add the initial elements: `arr1.add(nums[0])` and `arr2.add(nums[1])`.
3. Loop from index $i = 2$ to $n - 1$:
* Retrieve the last element of each array:
* `last1 = arr1.get(arr1.size() - 1)`
* `last2 = arr2.get(arr2.size() - 1)`


* If `last1 > last2`, add `nums[i]` to `arr1`.
* Otherwise, add `nums[i]` to `arr2`.


4. Allocate a result array `res` of size $n$.
5. Copy all elements of `arr1` into `res`, followed by all elements of `arr2`.
6. Return `res`.

---

## Complexity Analysis

* **Time Complexity:** $O(n)$
* Distributing elements takes a single pass over `nums` of length $n$ with $O(1)$ operations per element. Copying elements to `res` takes another linear pass, resulting in $O(n)$ total time.


* **Space Complexity:** $O(n)$
* The two lists `arr1` and `arr2` together store all $n$ elements, requiring $O(n)$ auxiliary space.
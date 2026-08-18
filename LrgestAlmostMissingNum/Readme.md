# Find the Largest Almost Missing Integer

## Intuition

### Contiguous Subarray Coverage Analysis

The problem asks for the largest integer that appears in **exactly $k$ contiguous subarrays** of size $k$.

Instead of checking every window of size $k$ across the array, analyze which elements can mathematically appear in exactly $k$ subarrays based on their positions and the value of $k$:

1. **When $k == n$:**
* There is only $1$ subarray of size $k$ (the entire array). Every unique element appears in that single subarray. Hence, the answer is simply the maximum value that appears in the array with frequency $1$. (Note: elements must be unique in their windows).


2. **When $k == 1$:**
* Each single element forms its own subarray. An element appears in exactly $1$ subarray if and only if its global frequency in `nums` is $1$. The answer is the largest globally unique element.


3. **When $1 < k < n$:**
* **Boundary Elements (`i == 0` or `i == n - 1`):** The first and last elements belong to exactly $1$ window of size $k$ (the first window and the last window, respectively). If they appear only once in the entire array (`f[nums[i]] == 1`), they appear in exactly $1$ window (which for endpoints happens to be the only window they can be in).
* **Internal Elements ($0 < i < n - 1$):** Any element strictly inside the array appears in more than $1$ window (in fact, it is covered by $\min(i + 1, n - k + 1, k, \dots)$ windows). Thus, it can never appear in *exactly* $k$ windows unless $k == n$ or $k == 1$.



---

## Step-by-Step Guide

1. Create a frequency array `f` (sized 51 for values in range $[0, 50]$) to count the total occurrences of each number in `nums`.
2. Initialize `res = -1` and get the array size `n = nums.length`.
3. Iterate through each index `i` from $0$ to $n - 1$:
* **Condition Check:** An element `nums[i]` is a valid candidate if:
* $k == n$ (the entire array is one window, provided uniqueness rules are observed), **OR**
* It is globally unique (`f[nums[i]] == 1`) **AND** either $k == 1$, $i == 0$ (first element), or $i == n - 1$ (last element).


* If the condition is met, update `res = Math.max(res, nums[i])`.


4. Return `res` (or `-1` if no such element exists).

---

## Complexity Analysis

* **Time Complexity:** $O(n)$
* We iterate through `nums` twice: once to populate the frequency array and once to check the candidate conditions. Each iteration takes $O(1)$ constant time operations, resulting in linear runtime.


* **Space Complexity:** $O(1)$
* The frequency array has a fixed size of 51, and only a few primitive variables are used, keeping auxiliary memory strictly constant.
# Top K Frequent Elements

## Intuition
This solution uses a highly efficient **Bucket Sort** approach to find the most frequent elements, bypassing the need for traditional $O(n \log n)$ sorting or heaps. 

1. **Count Frequencies:** First, we use a Hash Map to count the occurrences of each number in the array.
2. **Group by Frequency (Buckets):** We create an array of lists called `buckets`. The clever trick here is using the **index** of the array to represent the **frequency** of the numbers. Since a number can appear at most `n` times (the length of the array), the `buckets` array is sized `n + 1`. We place each number into the bucket corresponding to its frequency count.
3. **Gather Top K:** To find the most frequent elements, we simply iterate through the `buckets` array backwards (starting from the highest possible frequency) and collect numbers into our result array until we hit exactly `k` elements.

## Complexity

* **Time Complexity:** `O(n)`
  Where `n` is the number of elements in the array. We iterate through the `nums` array to build the frequency map `O(n)`, iterate through the map to populate the buckets `O(n)`, and iterate backward through the buckets array `O(n)`. The total time scales linearly with the input size.
  
* **Space Complexity:** `O(n)`
  The Hash Map stores up to `n` unique elements, and the `buckets` array of lists will also store up to `n` elements combined. The overall extra space required is proportional to the input size.

  [Link-To-Problem](https://neetcode.io/problems/top-k-elements-in-list/question?list=neetcode150)
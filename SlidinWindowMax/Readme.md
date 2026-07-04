# Sliding Window Maximum

## Intuition
    LC Hard, Only got the Brute force right

## Steps:
    Take 2 for loops
    iterate through the array using a sliding window
    with the parameters as i<=n-k of the parent loop
    and j<i+k of the nested loop
    store the max of each iteration in a seperate array

## Time Complexity
    * $O(N*K)$ Time
    * $O(N-K+1) Space
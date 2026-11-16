# Design Twitter

## HATE THIS PROBLEM WHO EVEN ASKS TS

## Intuition

### Merge $K$ Sorted Lists with a Min-Heap

Generating a user's news feed requires retrieving the **10 most recent tweets** across the user and everyone they follow. Because each user's tweets are naturally stored in chronological order as they are posted, finding the global top 10 reduces directly to the **Merge $K$ Sorted Lists** pattern:

1. **Inverted Timestamp Ordering (`count--`):** By decrementing a global monotonic counter (`count--`) on every `postTweet`, newer tweets receive smaller (more negative) timestamps. This allows a standard **Min-Heap** (`Comparator.comparingInt(a -> a[0])`) to always surface the most recent tweet at the root.
2. **Lazy Heap Insertion ($K$-Way Merge):** Rather than pushing every tweet from every followee into the priority queue, we only insert the **single most recent tweet** (`index = tweets.size() - 1`) for each followee. Whenever a tweet is popped into the result list, we push the immediately preceding tweet (`index - 1`) from that same followee's list, keeping the heap size bounded by $K$ (the number of followees) rather than total tweets.
3. **Self-Follow Invariant:** Ensuring `userId` is present in their own `followMap` set inside `getNewsFeed` guarantees the user's own tweets are always included, even if `unfollow(userId, userId)` was previously called.

---

## Step-by-Step Guide

1. **Data Structures (`Twitter()`):**
* `count`: Monotonic timestamp counter initialized to `0`.
* `tweetMap`: `Map<Integer, List<int[]>>` mapping `userId` to an append-only list of `{timestamp, tweetId}` pairs.
* `followMap`: `Map<Integer, Set<Integer>>` mapping `followerId` to a `HashSet` of `followeeId`s.


2. **Post Tweet (`postTweet`):**
* Append `new int[]{count--, tweetId}` to `tweetMap.get(userId)` in $O(1)$ amortized time.


3. **Follow / Unfollow (`follow`, `unfollow`):**
* `follow`: Add `followeeId` to `followMap.get(followerId)` in $O(1)$ average time.
* `unfollow`: Remove `followeeId` from `followMap.get(followerId)` if present in $O(1)$ average time. (Optionally guard `if (followerId != followeeId)` to prevent self-unfollowing explicitly).


4. **Retrieve News Feed (`getNewsFeed`):**
* Ensure `userId` follows themselves in `followMap`.
* Initialize `minHeap` ordered by timestamp (`a[0]`).
* For each `followeeId` in `followMap.get(userId)`:
* If `followeeId` has posted tweets, fetch their latest tweet at `index = tweets.size() - 1` and offer `{timestamp, tweetId, followeeId, index}` to `minHeap`.


* While `!minHeap.isEmpty()` and `res.size() < 10`:
* Poll the most recent tweet `curr` and add `curr[1]` (`tweetId`) to `res`.
* If `curr[3] > 0`, fetch the next older tweet at `index - 1` from `curr[2]` (`followeeId`) and offer it to `minHeap`.


* Return `res`.



---

## Complexity Analysis

* **Time Complexity:**
* `postTweet`, `follow`, `unfollow`: **$O(1)$** average time per operation.
* `getNewsFeed`: **$O(K \log K)$**, where $K$ is the number of users `userId` follows (including themselves). Seeding the heap takes $O(K \log K)$, and extracting up to 10 tweets performs at most 10 poll/offer cycles at $O(\log K)$ each. *(Note: Because we only need the top 10 tweets, if $K > 10$, we could bound the heap to the 10 followees with the most recent tweets, reducing time to $O(K + 10 \log 10) = O(K)$).*


* **Space Complexity:** **$O(U + T + K)$**
* Where $U$ is the total number of users, $T$ is the total number of tweets stored across `tweetMap`, and $K$ is the number of followee entries in the temporary `minHeap` during `getNewsFeed`.
# Time Based Key-Value Store

## Intuition

### The Time Travel Registry

A standard key-value map allows you to overwrite old data: if you assign `key="foo"` to `"bar"`, the previous value is completely lost. To build a time-based store, we need to remember the entire history of a key. We can achieve this by mapping each unique key to its own timeline of timestamps and values.

### The Floor Entry Lookup

When looking up a value at a specific timestamp, the exact timestamp might not exist in our history. The problem states that if the exact timestamp is missing, we should look backward in time and return the value associated with the closest preceding timestamp.

Instead of searching through a random list of timestamps, we can use a `TreeMap` for each key's timeline. A `TreeMap` automatically keeps the timestamps sorted in ascending order under the hood using a self-balancing binary search tree. This allows us to use the `floorEntry` function, which instantly scans the tree and finds the largest timestamp that is less than or equal to our target in logarithmic time.

---

## Step-by-Step Guide

1. Get a master storage filing cabinet (your HashMap).
2. **When storing a new value (`set`):**
* Check if the key already has its own private timeline folder (a TreeMap) inside the cabinet. If it doesn't, create a brand new timeline folder for this key.
* Open that key's timeline folder, slide the timestamp into its mathematically correct chronological spot, and write down the value right next to it.


3. **When retrieving a value (`get`):**
* Look inside the master cabinet for the key's timeline folder. If the folder does not exist at all, immediately give back an empty piece of text `""`.
* If the folder exists, open it up and look at the requested timestamp.
* Check if that exact timestamp exists. If it does not, look for the closest possible timestamp that happened *before* your target time (the floor entry).
* If you look backward and find absolutely nothing (meaning the target timestamp is older than the very first entry in the timeline), give back an empty piece of text `""`.
* Otherwise, grab the value attached to that matching or preceding timestamp and give it back.



---

## Complexity Analysis

* **Time Complexity:** * **`set`:** $O(\log N)$ where $N$ is the total number of timestamps stored under the given key. Inserting into a `TreeMap` requires traversing a balanced tree structure to maintain chronological order.
* **`get`:** $O(\log N)$ to search the key's `TreeMap` using `floorEntry`, which operates via binary search on the tree structure. (The initial `HashMap` lookup for the key itself takes $O(1)$ constant time).


* **Space Complexity:** $O(M \times N)$
* We store every unique key-value-timestamp combination inside our nested map structure. If we have $M$ unique keys and each key has an average of $N$ timestamp updates, our total auxiliary space scales linearly with the total volume of data stored.
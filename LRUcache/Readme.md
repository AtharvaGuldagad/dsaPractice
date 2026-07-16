# LRU Cache

## Intuition

### The Eviction Strategy

An LRU (Least Recently Used) Cache is a fixed-size storage system that prioritizes keeping the items you looked at most recently. When the cache fills up to its maximum capacity and you want to insert a new item, it must make room by evicting the item that hasn't been touched for the longest period of time.

### The Built-in Order Preservation

Under the hood, an LRU cache is typically built from scratch using a combination of a standard `HashMap` (for $O(1)$ fast lookups) and a custom Doubly Linked List (to easily maintain chronological usage order by moving touched nodes to the tail).

However, Java provides a highly elegant shortcut called `LinkedHashMap`. A standard map doesn't care about insertion or access order, but a `LinkedHashMap` maintains a doubly linked list running through all of its entries. By passing `true` for the `accessOrder` argument in its constructor, Java automatically updates the order every time a key is accessed via `get` or modified via `put`—instantly sliding the most recently used item to the end of the line.

Additionally, overriding `removeEldestEntry` allows the map to automatically self-police its size, cleanly dropping the oldest item from the front of the line whenever the capacity boundary is breached.

---

## Step-by-Step Guide

1. Define a fixed limit for the maximum number of items allowed in your storage structure (`capacity`).
2. **The Constructor Setup:** Initialize a new `LinkedHashMap`.
* Pass the target capacity and a standard load factor (`0.75f`).
* Pass `true` for the `accessOrder` setting. This flips the internal logic so that merely reading an item with `get` counts as an activity, automatically pushing it to the back as the "most recently used."


3. Open an inline configuration block to override the map's automatic cleanup rule (`removeEldestEntry`). Tell it to return `true` if the current count of items inside the map strictly exceeds your maximum capacity limit.
4. **Retrieving data (`get`):** Look up the key in your map. If it exists, Java will automatically fetch the value and slide this key-value pair to the end of its internal linked list. If it doesn't exist, return `-1`.
5. **Storing data (`put`):** Insert the key-value pair into the map.
* If the key already existed, its value is updated, and it is moved to the end of the list as the newest entry.
* If it's a completely new key, Java adds it to the end of the list and immediately checks your custom `removeEldestEntry` rule. If the map has grown too large, Java will cleanly chop off the absolute oldest element sitting at the very front of the line.



---

## Complexity Analysis

* **Time Complexity:** * **`get`:** $O(1)$ constant time. Hashing allows immediate data access, and updating the pointers in the internal doubly linked list to reflect the new access order takes constant time.
* **`put`:** $O(1)$ constant time. Inserting or modifying a key takes constant time on average, and any automated eviction triggered by `removeEldestEntry` simply drops the head of the linked list in $O(1)$ time.


* **Space Complexity:** $O(C)$
* The auxiliary memory utilized scales linearly with the maximum capacity limit $C$ specified in the constructor. The structure will hold at most $C + 1$ elements momentarily before an eviction takes place, ensuring the memory footprint remains strictly bounded.
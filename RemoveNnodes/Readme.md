# Remove Nth Node From End of List

## Intuition

### The Two-Pass Offset Method

To remove the $n$-th node from the end of a linked list, we first need to figure out where that node is physically located from the front. Because a singly linked list only moves forward, we cannot simply start at the tail and count backward.

The most straightforward way to solve this is to make two sequential passes:

1. **First Pass:** We walk through the entire list from head to tail simply to count the total number of nodes ($N$). Once we have the total length, finding the target node from the front becomes basic subtraction: the $n$-th node from the end is located at index $N - n$ (using 0-based indexing).
2. **Second Pass:** We walk through the list a second time, stopping exactly one node *before* the target node. To remove the target, we simply tell this preceding node to skip its immediate neighbor and point directly to the node after it.

### The Edge Cases

If the calculation tells us that the node to remove is the very first node in the list (the head), there is no preceding node to stop at. We handle this edge case directly by immediately returning `head.next`, effectively shifting the start of the list forward by one position.

---

## Step-by-Step Guide

1. Hire a scout and place them at the very start of the list.
2. Set up a counter starting at zero.
3. Tell the scout to walk all the way to the end of the chain, clicking your counter once for every node they step on. Now you know the total length of the list.
4. Calculate the target spot from the front by subtracting the given number $n$ from your total count.
5. Check if your calculated spot is zero. If it is, it means you need to chop off the very first node of the list. Stop immediately and give back the second node as the new start of the list.
6. If the spot is not zero, send your worker back to the very first node of the list.
7. Tell the worker to count their way forward through the chain, stopping exactly one step before the target spot.
8. Once the worker stops, tell them to cut the forward link to the next node, and rewire it to point directly to the node after next (skipping the target node entirely).
9. Give back the original start of the list.

---

## Complexity Analysis

* **Time Complexity:** $O(N)$
* We traverse the linked list of length $N$ at most two times. The first pass counts all $N$ elements, and the second pass walks at most $N - 1$ steps to find the deletion point. Since these passes happen sequentially and not nested within each other, the total time scales linearly with the number of nodes.


* **Space Complexity:** $O(1)$
* We only allocate a few primitive integer variables to track the lengths and loop counters, along with a pointer variable to traverse the nodes. No additional data structures are created, keeping the auxiliary space usage strictly constant regardless of the linked list size.
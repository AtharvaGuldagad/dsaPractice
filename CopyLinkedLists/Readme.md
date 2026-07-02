# Copy List with Random Pointer

## Intuition

### The Two-Pass Mapping Strategy

Deep copying a standard linked list is straightforward: you walk through the list, duplicate each node, and link them together linearly. However, this problem introduces a `random` pointer that can point to any node in the list or even backward. If you try to assign the random pointer while building the copy list on the fly, you will run into a wall because the node it points to might not even be created yet.

### The Blueprint Dictionary

To solve this, we can decouple the node creation from the pointer stitching by using a `HashMap`.

1. **First Pass:** We treat the first pass as building a blueprint dictionary. We look at every original node, create a brand new duplicate node with the exact same value, and log their relationship in our map (`Key = Original Node, Value = Clone Node`).
2. **Second Pass:** We walk through the original list a second time. Now that every single node has a clone registered in our map, we can effortlessly connect the dots. For any original node, we look up its clone and accurately set its `next` and `random` pointers by fetching the clones of the original target nodes from our dictionary.

---

## Step-by-Step Guide

1. Get a master blueprint logbook (your HashMap). Write down right at the front that "nothing (`null`) maps to nothing (`null`)" to handle empty pointers easily.
2. Set a marker at the very beginning of the original chain of nodes.
3. Start your first walk through the list:
* Look at the current original node and read its value.
* Build a brand new clone node using that value.
* Open your logbook and write down the exact pairing: *"This specific original node belongs to this specific clone node."*
* Step forward to the next original node.


4. Repeat step 3 until you reach the end of the original list. Now, every single node has a twin registered in the logbook.
5. Reset your marker back to the very beginning of the original chain.
6. Start your second walk through the list to wire the connections:
* Look up the clone twin of your current original node in the logbook.
* Look at where the original node's `next` pointer goes, find that target's clone twin in the logbook, and connect your clone's `next` pointer to it.
* Look at where the original node's `random` pointer goes, find that target's clone twin in the logbook, and connect your clone's `random` pointer to it.
* Step forward to the next original node.


7. Repeat step 6 until you have wired every single clone node together.
8. Look up the clone twin of the original start node in your logbook and give it back. Your deep copy is completely finished.

---

## Complexity Analysis

* **Time Complexity:** $O(N)$
* We make exactly two sequential passes over the linked list of length $N$. In the first pass, we create $N$ nodes and insert them into the `HashMap`. In the second pass, we perform constant-time lookups ($O(1)$ on average) to wire up the pointers. This results in a strictly linear time complexity.


* **Space Complexity:** $O(N)$
* We allocate extra memory for the `HashMap` to maintain the mapping between the original nodes and their newly created clones. Since we store exactly $N$ node references as keys and another $N$ references as values, the auxiliary space scales linearly with the number of nodes in the list.
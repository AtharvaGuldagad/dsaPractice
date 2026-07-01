# Reorder List

## Intuition

### The Interleaving Pattern

Reordering the list requires us to interleave nodes from the front and the back of the list alternately ($L_0 \rightarrow L_n \rightarrow L_1 \rightarrow L_{n-1} \rightarrow \dots$). In a singly linked list, walking backwards from the end is impossible because the pointers only move forward.

### The Dynamic Array Trick

The optimal approach usually involves finding the middle of the list, reversing the second half, and stitching them together using pointers. However, a highly intuitive alternative is to copy all the node references into a dynamic list (`ArrayList`).

By storing the node addresses sequentially in an array, we instantly gain random access ($O(1)$ lookup by index). This allows us to use a two-pointer approach—one at the beginning (`i`) and one at the end (`j`)—to easily zip the nodes together from both ends. We simply point the front node to the back node, move inward, point the back node to the next front node, and repeat until the pointers meet.

---

## Step-by-Step Guide

1. Check if the start of the list is empty. If it is, there is nothing to reorder. Stop immediately.
2. Get a large empty tray (an ArrayList) to hold all the individual pieces of the chain.
3. Walk through the linked list from front to back, pick up each node, and place it into the tray in the exact order you found it.
4. Set up two markers: one pointing at the very first item in the tray (index `i = 0`) and one pointing at the very last item in the tray (index `j = size - 1`).
5. Start a loop to reconnect the pieces:
* Take the item at the front marker and tell it to point forward to the item at the back marker.
* Slide your front marker one step inward to the right.
* Check if your markers have crossed or met. If they have, break out of the loop.
* Take the item at the back marker and tell it to point forward to the item at the new front marker.
* Slide your back marker one step inward to the left.


6. Repeat step 5 until the front and back markers completely close in on each other.
7. Once the markers meet, you are standing at the absolute final node of your new rearranged list. Break its forward pointer by setting it to nothing (`null`) so the chain terminates properly and doesn't loop infinitely.

---

## Complexity Analysis

* **Time Complexity:** $O(N)$
* We traverse the entire linked list once to load all $N$ nodes into the array list, which takes $O(N)$ time. Then, our two pointers loop inward toward the middle, rewriting exactly $N$ pointer connections. Because every node is processed a constant number of times, the overall time complexity scales linearly with the size of the list.


* **Space Complexity:** $O(N)$
* We allocate extra memory for the `ArrayList` to store references to every single node in the linked list. Because the size of this array scales dynamically and directly with the number of elements $N$ in the input list, the auxiliary space requirement is linear.
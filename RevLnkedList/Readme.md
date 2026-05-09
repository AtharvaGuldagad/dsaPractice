# Reverse Linked List

## Intuition

### The Pointer Reversal Concept

A singly linked list is essentially a chain of nodes where each node only knows about the node immediately following it. To reverse the entire list, we do not need to create new nodes or move the data around. We simply need to change the direction of every single pointer. Instead of pointing forward to the next node, each node must point backward to the previous node.

### The Three-Pointer Strategy

The main challenge when reversing pointers is that the moment you tell a node to point backward, you sever the link to the rest of the list. Once the link is broken, you have no way to reach the remaining nodes. To solve this, we must maintain three separate pointers as we walk through the list:

* **Previous:** To know where the current node should point to.
* **Current:** To know which node we are actively modifying.
* **Next:** To temporarily memorize the rest of the list before we sever the forward connection.

---

## Step-by-Step Guide

1. Set up a marker to remember the item you just finished looking at. Since you are just starting, there is no previous item, so set this marker to nothing (null).
2. Set up another marker to point to the very first item in the list. This is your active item.
3. Check if your active item actually exists. If it does not, you are done.
4. Before changing anything, look at the very next item in the chain and remember its location. This is crucial so you do not lose the rest of the list.
5. Take your active item and sever its forward connection. Tell it to point backward to your previous marker instead.
6. Now that the active item is pointing the correct way, step forward. Update your "previous" marker to be the item you just modified.
7. Update your "active" marker to be the next item you memorized in step 4.
8. Repeat steps 3 through 7 until you run out of items.
9. When you run out of items, your "previous" marker will be pointing at the last item you processed. This item is now the brand new start of the list. Give back this marker.

---

## Complexity Analysis

* **Time Complexity:** $O(N)$
* We traverse the linked list exactly once from the head to the tail. The time it takes scales linearly with $N$, where $N$ is the total number of nodes in the list.


* **Space Complexity:** $O(1)$
* We only create three node pointers (`prev`, `curr`, and the temporary `nextn`) to keep track of our position. Since we are just rearranging existing connections and not creating any new data structures, the memory used is constant regardless of the size of the linked list.
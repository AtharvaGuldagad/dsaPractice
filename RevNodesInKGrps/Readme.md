# Reverse Nodes in k-Group

## Intuition

### The Segmented Sub-problem

Reversing an entire linked list is a classic problem where you flip every single pointer backward. Reversing nodes in $k$-groups takes this exact concept but forces you to apply it locally to separate segments of length $k$.

If a remaining segment at the end of the list has fewer than $k$ nodes, the problem states it must be left completely untouched. This means before we touch any pointers in a group, we must first "scout ahead" to make sure a full group of $k$ nodes actually exists.

### The Boundary Stitching Challenge

The trickiest part of this problem isn't reversing the $k$ nodes themselves—it's seamlessly stitching the newly reversed segment back into the main chain.

When a segment is reversed, its original first node becomes its new last node, and its original last node becomes its new first node. To prevent breaking the chain, we must remember:

1. The node sitting right *before* the group (`grpPrev`) needs to be rewired to point to the new head of the group.
2. The original head of the group (which is now at the tail) needs to be rewired to point to the node sitting right *after* the group (`grpNext`).

---

## Step-by-Step Guide

1. Create a fake placeholder node (`dum`) and point it to the start of your list. This serves as an unshakeable anchor for the head.
2. Place a marker called `grpPrev` at this fake node. This tracker will always stand exactly one step behind the current group we want to reverse.
3. Start a loop that runs continuously:
* Send out a scout from `grpPrev` to count out exactly $k$ steps forward. Find the $k$-th node.
* If the scout runs into a dead end (`null`) before reaching $k$, it means there aren't enough nodes left to form a full group. Stop everything and break out of the loop.


4. If a full group is confirmed, note down the boundaries:
* Save the node sitting right after the group (`grpNext = kth.next`).


5. Perform a localized reverse loop on the $k$ nodes. Flip their pointers backward one by one. (A clever trick here is initializing your `prev` pointer to `grpNext` instead of `null`, which automatically connects the tail of your newly reversed group to the remainder of the list).
6. Fix the connection at the front: Tell `grpPrev` to point directly to the $k$-th node (which has now become the new front of the reversed group).
7. Prepare for the next round: Move your `grpPrev` marker forward. The node that *used* to be the front of the group is now sitting at the back, meaning it is perfectly positioned to serve as the `grpPrev` for the next group.
8. Repeat the entire process until you break out. Return `dum.next`.

---

## Complexity Analysis

* **Time Complexity:** $O(N)$
* We traverse each node of the linked list a constant number of times. First, the `getKth` helper function scans $k$ nodes ahead to validate the group. Then, the inner loop processes those same $k$ nodes to reverse their pointers. Since every segment of length $k$ is visited exactly twice, the total runtime scales strictly linearly with the number of nodes $N$.


* **Space Complexity:** $O(1)$
* The algorithm mutates the pointers of the existing linked list nodes directly in place. We only allocate a fixed number of pointer variables (`dum`, `grpPrev`, `kth`, `curr`, `prev`, `tmp`) to manage the boundaries. Because no dynamic memory or recursive call stacks are utilized, the auxiliary space footprint is perfectly constant.
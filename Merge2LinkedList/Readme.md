# Merge Two Sorted Lists

## Intuition

### The Zipper Method

When you have two sequences that are already sorted, combining them is like zipping up a jacket. You do not need to sort them from scratch; you just need to look at the top item of each sequence, pick the smaller of the two, and lock it into place. Because both lists are already in increasing order, consistently picking the smaller of the two available options guarantees the final combined list will also be perfectly sorted.

### The Dummy Node Trick

When building a brand new linked list (or merging existing ones), handling the very first item often requires annoying, special-case logic because there is no previous item to attach it to. To bypass this headache, we create a fake, placeholder "dummy" node. This gives us a solid starting point to attach our sorted items to. When we are entirely finished, we simply ignore the dummy node and hand back everything that was attached after it.

---

## Step-by-Step Guide

1. Create a fake, temporary starter item. This will serve as the anchor for your new combined chain.
2. Hire a worker and place them at this starter item. This worker's job is to build the connections for the new chain.
3. Check if both of your input lists still have items remaining. If they do, look at the very front item of both lists.
4. Compare the two items. Find out which one is smaller.
5. Tell your worker to point to the smaller item, linking it to your new chain.
6. Move the worker forward so they are now standing on the newly attached item.
7. Move the list that had the smaller item forward, discarding the item you just used and bringing the next one to the front.
8. Repeat steps 3 through 7 until one of the lists is completely empty.
9. Because the lists are already sorted, whichever list still has items left is perfectly ready to go. Tell your worker to attach the entire remaining chunk of that list to the end of your new chain.
10. Your fake starter item is now pulling the entire merged list. Give back the actual start of the list, which is the item sitting right behind your fake starter.

---

## Complexity Analysis

* **Time Complexity:** $O(N + M)$

* **Space Complexity:** $O(1)$

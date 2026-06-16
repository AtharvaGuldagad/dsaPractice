# Linked List Cycle

## Intuition

### The Infinite Loop Problem

If a linked list contains a cycle, trying to walk to the end of it will result in an infinite loop because there is no final destination. A simple way to detect this is to write down the name of every single node you visit in a list or set. If you ever arrive at a node that is already on your list, you know you are walking in circles. However, keeping a massive record of every visited node requires a lot of extra memory.

### The Race Track Strategy

To solve this without using any extra memory, we can use the "Tortoise and Hare" concept. Imagine two runners on a path. One runner is fast (taking two steps at a time) and the other is slow (taking one step at a time).

* If the path is a straight line, the fast runner will simply hit the dead end and finish the race.
* If the path contains a circular track, the fast runner will never find an end. Instead, they will keep running in circles and inevitably lap the slow runner from behind. If the two runners ever land on the exact same spot at the exact same time, we have mathematically proven that the path contains a loop.

---

## Step-by-Step Guide

1. Place two markers at the very beginning of the chain. Call one the "slow" runner and the other the "fast" runner.
2. Check the path in front of the fast runner. If the fast runner is currently standing at a dead end, or if the very next step is a dead end, stop everything. A straight line has been found. Give back "false" (no cycle).
3. Tell the fast runner to jump forward exactly two spaces.
4. Tell the slow runner to step forward exactly one space.
5. Look at where the two runners are now standing. Ask: "Are both runners standing on the exact same item?"
6. **If YES:** The fast runner has run circles around the chain and crashed into the back of the slow runner. A loop definitely exists. Stop and give back "true" (cycle exists).
7. **If NO:** The race continues. Go back to step 2 and repeat the process.
8. If the fast runner ever reaches a dead end, the chain is broken, meaning there is no loop. Give back "false".

---

## Complexity Analysis

* **Time Complexity:** $O(N)$
* If there is no cycle, the fast pointer reaches the end in roughly $N/2$ steps. If there is a cycle, the fast pointer will catch the slow pointer in at most $N$ steps after the slow pointer enters the loop. In either scenario, the time it takes scales linearly with the number of nodes.


* **Space Complexity:** $O(1)$
* We only require two pointer variables to keep track of our fast and slow runners. No matter how massive the linked list is, we do not allocate any additional arrays, sets, or memory, keeping the auxiliary space strictly constant.
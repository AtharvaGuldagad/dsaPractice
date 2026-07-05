# Merge k Sorted Lists

## Intuition

### The Flatten-and-Sort Strategy

The code provided solves the problem of merging $k$ sorted lists by treating it as a global sorting problem. Instead of trying to maintain the individual lists, it walks through every single list, extracts all the numbers, and flattens them into one large dynamic array (`ArrayList`). Once all the numbers are gathered in one place, a standard sorting algorithm (`Collections.sort`) is run over the collection to rearrange them into ascending order. Finally, a brand new linked list is constructed from scratch using these sorted values.

### The Optimal Alternative

While this approach is straightforward and works perfectly, it doesn't take advantage of the fact that each of the $k$ input lists is **already sorted**. The strictly optimal ways to solve this problem include:

1. **Using a Min-Heap (Priority Queue):** Push the head of each list into a heap. The heap constantly hands you the absolute smallest node available across all lists in $O(\log k)$ time.
2. **Divide and Conquer:** Use your existing `mergeTwoLists` logic to merge pairs of lists iteratively (like Merge Sort), which reduces the number of operations dramatically.

---

## Step-by-Step Guide

1. Get a large, empty collection box (your ArrayList) to hold every single number.
2. Look at your array of lists. Pick up the first list and walk down it from head to tail, copying every number you see and throwing it into your collection box.
3. Move to the next list in the array and repeat step 2. Do this until you have completely emptied all numbers from every single linked list into the box.
4. Run a sorting algorithm over your collection box to rearrange all the gathered numbers into a perfect ascending line.
5. Create a fake, temporary starter item (`ListNode(0)`) to anchor your new combined list.
6. Hire a worker and place them at this starter item.
7. Open your sorted collection box. Read the numbers out one by one from smallest to largest.
8. For each number, build a brand new list node, tell your worker to link it to the chain, and move the worker forward onto the new node.
9. Once you have built a node for every number in your box, your fake starter item is pulling the entire completed list. Give back the actual start of the list, which sits right behind your fake starter.

---

## Complexity Analysis

* **Time Complexity:** $O(N \log N)$
* Let $N$ be the total number of nodes across all $k$ linked lists. Collecting all the values takes $O(N)$ time. Sorting an array of size $N$ takes $O(N \log N)$ time. Finally, rebuilding the linked list takes $O(N)$ time. The sorting step dominates the runtime.
* *(Note: The optimal Min-Heap or Divide & Conquer approach brings this down to $O(N \log k)$).*


* **Space Complexity:** $O(N)$
* Extra memory is allocated to store all $N$ values inside the `ArrayList`. Furthermore, the algorithm creates $N$ brand-new `ListNode` objects to build the final returned list instead of recycling the existing nodes in place, resulting in a linear auxiliary memory footprint.
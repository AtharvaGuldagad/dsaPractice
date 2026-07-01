# Add Two Numbers

## Intuition

### The Reverse Order Advantage

At first glance, having the numbers stored backwards inside the linked lists seems like a complication. However, it is actually a massive advantage. When we do standard addition by hand, we always line up the numbers on the right side and add them from the smallest place value (ones, tens, hundreds) to the largest. Because the linked lists are in reverse order, the very first node is the ones column. We can simply walk forward through both lists and add them exactly how we would on paper.

### The Dummy Node and the Carry

When adding two digits, the sum can be larger than 9 (for example, 7 + 8 = 15). We must split this result: we write down the 5 and "carry" the 1 over to the next column. We can manage this by keeping a running memory of the carry.

To build our resulting list smoothly without having to write messy, special-case logic for the very first digit, we can use the "dummy node" trick. We create a fake, placeholder node to anchor the start of our new list, build all our real answers behind it, and then just return everything that comes after the fake node at the end.

---

## Step-by-Step Guide

1. Create a fake, temporary starter item. This will serve as the anchor for your new chain of answers.
2. Hire a worker and place them at this starter item to build the connections.
3. Keep a sticky note to remember any "carry-over" math. Start this note at zero.
4. Begin a loop. You will keep working as long as there is at least one item left in either of the two lists, OR if you still have a number written on your sticky note.
5. Look at the item you are standing on in the first list. If the list is empty and you ran out of items, just pretend the number is a zero. Otherwise, grab the actual number.
6. Do the exact same thing for the second list.
7. Add those two numbers together. Also, add whatever number is currently written on your sticky note.
8. Look at your total sum. Figure out if you need to carry a number to the next column. Divide the sum by 10 to find your new carry-over, and write that down on your sticky note.
9. Figure out the actual digit you get to keep for this column by finding the remainder (the sum modulo 10).
10. Create a brand new item using that exact kept digit. Tell your worker to attach it to the end of your answer chain, and then move the worker forward onto this new item.
11. If the first list still has items, step forward to the next one. Do the same for the second list.
12. Repeat steps 5 through 11 until both lists are completely exhausted and your sticky note is back to zero.
13. Your fake starter item is now pulling the entire completed answer. Give back the actual start of the chain, which is the item sitting right behind your fake starter.

---

## Complexity Analysis

* **Time Complexity:** $O(\max(M, N))$
* We traverse the lists simultaneously. The process only continues until we reach the end of the longer linked list (plus one potential extra step if there is a final carry-over). Therefore, the time scales linearly with whichever list is longer, where $M$ and $N$ are the lengths of the two lists.


* **Space Complexity:** $O(1)$
* We only allocate memory for a few primitive integer variables to store the current digits and the carry value, along with a couple of pointers. While the output list itself takes $O(\max(M, N))$ space, we do not count the required return data structure as part of the auxiliary space complexity. The extra memory used strictly for the logic is constant.
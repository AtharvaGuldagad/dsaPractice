# Number of 1 Bits

## Intuition

### The Bitmask Concept

At a hardware level, a computer stores numbers as a sequence of 32 bits (0s and 1s). To figure out if a specific slot in that sequence is a 1, we can create a "mask." A mask is a temporary sequence that has a 1 in the exact slot we want to check, and 0s everywhere else.

When we combine the original number and our mask using a bitwise AND operation, the 0s in our mask act like an eraser, wiping out everything except the one slot we care about. If the remaining result is not zero, it mathematically proves that the original number had a 1 sitting in that exact slot.

### The 32-Bit Scan

Because a standard integer is strictly bounded to 32 bits, we do not need to guess how long the sequence is. We can simply start our mask at the far-right edge and physically slide the 1 over to the left, step by step, exactly 32 times. By checking the result after every single slide, we can count exactly how many 1s exist in the entire number.

---

## Step-by-Step Guide

1. Get a blank notepad to keep a running tally of how many 1s you find. Start your tally at zero.
2. Create a special measuring stick (your mask). Put a single 1 at the very beginning of the stick (the far right side).
3. Line your measuring stick up with the number you are testing.
4. Check the specific slot where your measuring stick has its 1. Ask: "Does the number I am testing also have a 1 in this exact same spot?"
5. **If YES:** Add one to the tally on your notepad.
6. **If NO:** Do nothing to your tally.
7. Slide the 1 on your measuring stick exactly one space to the left.
8. Repeat steps 3 through 7 until you have slid the stick 32 times and checked every single possible slot.
9. Give back the final tally written on your notepad.

---

## Complexity Analysis

* **Time Complexity:** $O(1)$
* The `for` loop always executes exactly 32 times, regardless of whether the input number is extremely massive or just zero. Because the number of operations is strictly fixed and does not scale with the size of the input, the time complexity is constant.


* **Space Complexity:** $O(1)$
* We only require a single integer variable to keep track of the running count. No arrays or dynamic memory structures are created, meaning the auxiliary space utilized is strictly constant.
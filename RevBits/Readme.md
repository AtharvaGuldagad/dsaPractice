# Reverse Bits

## Intuition

### Bit Inspection and Placement

Reversing the bits of a 32-bit unsigned integer is conceptually identical to reversing a string, but performed directly on binary digits.

To flip the entire 32-bit sequence, we inspect each bit of the input number `n` starting from the rightmost position (index $0$) and moving left to the highest position (index $31$). Whenever we extract a bit sitting at position $i$, its reversed spot on the opposite side of the 32-bit window will be position $31 - i$.

### Bitwise Operators

1. **Extracting the Bit:** Right-shifting `n` by $i$ steps (`n >> i`) moves the bit at position $i$ down to the lowest bit position. Performing a bitwise AND with $1$ (`& 1`) isolates this single bit, turning off all higher bits.
2. **Placing the Bit:** Left-shifting the extracted bit `b` by $31 - i$ steps (`b << (31 - i)`) moves it to its new mirrored position.
3. **Accumulating:** We add (or bitwise OR) this shifted bit into our running result `res`.

---

## Step-by-Step Guide

1. Initialize a variable `res` to zero. This will accumulate our reversed 32-bit integer.
2. Start a loop that runs 32 times, with index $i$ ranging from $0$ up to $31$.
3. Extract the bit sitting at position $i$:
* Shift `n` to the right by $i$ places (`n >> i`).
* Apply `& 1` to isolate the bit, saving the value ($0$ or $1$) into `b`.


4. Move the extracted bit `b` to its reversed position:
* Shift `b` to the left by $31 - i$ places (`b << (31 - i)`).


5. Add this shifted value to `res`.
6. Repeat steps 3 through 5 until all 32 bits have been processed.
7. Return `res` as the final reversed 32-bit integer.

---

## Complexity Analysis

* **Time Complexity:** $O(1)$
* The loop always runs exactly 32 times regardless of the input value. Because the number of bitwise operations is strictly fixed, the time complexity is constant.


* **Space Complexity:** $O(1)$
* Only a few primitive integer variables (`res`, `i`, `b`) are used for computation. No extra data structures are allocated, keeping the auxiliary space footprint strictly constant.
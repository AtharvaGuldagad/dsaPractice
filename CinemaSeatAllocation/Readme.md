# Cinema Seat Allocation

## Intuition

### Bitmasking Seating Blocks

In a 10-seat row (seats 1 through 10), 4-person families can only sit in contiguous blocks of four:

1. **Left Block:** Seats $[2, 3, 4, 5]$
2. **Middle Block:** Seats $[4, 5, 6, 7]$
3. **Right Block:** Seats $[6, 7, 8, 9]$

Seats 1 and 10 do not affect the placement of 4-person families at all. Therefore, we only care about seats 2 through 9 (an 8-seat window), which we can represent as an 8-bit integer mask ($0$ to $7$ bit positions, shifting seat numbers by subtracting 2):

* **Left mask:** Bits $0, 1, 2, 3 \rightarrow (1111)_2 = 15$
* **Middle mask:** Bits $2, 3, 4, 5 \rightarrow (00111100)_2 = 60$
* **Right mask:** Bits $4, 5, 6, 7 \rightarrow (11110000)_2 = 240$

### Row Optimization

Rows with no reserved seats can naturally accommodate **2 families** each (Left block + Right block).

Instead of allocating memory for all $n$ rows (which could be as large as $10^9$), we use a Hash Map to record reserved seat bitmasks only for rows that actually have reservations in the $[2, 9]$ range. Any completely unreserved row is accounted for directly with:

$$\text{res} = (n - \text{map.size()}) \times 2$$

---

## Step-by-Step Guide

1. Create a `HashMap<Integer, Integer>` to map each row number to an 8-bit reserved seat mask.
2. Iterate through `reservedSeats`:
* If `seat` is between $2$ and $9$, set the corresponding bit in the row's bitmask: `mask | (1 << (seat - 2))`.


3. Define the bitmask constants: `left = 15`, `mid = 60`, and `right = 240`.
4. Initialize `res = (n - map.size()) * 2` to count 2 families for every row with zero reservations in seats $[2, 9]$.
5. For each row mask stored in the map:
* Check availability:
* `lFlag = (mask & left) == 0` (Left block is open)
* `midFlag = (mask & mid) == 0` (Middle block is open)
* `rFlag = (mask & right) == 0` (Right block is open)


* If both left and right blocks are available (`lFlag && rFlag`), add $2$ to `res`.
* Otherwise, if at least one configuration is available (`lFlag || midFlag || rFlag`), add $1$ to `res`.


6. Return `res`.

---

## Complexity Analysis

* **Time Complexity:** $O(M)$
* Where $M$ is the number of entries in `reservedSeats`. Building the bitmasks takes $O(M)$ operations, and iterating through the map values takes $O(U)$ where $U \le M$ is the number of unique reserved rows. Bitwise checks run in $O(1)$ constant time.


* **Space Complexity:** $O(U)$
* We only store rows that contain at least one reservation in seats $[2, 9]$. In the worst case, $U \le \min(n, M)$, requiring $O(M)$ auxiliary space.
# Detect Squares

## Intuition

### Diagonal-Driven Square Identification

To form an axis-aligned square with a query point $(p_x, p_y)$, we need three additional vertices:

1. A diagonally opposite point $(x, y)$
2. Two adjacent corner points: $(x, p_y)$ and $(p_x, y)$

For any candidate point $(x, y)$ to be a valid diagonal opposite of $(p_x, p_y)$:

* It must form a non-zero area square: $x \ne p_x$ and $y \ne p_y$.
* The horizontal and vertical distances must be equal: $\vert{}p_x - x\vert{} == \vert{}p_y - y\vert{}$.

Instead of checking all pairs of points, we iterate through all existing points $(x, y)$ as potential diagonal opposites. Once a valid diagonal point is found, the locations of the other two corners are strictly fixed at $(x, p_y)$ and $(p_x, y)$. The total number of valid squares formed with this diagonal is the product of the frequencies of the two required corner points:

$$\text{Squares} = \text{count}(x, p_y) \times \text{count}(p_x, y)$$

---

## Step-by-Step Guide

1. Maintain two data structures:
* A list `pts` storing all inserted points (to iterate over candidates).
* A frequency hash map `ptsCount` mapping coordinate pairs $[x, y]$ to their occurrence counts (to look up corner points in $O(1)$ time).


2. **`add(point)`:**
* Convert `point` into a coordinate list $[x, y]$.
* Increment its frequency in `ptsCount`.
* Append the point to `pts`.


3. **`count(point)`:**
* Set `res = 0`, and let $(px, py)$ be the query coordinates.
* Iterate through every candidate point $(x, y)$ in `pts`:
* **Filter:** Skip if $x == px$, $y == py$, or $\vert{}py - y\vert{} \ne \vert{}px - x\vert{}$.
* **Lookup:** Check the frequencies of the remaining two corners: $(x, py)$ and $(px, y)$.
* **Accumulate:** Multiply their counts and add to `res`.


* Return `res`.



---

## Complexity Analysis

* **Time Complexity:**
* **`add`:** $O(1)$ constant time to insert into the list and hash map.
* **`count`:** $O(N)$ where $N$ is the total number of points added so far. We iterate through the list of points and perform $O(1)$ hash map lookups for each candidate.


* **Space Complexity:** $O(N)$
* Storing $N$ points in the list `pts` and hash map `ptsCount` takes linear auxiliary space proportional to the number of calls to `add`.
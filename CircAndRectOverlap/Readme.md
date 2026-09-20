# Circle and Rectangle Overlap

## Intuition

### Nearest Point Projection Method

To determine if a circle with radius $r$ centered at $(cx, cy)$ overlaps with an axis-aligned rectangle defined by corners $(x_1, y_1)$ and $(x_2, y_2)$:

1. **Find the Nearest Point on the Rectangle:**
The closest point $(nx, ny)$ inside or on the boundary of the rectangle to the circle center $(cx, cy)$ is found by clamping $cx$ and $cy$ within the rectangle's coordinate bounds:

$$nx = \max(x_1, \min(cx, x_2))$$


$$ny = \max(y_1, \min(cy, y_2))$$


2. **Calculate Distance to Circle Center:**
The horizontal distance vector $x$ and vertical distance vector $y$ from the nearest point to the circle's center are:

$$x = nx - cx$$


$$y = ny - cy$$


3. **Compare Squared Distances:**
The squared distance from the circle center to the nearest point on the rectangle is $x^2 + y^2$. The circle and rectangle overlap if and only if this squared distance is less than or equal to $r^2$:

$$x^2 + y^2 \le r^2$$



Using squared distances avoids computing expensive floating-point square root operations (`Math.sqrt`).

---

## Step-by-Step Guide

1. Clamp $cx$ between $x_1$ and $x_2$ to find $nx$, then subtract $cx$ to get displacement $x$:
* `int x = Math.max(x1, Math.min(cx, x2)) - cx;`


2. Clamp $cy$ between $y_1$ and $y_2$ to find $ny$, then subtract $cy$ to get displacement $y$:
* `int y = Math.max(y1, Math.min(cy, y2)) - cy;`


3. Calculate Euclidean distance squared $x^2 + y^2$.
4. Return `true` if $x^2 + y^2 \le r^2$, otherwise return `false`.

---

## Complexity Analysis

* **Time Complexity:** $O(1)$
* Uses a fixed set of basic arithmetic operations and comparisons (`Math.max`, `Math.min`), running in constant time.


* **Space Complexity:** $O(1)$
* Uses constant auxiliary space for primitive variables (`x`, `y`).
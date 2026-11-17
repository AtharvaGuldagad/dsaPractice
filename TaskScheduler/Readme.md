# Task Scheduler

## Intuition

### Greedy Frame Scheduling Formula

The minimum total CPU intervals required to finish all tasks is dictated by the **most frequent task(s)**, because those tasks create the longest mandatory cooldown chain:

1. **Building the Frame:** Suppose the highest frequency of any task is `maxf`. Placing all `maxf` instances of this task with a cooldown of `n` between each instance creates `maxf - 1` gaps, where each block (the task itself plus its `n` cooldown slots) has length `n + 1`:

$$\text{Frame Base} = (\text{maxf} - 1) \times (n + 1)$$


2. **Handling Ties (`maxCount`):** If multiple distinct tasks share the maximum frequency `maxf` (say `maxCount` tasks), each of those tasks requires one final execution slot after the last gap completes:

$$\text{time} = (\text{maxf} - 1) \times (n + 1) + \text{maxCount}$$


3. **Overflow Beyond Idle Slots (`Math.max`):** The remaining less-frequent tasks fill the idle slots inside the `(maxf - 1)` frames. If there are so many distinct tasks or total tasks that all idle slots are filled without needing any idle time at all, the CPU runs continuously without stalling, making `tasks.length` the exact lower bound.

*(Micro-optimization note: Replacing `Arrays.stream(count).max().getAsInt()` with a single `for` loop over `count` avoids stream pipeline overhead and finds both `maxf` and `maxCount` in one pass).*

---

## Step-by-Step Guide

1. **Count Task Frequencies:**
* Allocate `int[] count = new int[26]` and tally occurrences of each uppercase letter (`count[task - 'A']++`).


2. **Identify Maximum Frequency & Tie Count:**
* Find `maxf`, the highest value in `count`.
* Count how many tasks have frequency equal to `maxf` (`maxCount`).


3. **Compute Minimum Frame Length:**
* Calculate `time = (maxf - 1) * (n + 1) + maxCount`.


4. **Return Lower Bound:**
* Return `Math.max(tasks.length, time)`.



---

## Complexity Analysis

* **Time Complexity:** **$O(N)$**
* Where $N$ is `tasks.length`. Counting task frequencies takes $O(N)$ time, and scanning the fixed 26-element array takes $O(26) = O(1)$ time.


* **Space Complexity:** **$O(1)$**
* The frequency array `count` has a fixed size of 26 regardless of input size, consuming constant auxiliary memory.
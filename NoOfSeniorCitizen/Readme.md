# Number of Senior Citizens

## Intuition

### Fixed-Index Substring Extraction

Each string in `details` has a fixed length of 15 characters, structured into specific fields:

* **Phone Number:** First 10 characters (indices `0` to `9`)
* **Gender:** 11th character (index `10`)
* **Age:** 12th and 13th characters (indices `11` and `12`)
* **Seat Number:** Last 2 characters (indices `13` and `14`)

Because the schema is fixed, the passenger's age is always located strictly at index range `[11, 13)` (`d.substring(11, 13)`).

To count senior citizens (passengers strictly older than 60):

1. Slice the 2-digit age substring for each passenger string.
2. Convert it into an integer via `Integer.parseInt(...)`.
3. Check if the age is strictly greater than 60 (`age > 60`).

---

### Alternative Character-Based Comparison (No Parsing)

Since the age field is always a 2-digit number, we can avoid the small overhead of `substring` and string parsing altogether by checking character values directly:

* **Tens digit `d.charAt(11)`:**
* If `d.charAt(11) > '6'`, the age is at least 70, so the passenger is definitely a senior citizen.
* If `d.charAt(11) == '6'`, check the units digit: `d.charAt(12) > '0'` (age is 61–69).
* If `d.charAt(11) < '6'`, the age is 59 or below.



---

## Step-by-Step Guide

1. Initialize a counter `res = 0`.
2. Iterate through each passenger details string `d` in the array `details`:
* Extract the age substring using `d.substring(11, 13)`.
* Convert the substring to an integer using `Integer.parseInt(...)`.
* If the age is strictly greater than 60 (`> 60`), increment `res`.


3. Return `res`.

---

## Complexity Analysis

* **Time Complexity:** $O(N)$
* Where $N$ is the number of passenger strings in `details`. Processing each fixed-length string of size 15 takes $O(1)$ constant time operations, resulting in linear execution time relative to $N$.


* **Space Complexity:** $O(1)$
* Only a single primitive counter `res` is used. Allocating short substrings of length 2 takes negligible $O(1)$ auxiliary memory.
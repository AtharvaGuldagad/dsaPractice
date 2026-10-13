# Isomorphic Strings

## Intuition

### Bijective Character Mapping

Two strings `s` and `t` are isomorphic if the characters in `s` can be replaced to get `t`, preserving character order and mapping distinct characters to distinct characters (**one-to-one or bijective mapping**).

1. **Dual HashMaps:** Your implementation uses two maps (`mapST` for $s \to t$ and `mapTS` for $t \to s$). This dual tracking guarantees bijectivity:
* `mapST` prevents a single character in `s` from mapping to two different characters in `t`.
* `mapTS` prevents two different characters in `s` from mapping to the same character in `t`.


2. **Fixed ASCII Array Optimization:** Since character sets like ASCII or extended ASCII have bounded sizes (e.g., 256 chars), we can replace `HashMap` with fixed-size integer arrays (e.g., `int[256]`) to store the last-seen position of each character, avoiding object overhead and hashing operations.

---

## Step-by-Step Guide

1. **Initialize State:** Create two `HashMap<Character, Character>` structures (`mapST` and `mapTS`).
2. **Traverse Pairwise:** Loop through index `i` from `0` to `s.length() - 1`:
* Extract $c_1 = \text{s.charAt}(i)$ and $c_2 = \text{t.charAt}(i)$.
* **Conflict Check:**
* If $c_1$ exists in `mapST` but maps to a value other than $c_2$, return `false`.
* If $c_2$ exists in `mapTS` but maps to a value other than $c_1$, return `false`.


* **Record Mapping:** Put $(c_1, c_2)$ into `mapST` and $(c_2, c_1)$ into `mapTS`.


3. Return `true` if all character pairs satisfy the mapping constraints.

---

## Complexity Analysis

* **Time Complexity:** $O(N)$
* Where $N$ is the length of string `s` (or `t`). The algorithm performs a single pass through the strings with constant $O(1)$ map lookups and insertions per character.


* **Space Complexity:** $O(K)$
* Where $K$ is the size of the character set (at most $O(1)$ for standard ASCII strings up to 256 unique characters).
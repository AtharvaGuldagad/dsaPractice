# Unique Email Addresses

## Intuition

### Local Name Normalization & Domain Separation

Email addresses consist of a **local name** and a **domain name** separated by the `@` symbol. To count unique email addresses receiving mail, each email is converted to its canonical form according to two filtering rules applied strictly to the local name:

1. **Periods (`.`):** Ignored entirely. `"first.last"` normalizes to `"firstlast"`.
2. **Plus Signs (`+`):** Everything after the first plus sign in the local name is ignored. `"first+custom"` normalizes to `"first"`.
3. **Domain Name:** Kept as-is without any modifications.

By parsing each email string into its canonical `local@domain` representation and inserting the result into a `HashSet`, duplicate addresses are naturally deduplicated.

---

## Step-by-Step Guide

1. Initialize a `Set<String> unique = new HashSet<>()`.
2. Loop through each string `e` in `emails`:
* Use index `i` and `StringBuilder local` to process the local name.
* **Parse Local Name:** Traverse until encountering `'@'` or `'+'`:
* If `e.charAt(i) != '.'`, append the character to `local`.
* Increment `i`.


* **Skip Rest of Local Name:** If stopped at `'+'`, advance `i` until reaching `'@'`.
* **Extract Domain Name:** Scribe the substring starting from `i + 1` (`e.substring(i + 1)`).
* **Form Canonical Key:** Combine `local.toString() + "@" + domain` and add it to `unique`.


3. Return `unique.size()`.

---

## Complexity Analysis

* **Time Complexity:** $O(N \times L)$
* Where $N$ is the number of emails and $L$ is the maximum length of an email string. Processing each string character-by-character and adding the normalized email to the `Set` takes linear time relative to total input characters.


* **Space Complexity:** $O(N \times L)$
* Storing normalized email strings in the `HashSet` takes up to $O(N \times L)$ auxiliary space in the worst case when all emails are unique.
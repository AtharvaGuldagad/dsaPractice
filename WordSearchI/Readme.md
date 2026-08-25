# Implement Trie (Prefix Tree)

## Intuition

### Multi-Way Tree of Prefixes

A **Trie** (Prefix Tree) is a specialized tree structure used for fast string retrieval and prefix matching. Instead of storing entire words at single nodes, each path down the tree represents a sequence of characters.

* **Common Prefixes are Shared:** Words starting with the same letters (like `"app"` and `"apple"`) share the same parent nodes, saving space and allowing fast prefix lookups.
* **Terminal Marker (`endOfWord`):** Distinguishes between a prefix and a complete valid word (e.g., distinguishing `"app"` inside `"apple"`).

---

## Step-by-Step Guide

1. **`TrieNode` Design:**
* `children`: A hash map (or fixed array `TrieNode[26]`) mapping each character to its child node.
* `endOfWord`: A boolean flag marked `true` at the terminal character of an inserted word.


2. **`insert(word)`:**
* Start `curr` at `root`.
* For each character `c` in `word`:
* If `c` is not in `curr.children`, instantiate a new `TrieNode`.
* Move `curr` to the child node corresponding to `c`.


* Set `curr.endOfWord = true` at the final node.


3. **`search(word)`:**
* Start `curr` at `root`.
* For each character `c` in `word`:
* If `c` is not in `curr.children`, return `false`.
* Move `curr` to the child node.


* Return `curr.endOfWord` (true only if the full word was previously inserted).


4. **`startsWith(prefix)`:**
* Follow the same path traversal as `search`.
* If all characters in `prefix` are successfully traced, return `true` regardless of `curr.endOfWord`.



---

## Complexity Analysis

* **Time Complexity:**
* **`insert`:** $O(L)$, where $L$ is the length of `word`. We perform $L$ node lookups/insertions.
* **`search`:** $O(L)$, traversing at most $L$ nodes.
* **`startsWith`:** $O(P)$, where $P$ is the length of `prefix`.


* **Space Complexity:** $O(N \times L)$
* In the worst case with no overlapping prefixes, inserting $N$ words of average length $L$ creates $O(N \times L)$ `TrieNode` instances.
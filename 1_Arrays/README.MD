# Java DSA Collection

A curated collection of Java implementations for core Data Structures and Algorithms. Organized by topic (arrays, strings, sorting, recursion, backtracking, trees, graphs, stacks, queues, greedy, binary trees, BSTs, etc.). This repo represents hands-on problem solving and clean, readable Java code.

## Highlights
- Arrays: max subarray (Kadane), two-pointers, binary search variants
- Strings: palindrome, lexicographic comparisons, path problems
- Sorting: bubble, selection, insertion, counting, quick, merge
- 2D Arrays: spiral print, diagonal sums, matrix search
- Recursion & Backtracking: subsets, permutations, N-Queens, Sudoku solver
- Linked Lists: insert/delete, reverse, mid, merge sort, palindrome, cycle detect/remove, zig-zag
- Stacks & Queues: next greater, duplicate parentheses, histogram area, sliding window max, deque tricks
- Greedy: activity selection, fractional knapsack, job sequencing, Indian coins
- Trees & BSTs: height, diameter, LCA, top view, sum tree, BST ops and validations

## Run any file
Each topic directory contains independent Java files with a `main` method. Compile and run per directory to avoid name clashes:

```bash
# Example: compile and run MaxSubarraySum
cd 1_Arrays
javac MaxSubarraySum.java
java MaxSubarraySum
```

Tip: If a file depends on helpers in the same folder, compile all `.java` files in that folder together:

```bash
javac *.java
```

## Local quick check (optional)
To compile all directories into a local build output, run:

```bash
# from repo root
mkdir -p .build_dirwise
for d in */; do find \"$d\" -name \"*.java\" >/dev/null 2>&1 && javac -d \".build_dirwise/$d\" \"$d\"/*.java || true; done
```

## Folder map
- `0_JavaProgrammingBasics/` — basic Java syntax and patterns
- `1_Arrays/`, `3_Strings/`, `4_2DArrays/` — foundational DSA
- `2_Basic Sorting/`, `8_DivideAndConquer/` — sorting and divide & conquer
- `5_Bit Manipulation/` — bitwise tricks and exponentiation
- `7_RecursionBasics/`, `10_Backtracking/` — recursion patterns and classic backtracking
- `11_ArrayLists/`, `12_LinkedList.java/` — dynamic arrays and linked list algorithms
- `13_Stacks/`, `14_Queues/` — stack/queue problems, sliding window
- `15_Greedy/` — greedy techniques
- `16_BinaryTrees/`, `17_Binary Search Trees (1|2)/` — tree/BST algorithms

## Notes
- No external libraries required.
- Java version used for checks: `javac 25` (any modern JDK 8+ should work for most files).
- Class files and build outputs are ignored by `.gitignore`.



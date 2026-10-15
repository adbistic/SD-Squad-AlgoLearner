# AlgoLearn: Milestone Quiz Questions

**Owner:** Youssef Jelassi
One quiz at the end of each level: **5 multiple-choice questions**, **4 options** each.
A student needs **60% (3 of 5)** to pass and unlock the next level.
✅ marks the correct answer.

---

# 🟢 Easy Level Quiz

**1. What does linear search return if the target is not in the array?**
- A. 0
- B. -1 ✅
- C. The last index
- D. It throws an exception

*Explanation:* We return -1 because it can never be a valid index.

**2. What is the worst-case time complexity of linear search on n elements?**
- A. O(1)
- B. O(log n)
- C. O(n) ✅
- D. O(n²)

*Explanation:* In the worst case the target is last or missing, so all n elements are checked.

**3. In bubble sort, what is guaranteed after the first full pass?**
- A. The smallest value is at the front
- B. The largest value is at the end ✅
- C. The array is sorted
- D. Nothing is guaranteed

*Explanation:* Each swap carries the biggest value seen so far to the right, so it ends up last.

**4. Selection sort on [5, 2, 8, 1]: what does the array look like after the first swap?**
- A. [2, 5, 8, 1]
- B. [1, 2, 8, 5] ✅
- C. [1, 5, 8, 2]
- D. [5, 2, 1, 8]

*Explanation:* The smallest value 1 swaps with the first element 5; nothing else moves.

**5. Why can bubble sort stop early?**
- A. When a pass makes no swaps ✅
- B. When it finds the target
- C. After exactly n / 2 passes
- D. It can never stop early

*Explanation:* If no neighbours were swapped in a whole pass, every pair is in order, so the array is sorted.

---

# 🟡 Intermediate Level Quiz

**1. What must be true about an array before you use binary search on it?**
- A. It must have an even length
- B. It must be sorted ✅
- C. It must contain no negative numbers
- D. Nothing, it works on any array

*Explanation:* Binary search discards half by comparing with the middle, which only makes sense on sorted data.

**2. About how many steps does binary search need for 1,000,000 sorted elements?**
- A. About 20 ✅
- B. About 1,000
- C. About 500,000
- D. About 1,000,000

*Explanation:* Each step halves the area, and 2²⁰ ≈ 1,000,000, so about 20 steps.

**3. When is insertion sort fast?**
- A. When the array is reversed
- B. When the array is nearly sorted ✅
- C. When all values are negative
- D. Never, it is always O(n²)

*Explanation:* On nearly sorted data each value only shifts a little, so it runs in about O(n).

**4. What strategy does merge sort use?**
- A. Greedy
- B. Brute force
- C. Divide and conquer ✅
- D. Random guessing

*Explanation:* It splits the array into halves, sorts each half, and combines the results.

**5. What is the time complexity of merge sort?**
- A. O(n)
- B. O(log n)
- C. O(n log n) ✅
- D. O(n²)

*Explanation:* About log n levels of splitting, and each level does O(n) merging work.

---

# 🔴 Hard Level Quiz

**1. In quick sort, where is the pivot after partitioning?**
- A. At the start of the array
- B. At the end of the array
- C. In its final sorted position ✅
- D. It is removed from the array

*Explanation:* Everything smaller is on its left and everything bigger on its right, so the pivot is exactly where it belongs.

**2. When does quick sort (with the last element as pivot) hit its O(n²) worst case?**
- A. On random data
- B. On an already sorted array ✅
- C. When the array has an even length
- D. Never

*Explanation:* On sorted data the last element is always the largest, so each partition removes only one element.

**3. Which data structure does breadth-first search (BFS) use?**
- A. A stack
- B. A priority queue
- C. A hash map
- D. A queue ✅

*Explanation:* BFS processes vertices first in, first out, which is exactly what a queue does.

**4. Why can't Dijkstra's algorithm handle negative edge weights?**
- A. A finished vertex could later get a shorter path, breaking the greedy rule ✅
- B. Java ints cannot be negative
- C. The priority queue would throw an exception
- D. It can handle them fine

*Explanation:* Dijkstra assumes the closest vertex's distance is final; a negative edge could make it shorter later.

**5. What is the time complexity of BFS on a graph with V vertices and E edges?**
- A. O(V)
- B. O(E²)
- C. O(V + E) ✅
- D. O(V × E)

*Explanation:* Each vertex is visited once and each edge is checked once, so O(V + E).

---

## Answer key

| Level | Q1 | Q2 | Q3 | Q4 | Q5 |
|---|---|---|---|---|---|
| 🟢 Easy | B | C | B | B | A |
| 🟡 Intermediate | B | A | B | C | C |
| 🔴 Hard | C | B | D | A | C |

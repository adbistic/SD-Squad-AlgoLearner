# AlgoLearn: Learning Material

**Owner:** Alhamad Solaiman
Content for the 9 lessons of AlgoLearn. Used in the Figma design (lesson screens) and in the presentation.

Each lesson has: a **one-line summary**, an **explanation**, **how it works** (steps), a **real-life example**, and its **complexity**.

---

# 🟢 Level 1: Easy, First Steps
*What an algorithm is, how we measure its speed, and the first search and sorting algorithms.*

## Lesson 1: Linear Search & Big-O
**Summary:** Check every item one by one, and learn how we describe an algorithm's speed.

**Explanation:**
An algorithm is a clear, step-by-step recipe for solving a problem. Linear search is the simplest way to find a value in a list: start at the first element and compare each one with the target until you find it or reach the end.

**How it works:**
1. Look at the element at position 0.
2. If it equals the target, return its position.
3. Otherwise move to the next position and repeat.
4. If you reach the end without finding it, return -1.

**What is Big-O?** Big-O describes how the running time grows when the input gets bigger. With *n* elements, linear search may need to check all *n* in the worst case, so it is **O(n)** ("linear time"). It only needs one counter as extra memory, so its space is **O(1)** ("constant space").

**Real-life example:** Looking for a friend's name on an unsorted guest list, one line at a time.

| Time | Space |
|---|---|
| O(n) | O(1) |

## Lesson 2: Bubble Sort
**Summary:** Swap neighbours that are in the wrong order until nothing moves.

**Explanation:**
Sorting means putting values in order, for example from smallest to largest. Bubble sort repeatedly compares neighbours and swaps them when they are in the wrong order. After each pass, the largest remaining value "bubbles up" to the end.

**How it works:**
1. Compare each pair of neighbours from left to right.
2. If the left one is bigger, swap them.
3. After one pass, the largest value is at the end.
4. Repeat, ignoring the already-sorted end.
5. If a whole pass makes no swaps, the array is sorted, so stop early.

**Example:** `[5, 1, 4, 2]` → after pass 1: `[1, 4, 2, 5]` → after pass 2: `[1, 2, 4, 5]` ✔

**Real-life example:** Lining up students by height by letting neighbours swap places.

| Time | Space |
|---|---|
| O(n²) | O(1) |

## Lesson 3: Selection Sort
**Summary:** Repeatedly select the smallest remaining value and move it to the front.

**Explanation:**
Selection sort splits the array into a sorted part (left) and an unsorted part (right). Each round it finds the smallest value in the unsorted part and moves it to the end of the sorted part.

**How it works:**
1. Find the smallest value in the unsorted part.
2. Swap it with the first element of the unsorted part.
3. The sorted part grows by one.
4. Repeat until the unsorted part is empty.

**Example:** `[5, 2, 8, 1]` → swap 1 to the front → `[1, 2, 8, 5]` → 2 stays → swap 5 forward → `[1, 2, 5, 8]` ✔

**Good to know:** It always does about n × n comparisons, even on sorted data, but it makes very few swaps (at most n − 1).

**Real-life example:** Picking the smallest card from the table again and again and placing it in a row.

| Time | Space |
|---|---|
| O(n²) | O(1) |

---

# 🟡 Level 2: Intermediate, Working Smarter
*Use sorted data to search much faster, and meet divide and conquer.*

## Lesson 4: Binary Search
**Summary:** On sorted data, halve the search area at every step.

**Explanation:**
If the array is sorted, we don't need to check every element. Like opening a dictionary in the middle, we look at the middle element and throw away the half that cannot contain the target.

**How it works:**
1. Keep two markers, `low` and `high`, around the possible area.
2. Look at the middle element.
3. If it is the target, you're done.
4. If it is smaller than the target, search the right half (`low = mid + 1`).
5. If it is bigger, search the left half (`high = mid − 1`).
6. If `low` passes `high`, the target isn't there.

**Why it's fast:** Each step halves the area. 1,000,000 elements need only about **20 steps** (2²⁰ ≈ 1,000,000).

**⚠️ Important:** It only works on **sorted** data.

**Real-life example:** Finding a word in a dictionary or a page number in a book.

| Time | Space |
|---|---|
| O(log n) | O(1) |

## Lesson 5: Insertion Sort
**Summary:** Build a sorted section by inserting each new value in the right place.

**Explanation:**
Insertion sort works like sorting playing cards in your hand: pick up one card at a time and slide it into the correct position among the cards you already hold.

**How it works:**
1. Treat the first element as a sorted section.
2. Take the next element (the "key").
3. Shift every bigger value in the sorted section one step right.
4. Insert the key into the gap.
5. Repeat for every element.

**Good to know:** The worst case (reversed array) is O(n²), but on **nearly sorted** data it's almost **O(n)**. That's why real sorting libraries use it for small or almost-sorted pieces.

**Real-life example:** Sorting the cards in your hand during a card game.

| Time | Space |
|---|---|
| O(n²), best case O(n) | O(1) |

## Lesson 6: Merge Sort
**Summary:** Divide the array in half, sort each half, then merge them.

**Explanation:**
Merge sort uses **divide and conquer**: break a big problem into smaller ones of the same kind, solve them, and combine the answers.

**How it works:**
1. An array with 0 or 1 elements is already sorted.
2. Split the array into a left half and a right half.
3. Sort each half with merge sort (the method calls itself: **recursion**).
4. Merge the two sorted halves by repeatedly taking the smaller front element.

**Why it's fast:** Splitting gives about log n levels, and each level does n work, so it's **O(n log n)** always. Sorting 1,000,000 values takes about 20 million steps instead of about 1,000,000,000,000 for an O(n²) sort.

**Cost:** it needs an extra array (O(n) memory).

**Real-life example:** Two people each sort half of a pile of exam papers, then combine their piles.

| Time | Space |
|---|---|
| O(n log n) | O(n) |

---

# 🔴 Level 3: Hard, Real-World Algorithms
*The sort used in practice, and how maps and networks find paths.*

## Lesson 7: Quick Sort
**Summary:** Partition around a pivot, then sort each side.

**Explanation:**
Quick sort is a divide-and-conquer algorithm and one of the fastest sorts in practice. Java's `Arrays.sort` uses a version of it for numbers.

**How it works:**
1. Pick a **pivot** (for example, the last element).
2. **Partition:** move smaller values to the pivot's left and bigger ones to its right. The pivot is now in its **final position**.
3. Quick sort the left part and the right part the same way.

**Good to know:** On average it's **O(n log n)**. But if the pivot is always the smallest or biggest value (for example on already-sorted data), it slows down to **O(n²)**. Real versions pick the pivot smartly (random, or median of three).

**Real-life example:** Splitting a class into "shorter than Ali" and "taller than Ali", then repeating inside each group.

| Time | Space |
|---|---|
| O(n log n) average, O(n²) worst | O(log n) |

## Lesson 8: Graphs: BFS & DFS
**Summary:** Explore a network layer by layer (BFS) or path by path (DFS).

**Explanation:**
A **graph** is a set of **vertices** (points) connected by **edges** (lines). Social networks, road maps and the web are graphs. We store a graph as an **adjacency list**: for each vertex, a list of its neighbours.

**Breadth-first search (BFS):** uses a **queue** (first in, first out).
1. Put the start vertex in the queue and mark it visited.
2. Take a vertex from the front of the queue.
3. Add its unvisited neighbours to the back and mark them visited.
4. Repeat until the queue is empty.
BFS visits vertices in order of distance, so it finds the **shortest path** when all edges count the same.

**Depth-first search (DFS):** uses a **stack** (last in, first out) or recursion. It follows one path as deep as possible before going back. Useful for mazes, detecting cycles and finding connected groups.

**Real-life example:** BFS is finding "friends of friends" on Instagram; DFS is exploring a maze by following one corridor to its end.

| Time | Space |
|---|---|
| O(V + E) | O(V) |
*V = number of vertices, E = number of edges*

## Lesson 9: Dijkstra's Shortest Path
**Summary:** Find the cheapest route when roads have different lengths.

**Explanation:**
BFS works when all edges are equal. On a real map, roads have different lengths (**weights**). Dijkstra's algorithm finds the shortest distance from a start point to every other point, as long as no weight is negative.

**How it works:**
1. Start distance = 0; every other distance = infinity.
2. Put the start in a **priority queue** (always gives back the closest vertex).
3. Take out the closest vertex. For each neighbour, check whether going through this vertex is shorter than the best known distance. If yes, update it ("relax the edge") and add the neighbour to the queue.
4. Repeat until the queue is empty.

**Key idea (greedy):** the closest unfinished vertex can never get closer, so its distance is final.

**⚠️ Limitation:** it does **not** work with negative weights.

**Real-life example:** Google Maps / GPS finding the fastest route.

| Time | Space |
|---|---|
| O((V + E) log V) | O(V) |

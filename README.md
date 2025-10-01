# Assignment 1 – Design and Analysis of Algorithms

## Overview
This project implements four classic divide-and-conquer algorithms with safe recursion patterns, performance tracking, and empirical validation.  
Implemented in Java 17 with Maven + JUnit 5.

Algorithms:
- MergeSort (Master Theorem, Case 2, Θ(n log n))
- QuickSort (randomized pivot, smaller-first recursion, Θ(n log n) average, O(n²) worst)
- Deterministic Select (Median-of-Medians, Θ(n))
- Closest Pair of Points in 2D (Divide & Conquer, Θ(n log n))

Performance tracking:
- Comparisons  
- Swaps  
- Recursion depth  
- Execution time  

---

## Architecture Notes
- Safe recursion: QuickSort recurses only on the smaller partition; Select recurses only where necessary.  
- Reusable buffer: MergeSort reuses a buffer for merging.  
- Cutoff: MergeSort switches to insertion sort for very small arrays.  
- Metrics: All algorithms report comparisons, swaps, recursion depth, and runtime via `PerformanceTracker`.  

---

## Recurrence Analysis
- MergeSort:  
  T(n) = 2T(n/2) + Θ(n) → Θ(n log n) (Master Case 2).  

- QuickSort:  
  Best/Average: T(n) = T(n/2) + T(n/2) + Θ(n) → Θ(n log n).  
  Worst: T(n) = T(n−1) + Θ(n) → Θ(n²).  

- Deterministic Select (Median-of-Medians):  
  T(n) = T(n/5) + T(7n/10) + Θ(n) → Θ(n) by Akra–Bazzi.  

- Closest Pair of Points:  
  T(n) = 2T(n/2) + Θ(n) → Θ(n log n) (Master Case 2).  

---

## Empirical Validation

### Runtime vs n
![Runtime](docs/plots/runtime.png)

### Recursion Depth vs n
![Recursion Depth](docs/plots/depth.png)

### Comparisons vs n
![Comparisons](docs/plots/comparisons.png)

### Swaps vs n
![Swaps](docs/plots/swaps.png)

---

## Testing
- Sorting algorithms tested on random, sorted, reverse-sorted, and duplicate inputs.  
- Deterministic Select validated against `Arrays.sort(a)[k]` for 100 random arrays.  
- Closest Pair validated against O(n²) brute-force for small n ≤ 2000.  
- Unit tests written in JUnit 5.  

---

## GitHub Workflow
Branches used:
- feature/mergesort
- feature/quicksort
- feature/select
- feature/closest
- feature/metrics

Commits follow the pattern:
- init: maven project structure
- feat(mergesort): implementation + tests
- feat(quicksort): randomized pivot + tests
- feat(select): median-of-medians + tests
- feat(closest): divide & conquer + tests
- feat(metrics): performance tracker
- docs(report): recurrence analysis + plots
- release: v1.0

---

## Conclusion
- Theoretical and empirical analyses align well.  
- MergeSort and QuickSort show Θ(n log n) growth, Select confirms linear time, Closest Pair matches expected performance.  
- Practical performance is influenced by constants (cache, GC, JIT).  
- QuickSort, though Θ(n²) worst case, is fastest in practice with randomized pivot.

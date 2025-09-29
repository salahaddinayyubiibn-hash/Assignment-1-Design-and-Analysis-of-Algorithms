package cli;

import algorithms.MergeSort;
import metrics.PerformanceTracker;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};

        PerformanceTracker tracker = new PerformanceTracker();
        MergeSort mergeSort = new MergeSort(tracker);

        System.out.println("Before: " + Arrays.toString(arr));
        mergeSort.sort(arr);
        System.out.println("After:  " + Arrays.toString(arr));

        System.out.println("\n--- Metrics ---");
        System.out.println("Comparisons: " + tracker.getComparisons());
        System.out.println("Swaps: " + tracker.getSwaps());
        System.out.println("Max recursion depth: " + tracker.getMaxRecursionDepth());
        System.out.println("Elapsed time (ns): " + tracker.getElapsedTime());
    }
}

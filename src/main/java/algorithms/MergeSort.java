package algorithms;

import metrics.PerformanceTracker;

import java.util.Arrays;

public class MergeSort {

    private final PerformanceTracker metrics;

    public MergeSort(PerformanceTracker metrics) {
        this.metrics = metrics;
    }

    public void sort(int[] array) {
        metrics.startTimer();  // Start measuring time
        mergeSort(array, 0, array.length - 1);
        metrics.stopTimer();   // Stop measuring time
    }

    private void mergeSort(int[] array, int left, int right) {
        metrics.enterRecursion();  // Track recursion depth
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
        metrics.exitRecursion();
    }

    private void merge(int[] array, int left, int mid, int right) {
        int[] leftArray = Arrays.copyOfRange(array, left, mid + 1);
        int[] rightArray = Arrays.copyOfRange(array, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        while (i < leftArray.length && j < rightArray.length) {
            metrics.incrementComparisons();
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) {
            metrics.incrementSwaps();
            array[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            metrics.incrementSwaps();
            array[k++] = rightArray[j++];
        }
    }
}


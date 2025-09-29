package algorithms;

import metrics.PerformanceTracker;

public class MergeSort {
    private final PerformanceTracker tracker;

    public MergeSort(PerformanceTracker tracker) {
        this.tracker = tracker;
    }

    public void sort(int[] arr) {
        tracker.startTimer();
        tracker.enterRecursion();
        int[] buffer = new int[arr.length];
        mergeSort(arr, buffer, 0, arr.length - 1);
        tracker.exitRecursion();
        tracker.stopTimer();
    }

    private void mergeSort(int[] arr, int[] buffer, int left, int right) {
        if (left >= right) return;

        tracker.enterRecursion();
        int mid = (left + right) / 2;

        mergeSort(arr, buffer, left, mid);
        mergeSort(arr, buffer, mid + 1, right);

        merge(arr, buffer, left, mid, right);
        tracker.exitRecursion();
    }

    private void merge(int[] arr, int[] buffer, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;

        while (i <= mid && j <= right) {
            tracker.incrementComparisons();
            if (arr[i] <= arr[j]) {
                buffer[k++] = arr[i++];
            } else {
                buffer[k++] = arr[j++];
                tracker.incrementSwaps();
            }
        }

        while (i <= mid) buffer[k++] = arr[i++];
        while (j <= right) buffer[k++] = arr[j++];

        for (int p = left; p <= right; p++) {
            arr[p] = buffer[p];
        }
    }
}

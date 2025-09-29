package algorithms.quicksort;

import metrics.PerformanceTracker;

import java.util.Random;

public class QuickSort {
    private final PerformanceTracker metrics;

    public QuickSort(PerformanceTracker metrics) {
        this.metrics = metrics;
    }

    public void sort(int[] array) {
        metrics.startTimer();
        quickSort(array, 0, array.length - 1);
        metrics.stopTimer();
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            metrics.incrementComparisons();
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                metrics.incrementSwaps();
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        metrics.incrementSwaps();

        return i + 1;
    }
}

package algorithms;

import metrics.PerformanceTracker;

import java.util.Arrays;

public class DeterministicSelect {

    private final PerformanceTracker metrics;

    public DeterministicSelect(PerformanceTracker metrics) {
        this.metrics = metrics;
    }

    public int select(int[] array, int k) {
        metrics.startTimer();  // Start measuring time
        int result = deterministicSelect(array, 0, array.length - 1, k);
        metrics.stopTimer();   // Stop measuring time
        return result;
    }

    private int deterministicSelect(int[] array, int low, int high, int k) {
        if (low == high) {
            return array[low];
        }

        int pivotIndex = medianOfMedians(array, low, high);
        pivotIndex = partition(array, low, high, pivotIndex);

        if (k == pivotIndex) {
            return array[k];
        } else if (k < pivotIndex) {
            return deterministicSelect(array, low, pivotIndex - 1, k);
        } else {
            return deterministicSelect(array, pivotIndex + 1, high, k);
        }
    }

    private int medianOfMedians(int[] array, int low, int high) {
        int n = high - low + 1;
        int[] medians = new int[(n + 4) / 5];  // Group into blocks of 5
        for (int i = 0; i < n / 5; i++) {
            medians[i] = median(array, low + i * 5, low + (i + 1) * 5 - 1);
        }
        if (n % 5 != 0) {
            medians[medians.length - 1] = median(array, low + (n / 5) * 5, high);
        }
        return selectMedian(medians, 0, medians.length - 1);
    }

    private int median(int[] array, int low, int high) {
        int[] temp = Arrays.copyOfRange(array, low, high + 1);
        Arrays.sort(temp);
        return temp[temp.length / 2];
    }

    private int selectMedian(int[] medians, int low, int high) {
        if (low == high) {
            return medians[low];
        }
        int pivotIndex = partition(medians, low, high, (low + high) / 2);
        return medians[pivotIndex];
    }

    private int partition(int[] array, int low, int high, int pivotIndex) {
        int pivotValue = array[pivotIndex];
        swap(array, pivotIndex, high);
        int storeIndex = low;
        for (int i = low; i < high; i++) {
            metrics.incrementComparisons();
            if (array[i] < pivotValue) {
                swap(array, storeIndex, i);
                storeIndex++;
            }
        }
        swap(array, storeIndex, high);
        return storeIndex;
    }

    private void swap(int[] array, int i, int j) {
        metrics.incrementSwaps();
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

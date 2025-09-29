package algorithms.quicksort;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QuickSortTest {

    @Test
    public void testQuickSort() {
        PerformanceTracker metrics = new PerformanceTracker();
        QuickSort quickSort = new QuickSort(metrics);

        int[] array = {5, 2, 9, 1, 5, 6};
        quickSort.sort(array);

        int[] expected = {1, 2, 5, 5, 6, 9};
        assertArrayEquals(expected, array);
        System.out.println("Comparisons: " + metrics.getComparisons());
        System.out.println("Swaps: " + metrics.getSwaps());
    }
}

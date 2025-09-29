package metrics;

public class PerformanceTracker {
    private long startTime;
    private long endTime;
    private int comparisons;
    private int swaps;
    private int recursionDepth;
    private int maxRecursionDepth;

    public void startTimer() {
        startTime = System.nanoTime();
    }

    public void stopTimer() {
        endTime = System.nanoTime();
    }

    public long getElapsedTime() {
        return (endTime - startTime) / 1_000_000; // ms
    }

    public void incrementComparisons() {
        comparisons++;
    }

    public void incrementSwaps() {
        swaps++;
    }

    public void enterRecursion() {
        recursionDepth++;
        maxRecursionDepth = Math.max(maxRecursionDepth, recursionDepth);
    }

    public void exitRecursion() {
        recursionDepth--;
    }

    public int getComparisons() {
        return comparisons;
    }

    public int getSwaps() {
        return swaps;
    }

    public int getMaxRecursionDepth() {
        return maxRecursionDepth;
    }

    public void reset() {
        comparisons = 0;
        swaps = 0;
        recursionDepth = 0;
        maxRecursionDepth = 0;
        startTime = 0;
        endTime = 0;
    }
}

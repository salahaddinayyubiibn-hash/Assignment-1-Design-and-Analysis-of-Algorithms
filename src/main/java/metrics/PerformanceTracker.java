package metrics;

public class PerformanceTracker {
    private long comparisons;
    private long swaps;
    private long recursionDepth;
    private long maxRecursionDepth;
    private long startTime;
    private long endTime;

    public void startTimer() {
        startTime = System.nanoTime();
    }

    public void stopTimer() {
        endTime = System.nanoTime();
    }

    public long getElapsedTime() {
        return endTime - startTime;
    }

    public void incrementComparisons() {
        comparisons++;
    }

    public void incrementSwaps() {
        swaps++;
    }

    public void enterRecursion() {
        recursionDepth++;
        if (recursionDepth > maxRecursionDepth) {
            maxRecursionDepth = recursionDepth;
        }
    }

    public void exitRecursion() {
        recursionDepth--;
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getSwaps() {
        return swaps;
    }

    public long getMaxRecursionDepth() {
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

    @Override
    public String toString() {
        return "Comparisons: " + comparisons +
                ", Swaps: " + swaps +
                ", Max Depth: " + maxRecursionDepth +
                ", Time(ns): " + getElapsedTime();
    }
}

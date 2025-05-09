package de.bcxp.we.ws.komplizierteralgorithmus;

/**
 * Online sum-preserving rounding algorithm.
 * Call add(double value) for each input value in sequence.
 * Use getRoundedSum() to get the sum of rounded values so far.
 */
public class OnlineAlgorithm {
    private double runningSum = 0.0;
    private int roundedSum = 0;
    private double error = 0.0;

    /**
     * Adds a value and returns its rounded value, preserving the sum.
     */
    public int add(double value) {
        runningSum += value;
        int targetSum = (int) Math.round(runningSum);
        int roundedValue = targetSum - roundedSum;
        roundedSum += roundedValue;
        return roundedValue;
    }

    /**
     * Returns the sum of all rounded values so far.
     */
    public int getRoundedSum() {
        return roundedSum;
    }
}
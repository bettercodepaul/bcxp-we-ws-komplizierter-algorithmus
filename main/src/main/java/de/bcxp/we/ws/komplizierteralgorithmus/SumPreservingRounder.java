package de.bcxp.we.ws.komplizierteralgorithmus;

public class SumPreservingRounder {
    public static int[] roundPreservingSum(double[] numbers) {
        int n = numbers.length;
        int[] rounded = new int[n];
        double[] errors = new double[n];

        // Initial rounding and error calculation
        double originalSum = 0;
        double roundedSum = 0;
        for (int i = 0; i < n; i++) {
            originalSum += numbers[i];
            rounded[i] = (int) Math.round(numbers[i]);
            roundedSum += rounded[i];
            errors[i] = numbers[i] - rounded[i];
        }

        // Calculate the difference that needs to be distributed
        int diff = (int) Math.round(originalSum) - (int) roundedSum;

        // Distribute the difference based on rounding errors
        if (diff > 0) {
            // Need to increase some values
            for (int i = 0; i < diff; i++) {
                int maxErrorIndex = findMaxErrorIndex(errors);
                rounded[maxErrorIndex]++;
                errors[maxErrorIndex] -= 1;
            }
        } else if (diff < 0) {
            // Need to decrease some values
            for (int i = 0; i < -diff; i++) {
                int minErrorIndex = findMinErrorIndex(errors);
                rounded[minErrorIndex]--;
                errors[minErrorIndex] += 1;
            }
        }

        return rounded;
    }

    private static int findMaxErrorIndex(double[] errors) {
        int maxIdx = 0;
        for (int i = 1; i < errors.length; i++) {
            if (errors[i] > errors[maxIdx]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    private static int findMinErrorIndex(double[] errors) {
        int minIdx = 0;
        for (int i = 1; i < errors.length; i++) {
            if (errors[i] < errors[minIdx]) {
                minIdx = i;
            }
        }
        return minIdx;
    }
}
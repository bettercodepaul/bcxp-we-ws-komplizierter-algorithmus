package de.bcxp.we.ws.komplizierteralgorithmus;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class OnlineAlgorithmTest {

    @Test
    void testOnlineAlgorithm() {
        OnlineAlgorithm onlineAlgorithm = new OnlineAlgorithm();
        double[] input = {1.2, 2.7, 3.1, 4.4, 5.5, 2.1};
        double expectedSum = Arrays.stream(input).sum();
        for (double i : input) {
            System.out.println(onlineAlgorithm.add(i));
        }
        System.out.println(expectedSum);
        System.out.println(onlineAlgorithm.getRoundedSum());
        assertEquals(expectedSum, onlineAlgorithm.getRoundedSum());
    }

    @Test
    void testBigRoundingJump(){
        OnlineAlgorithm onlineAlgorithm = new OnlineAlgorithm();
        double[] input = {1.2, 1.2, 1.2, 1.2, 1.2, 1.2, 1.2, 1.2, 1.2, 1.2};
        double expectedSum = Arrays.stream(input).sum();
        for (double i : input) {
            System.out.println(onlineAlgorithm.add(i));
        }
        System.out.println(expectedSum);
        System.out.println(onlineAlgorithm.getRoundedSum());
        assertEquals(expectedSum, onlineAlgorithm.getRoundedSum());
    }

    @Test
    void testNegativeNumbers() {
        OnlineAlgorithm onlineAlgorithm = new OnlineAlgorithm();
        double[] input = {-1.2, 2.3, -3.1};
        int expectedSum = (int) Arrays.stream(input).sum();
        for (double i : input) {
            System.out.println(onlineAlgorithm.add(i));
        }
        System.out.println(expectedSum);
        System.out.println(onlineAlgorithm.getRoundedSum());
        assertEquals(expectedSum, onlineAlgorithm.getRoundedSum());
    }

    @Test
    void testOnlineAlgorithmWithSumPreservingInputs() {
        double[][] testInputs = {
            {1.2, 2.7, 3.1},
            {-1.2, -2.7, -3.1},
            {-3.8, -2.6, 1.4, 2.1, 1.9},
            {},
            {3.7},
            {1.0, 2.0, 3.0},
            {2.2, 2.2, 2.2, 2.2, 2.2}
        };

        for (double[] input : testInputs) {
            OnlineAlgorithm onlineAlgorithm = new OnlineAlgorithm();
            int sum = 0;
            for (double v : input) {
                sum += onlineAlgorithm.add(v);
            }
            assertEquals(Math.round(Arrays.stream(input).sum()), sum,
                "Sum mismatch for input: " + Arrays.toString(input));
        }
    }

}

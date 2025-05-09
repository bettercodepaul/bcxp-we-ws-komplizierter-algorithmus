package de.bcxp.we.ws.komplizierteralgorithmus;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProbabilisticRounderTest {
    private static final int ITERATIONS = 10000;
    private static final double TOLERANCE = 0.1;

    @Test
    void testExpectedValue() {
        ProbabilisticRounder rounder = new ProbabilisticRounder();
        double input = 3.7;

        double sum = 0;
        for (int i = 0; i < ITERATIONS; i++) {
            sum += rounder.round(input);
        }

        double average = sum / ITERATIONS;
        assertEquals(input, average, TOLERANCE,
            "Expected value should be close to original number");
    }

    @Test
    void testMultipleNumbers() {
        ProbabilisticRounder rounder = new ProbabilisticRounder();
        double[] inputs = {1.2, 2.7, 3.5, 4.8};

        for (double input : inputs) {
            double sum = 0;
            for (int i = 0; i < ITERATIONS; i++) {
                sum += rounder.round(input);
            }
            double average = sum / ITERATIONS;
            assertEquals(input, average, TOLERANCE,
                "Expected value should be close to original number: " + input);
        }
    }
}
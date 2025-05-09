package de.bcxp.we.ws.komplizierteralgorithmus;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SumPreservingRounderTest {

    @Test
    void testPositiveNumbers() {
        double[] input = {1.2, 2.7, 3.1};
        int[] rounded = SumPreservingRounder.roundPreservingSum(input);

        assertEquals(7, Arrays.stream(rounded).sum());
        assertEquals(Math.round(Arrays.stream(input).sum()), Arrays.stream(rounded).sum());
    }

    @Test
    void testNegativeNumbers() {
        double[] input = {-1.2, 2.7, -3.1};
        int[] rounded = SumPreservingRounder.roundPreservingSum(input);

        assertEquals(-2, Arrays.stream(rounded).sum());
        assertEquals(Math.round(Arrays.stream(input).sum()), Arrays.stream(rounded).sum());
    }

    @Test
    void testEmptyArray() {
        double[] input = {};
        int[] rounded = SumPreservingRounder.roundPreservingSum(input);

        assertEquals(0, rounded.length);
    }

    @Test
    void testSingleNumber() {
        double[] input = {3.7};
        int[] rounded = SumPreservingRounder.roundPreservingSum(input);

        assertEquals(4, rounded[0]);
        assertEquals(1, rounded.length);
    }

    @Test
    void testExactIntegers() {
        double[] input = {1.0, 2.0, 3.0};
        int[] rounded = SumPreservingRounder.roundPreservingSum(input);

        assertArrayEquals(new int[]{1, 2, 3}, rounded);
    }
}
package de.bcxp.we.ws.komplizierteralgorithmus;

import org.junit.jupiter.api.Test;


import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class SumPreservingRounderTest {

    @Test
    void testPositiveNumbers() {
        double[] input = {1.2, 2.7, 3.1};
        int[] rounded = SumPreservingRounder.roundPreservingSum(input);

        assertArrayEquals(new int[]{1, 3, 3}, rounded, "Gerundete Werte stimmen nicht überein.");
        assertEquals(Math.round(Arrays.stream(input).sum()), Arrays.stream(rounded).sum(), "Summen der gerundeten Zahlen stimmen nicht überein.");
    }

    @Test
    void testNegativeNumbers() {
        double[] input = {-1.2, -2.7, -3.1};
        int[] rounded = SumPreservingRounder.roundPreservingSum(input);

        assertArrayEquals(new int[]{-1, -3, -3}, rounded, "Gerundete Werte stimmen nicht überein.");
        assertEquals(Math.round(Arrays.stream(input).sum()), Arrays.stream(rounded).sum(), "Summen der gerundeten Zahlen stimmen nicht überein.");
    }

    @Test
    void testMixedSigns() {
        double[] input = {-3.8, -2.6, 1.4, 2.1, 1.9};
        int[] expectedRounded = {-4, -2, 1, 2, 2}; // Beispielannahme
        int[] rounded = SumPreservingRounder.roundPreservingSum(input);

        assertArrayEquals(expectedRounded, rounded, "Gerundete Werte stimmen nicht überein.");
        assertEquals(Math.round(Arrays.stream(input).sum()), Arrays.stream(rounded).sum(), "Summen der gerundeten Zahlen stimmen nicht überein.");
    }

    @Test
    void testEmptyArray() {
        double[] input = {};
        int[] rounded = SumPreservingRounder.roundPreservingSum(input);

        assertArrayEquals(new int[]{}, rounded, "Gerundete Werte stimmen nicht überein.");
        assertEquals(0, Arrays.stream(rounded).sum(), "Summen der gerundeten Zahlen stimmen nicht überein.");
    }

    @Test
    void testSingleNumber() {
        double[] input = {3.7};
        int[] rounded = SumPreservingRounder.roundPreservingSum(input);

        assertArrayEquals(new int[]{4}, rounded, "Gerundete Werte stimmen nicht überein.");
        assertEquals(4, Arrays.stream(rounded).sum(), "Summen der gerundeten Zahlen stimmen nicht überein.");
    }

    @Test
    void testExactIntegers() {
        double[] input = {1.0, 2.0, 3.0};
        int[] rounded = SumPreservingRounder.roundPreservingSum(input);

        assertArrayEquals(new int[]{1, 2, 3}, rounded, "Gerundete Werte stimmen nicht überein.");
        assertEquals(6, Arrays.stream(rounded).sum(), "Summen der gerundeten Zahlen stimmen nicht überein.");
    }

    @Test
    void testSumPreservingRoundingExample() {
        double[] input = {2.2, 2.2, 2.2, 2.2, 2.2};
        int[] expectedRounded = {3, 2, 2, 2, 2};
        int[] rounded = SumPreservingRounder.roundPreservingSum(input);

        assertArrayEquals(expectedRounded, rounded, "Gerundete Werte stimmen nicht überein.");
        assertEquals(11, Arrays.stream(rounded).sum(), "Summen der gerundeten Zahlen stimmen nicht überein.");
    }
}

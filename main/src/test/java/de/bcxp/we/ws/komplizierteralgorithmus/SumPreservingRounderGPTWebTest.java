package de.bcxp.we.ws.komplizierteralgorithmus;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SumPreservingRounderGPTWebTest {

    private int sum(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).sum();
    }

    private int roundedSum(List<Double> list) {
        return (int) Math.round(list.stream().mapToDouble(Double::doubleValue).sum());
    }

    @Test
    public void testEqualFloats() {
        List<Double> input = Arrays.asList(2.2, 2.2, 2.2, 2.2, 2.2);
        List<Integer> output = SumPreservingRounderGPTWeb.roundPreserveSum(input);
        assertEquals(11, sum(output));
    }

    @Test
    public void testAlreadyIntegerSum() {
        List<Double> input = Arrays.asList(1.5, 2.5, 3.0);
        List<Integer> output = SumPreservingRounderGPTWeb.roundPreserveSum(input);
        assertEquals(7, sum(output));
    }

    @Test
    public void testNegativeValues() {
        List<Double> input = Arrays.asList(-1.2, -2.3, -3.5);
        List<Integer> output = SumPreservingRounderGPTWeb.roundPreserveSum(input);
        assertEquals(-7, sum(output));
    }

    @Test
    public void testHalfValues() {
        List<Double> input = Arrays.asList(1.5, 1.5, 1.5);
        List<Integer> output = SumPreservingRounderGPTWeb.roundPreserveSum(input);
        assertEquals(5, sum(output));
    }

    @Test
    public void testUnevenFractions() {
        List<Double> input = Arrays.asList(1.1, 1.9, 1.3, 1.7);
        List<Integer> output = SumPreservingRounderGPTWeb.roundPreserveSum(input);
        assertEquals(6, sum(output));
    }

    @Test
    public void testSmallSum() {
        List<Double> input = Arrays.asList(0.1, 0.2, 0.3);
        List<Integer> output = SumPreservingRounderGPTWeb.roundPreserveSum(input);
        assertEquals(1, sum(output));
    }

    @Test
    public void testZeroSum() {
        List<Double> input = Arrays.asList(-1.5, 0.5, 1.0);
        List<Integer> output = SumPreservingRounderGPTWeb.roundPreserveSum(input);
        assertEquals(0, sum(output));
    }

    @Test
    public void testLargeNumbers() {
        List<Double> input = Arrays.asList(1000000.1, 1000000.9);
        List<Integer> output = SumPreservingRounderGPTWeb.roundPreserveSum(input);
        assertEquals(2000001, sum(output));
    }

    @Test
    public void testIdenticalFractionalParts() {
        List<Double> input = Arrays.asList(1.4, 2.4, 3.4);
        List<Integer> output = SumPreservingRounderGPTWeb.roundPreserveSum(input);
        assertEquals(7, sum(output));
    }

    @Test
    public void testManySmallValues() {
        Double[] array = new Double[100];
        Arrays.fill(array, 1.01);
        List<Double> input = Arrays.asList(array);
        List<Integer> output = SumPreservingRounderGPTWeb.roundPreserveSum(input);
        assertEquals(101, sum(output));
    }

    @Test
    public void testSumMatchesRoundedOriginal() {
        List<Double> input = Arrays.asList(3.3, 2.2, -1.7, 4.9);
        List<Integer> output = SumPreservingRounderGPTWeb.roundPreserveSum(input);
        assertEquals(roundedSum(input), sum(output));
    }

    @Test
    public void testAllAbovePointFive() {
        List<Double> input = Arrays.asList(1.6, 1.7, 1.8);
        List<Integer> output = SumPreservingRounderGPTWeb.roundPreserveSum(input);

        // Einzelne Runden genauer überprüfen
        System.out.println("Rundungen:");
        System.out.println("1.6 -> " + output.get(0));  // Erwartet: 2
        System.out.println("1.7 -> " + output.get(1));  // Erwartet: 2
        System.out.println("1.8 -> " + output.get(2));  // Erwartet: 2

        // Jetzt die Summe vergleichen
        assertEquals(6, sum(output));  // Summe sollte 6 sein (2 + 2 + 2 = 6)
    }


    @Test
    public void testOnlyWholeNumbers() {
        List<Double> input = Arrays.asList(1.0, 2.0, 3.0, 4.0);
        List<Integer> output = SumPreservingRounderGPTWeb.roundPreserveSum(input);
        assertEquals(10, sum(output));
        for (int i = 0; i < input.size(); i++) {
            assertEquals(input.get(i).intValue(), output.get(i)); // Jeder Eintrag bleibt gleich
        }
    }

    @Test
    public void testVerySmallValues() {
        List<Double> input = Arrays.asList(0.001, 0.002, 0.003);
        List<Integer> output = SumPreservingRounderGPTWeb.roundPreserveSum(input);
        assertEquals(0, sum(output)); // Summe = 0.006 → round(0.006) = 0
    }

    @Test
    public void testSingleElement() {
        List<Double> input = Arrays.asList(1.7);
        List<Integer> output = SumPreservingRounderGPTWeb.roundPreserveSum(input);
        assertEquals(2, sum(output));
        assertEquals(1, output.size());
    }

    @Test
    public void testEmptyList() {
        List<Double> input = Collections.emptyList();
        List<Integer> output = SumPreservingRounderGPTWeb.roundPreserveSum(input);
        assertTrue(output.isEmpty());
    }

    @Test
    public void testZeroValuesOnly() {
        List<Double> input = Arrays.asList(0.0, 0.0, 0.0);
        List<Integer> output = SumPreservingRounderGPTWeb.roundPreserveSum(input);
        assertEquals(0, sum(output));
        for (int val : output) {
            assertEquals(0, val);
        }
    }
}


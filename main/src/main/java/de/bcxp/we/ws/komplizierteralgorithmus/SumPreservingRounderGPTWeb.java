package de.bcxp.we.ws.komplizierteralgorithmus;

import java.util.*;

public class SumPreservingRounderGPTWeb {

    public static List<Integer> roundPreserveSum(List<Double> numbers) {
        int size = numbers.size();
        List<Integer> floored = new ArrayList<>();
        double totalSum = 0;
        int floorSum = 0;

        // Schritt 1: Abrunden und Summen berechnen
        for (double num : numbers) {
            int f = (int) Math.floor(num);
            floored.add(f);
            floorSum += f;
            totalSum += num;
        }

        int targetSum = (int) Math.round(totalSum);
        int difference = targetSum - floorSum;

        // Schritt 2: Nachkommastellen extrahieren
        List<int[]> fractionalParts = new ArrayList<>(); // int[0] = index, int[1] = scaled fraction (für Sortierung)

        for (int i = 0; i < size; i++) {
            double frac = numbers.get(i) - Math.floor(numbers.get(i));
            fractionalParts.add(new int[] { i, (int) (frac * 1_000_000) }); // Skalierung für stabile Sortierung
        }

        // Schritt 3: Sortiere nach absteigenden Nachkommawerten
        fractionalParts.sort((a, b) -> Integer.compare(b[1], a[1]));

        // Schritt 4: Diff viele Elemente aufrunden
        List<Integer> result = new ArrayList<>(floored);
        for (int i = 0; i < difference; i++) {
            int indexToIncrement = fractionalParts.get(i)[0];
            result.set(indexToIncrement, result.get(indexToIncrement) + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        List<Double> numbers = Arrays.asList(2.2, 2.2, 2.2, 2.2, 2.2);
        List<Integer> rounded = roundPreserveSum(numbers);

        System.out.println("Original: " + numbers);
        System.out.println("Gerundet: " + rounded);

        double originalSum = numbers.stream().mapToDouble(Double::doubleValue).sum();
        int roundedSum = rounded.stream().mapToInt(Integer::intValue).sum();

        System.out.println("Summe vorher: " + originalSum + " → nachher: " + roundedSum);
    }
}

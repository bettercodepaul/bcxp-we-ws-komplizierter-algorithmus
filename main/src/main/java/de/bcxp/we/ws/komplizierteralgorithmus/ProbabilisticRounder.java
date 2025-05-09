package de.bcxp.we.ws.komplizierteralgorithmus;

import java.util.Random;

public class ProbabilisticRounder {
    private final Random random = new Random();

    public int round(double number) {
        int floor = (int) Math.floor(number);
        double fraction = number - floor;

        // Probability of rounding up equals the fractional part
        return random.nextDouble() < fraction ? floor + 1 : floor;
    }
}
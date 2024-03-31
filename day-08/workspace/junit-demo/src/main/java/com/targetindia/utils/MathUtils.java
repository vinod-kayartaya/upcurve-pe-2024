package com.targetindia.utils;

import java.util.ArrayList;
import java.util.List;

public final class MathUtils {

    private MathUtils() {
    }

    public static double sum(String... numbers) {
        if (numbers.length < 2) {
            throw new IllegalArgumentException("at least two inputs expected");
        }

        double total = 0;
        for (var number : numbers) {
            try {
                total += Double.parseDouble(number);
            } catch (NumberFormatException e) {
                // duck the exception
            }
        }

        return total;
    }

    public static long factorial(int number) {
        if (number <= 0) {
            return 1L;
        }

        long f = 1L;
        while (number > 1) {
            f *= number--;
        }
        return f;
    }

}

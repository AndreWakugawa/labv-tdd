package tdd.ex1;

import java.util.Arrays;

public class Triangle {
    public static String classify(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Lados devem ser positivos");
        }

        int[] sides = {a, b, c};
        Arrays.sort(sides);

        if (sides[0] + sides[1] <= sides[2]) {
            throw new IllegalArgumentException("Não forma um triângulo");
        }

        if (sides[0] == sides[1] && sides[1] == sides[2]) {
            return "equilatero";
        } else if (sides[0] == sides[1] || sides[1] == sides[2] || sides[0] == sides[2]) {
            return "isosceles";
        } else {
            return "escaleno";
        }
    }
}
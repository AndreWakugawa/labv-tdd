import org.junit.jupiter.api.Test;
import tdd.Triangle;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    // Triângulo escaleno válido
    @Test
    void validScalene() {
        assertEquals("escaleno", Triangle.classify(3, 4, 5));
    }

    // Triângulo isósceles válido com permutações
    @Test
    void validIsosceles1() {
        assertEquals("isosceles", Triangle.classify(2, 2, 3));
    }

    @Test
    void validIsosceles2() {
        assertEquals("isosceles", Triangle.classify(2, 3, 2));
    }

    @Test
    void validIsosceles3() {
        assertEquals("isosceles", Triangle.classify(3, 2, 2));
    }

    // Triângulo equilátero válido
    @Test
    void validEquilateral() {
        assertEquals("equilatero", Triangle.classify(5, 5, 5));
    }

    // Valor zero
    @Test
    void zeroValue() {
        assertThrows(IllegalArgumentException.class, () -> Triangle.classify(0, 1, 2));
    }

    // Valor negativo
    @Test
    void negativeValue() {
        assertThrows(IllegalArgumentException.class, () -> Triangle.classify(-1, 2, 3));
    }

    // Soma de dois lados igual ao terceiro (permutações)
    @Test
    void sumEqualsThird1() {
        assertThrows(IllegalArgumentException.class, () -> Triangle.classify(1, 2, 3));
    }

    @Test
    void sumEqualsThird2() {
        assertThrows(IllegalArgumentException.class, () -> Triangle.classify(1, 3, 2));
    }

    @Test
    void sumEqualsThird3() {
        assertThrows(IllegalArgumentException.class, () -> Triangle.classify(3, 2, 1));
    }

    // Soma de dois lados menor que o terceiro (permutações)
    @Test
    void sumLessThanThird1() {
        assertThrows(IllegalArgumentException.class, () -> Triangle.classify(1, 2, 4));
    }

    @Test
    void sumLessThanThird2() {
        assertThrows(IllegalArgumentException.class, () -> Triangle.classify(1, 4, 2));
    }

    @Test
    void sumLessThanThird3() {
        assertThrows(IllegalArgumentException.class, () -> Triangle.classify(4, 1, 2));
    }

    // Três valores zero
    @Test
    void allZeros() {
        assertThrows(IllegalArgumentException.class, () -> Triangle.classify(0, 0, 0));
    }
}
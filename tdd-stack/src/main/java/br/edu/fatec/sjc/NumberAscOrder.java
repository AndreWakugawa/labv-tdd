package br.edu.fatec.sjc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberAscOrder<T extends Number & Comparable<T>> {
    private final CustomStack<T> stack;

    public NumberAscOrder(CustomStack<T> stack) {
        if (stack == null) {
            throw new IllegalArgumentException("Stack cannot be null");
        }
        this.stack = stack;
    }

    public List<T> sort() throws StackEmptyException {
        if (stack.isEmpty()) {
            throw new StackEmptyException();
        }

        List<T> numbers = new ArrayList<>();

        while (!stack.isEmpty()) {
            numbers.add(stack.pop());
        }

        Collections.sort(numbers);
        return numbers;
    }
}
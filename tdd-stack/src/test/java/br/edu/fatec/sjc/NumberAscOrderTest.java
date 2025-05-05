package br.edu.fatec.sjc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
public class NumberAscOrderTest {

    @Mock
    private CalculableStrategy<Integer> calculableStrategy;

    private CustomStack<Integer> stack;

    @BeforeEach
    public void setup() {
        lenient().when(calculableStrategy.calculateValue(anyInt()))
                .thenAnswer(invocation -> invocation.getArgument(0));

        stack = new CustomStack<>(6, calculableStrategy);
    }

    @Test
    public void shouldSortMegaSenaNumbers() throws Exception {
        stack.push(23);
        stack.push(5);
        stack.push(42);
        stack.push(16);
        stack.push(8);
        stack.push(34);

        NumberAscOrder<Integer> sorter = new NumberAscOrder<>(stack);
        List<Integer> sorted = sorter.sort();

        assertEquals(List.of(5, 8, 16, 23, 34, 42), sorted);
        assertTrue(stack.isEmpty());
    }

    @Test
    public void shouldThrowExceptionWhenStackIsEmpty() {
        CustomStack<Integer> emptyStack = new CustomStack<>(6, calculableStrategy);
        NumberAscOrder<Integer> sorter = new NumberAscOrder<>(emptyStack);

        StackEmptyException exception = assertThrows(
                StackEmptyException.class,
                sorter::sort
        );
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForNullStack() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new NumberAscOrder<>(null)
        );

        assertEquals("Stack cannot be null", exception.getMessage());
    }
}
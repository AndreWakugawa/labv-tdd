package br.edu.fatec.sjc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NumberAscOrderTest {

    @Mock
    private CustomStack<Integer> stack;

    @Test
    public void shouldSortInAscendingOrder() throws Exception {
        when(stack.isEmpty())
                .thenReturn(false, false, false, false, false, false)
                .thenReturn(true);

        when(stack.pop())
                .thenReturn(23)
                .thenReturn(5)
                .thenReturn(42)
                .thenReturn(16)
                .thenReturn(8)
                .thenReturn(34);

        NumberAscOrder<Integer> sorter = new NumberAscOrder<>(stack);

        List<Integer> sorted = sorter.sort();

        assertEquals(List.of(5, 8, 16, 23, 34, 42), sorted);
        verify(stack, times(6)).pop();
        verify(stack, times(7)).isEmpty();
    }

    @Test
    public void shouldThrowStackEmptyExceptionWhenStackIsEmpty() {
        when(stack.isEmpty()).thenReturn(true);

        NumberAscOrder<Integer> sorter = new NumberAscOrder<>(stack);

        assertThrows(StackEmptyException.class, sorter::sort);
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
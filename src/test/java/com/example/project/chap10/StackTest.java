package com.example.project.chap10;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StackTest {
    @Test
    void testStackOperations() {
        Stack<Integer> stack1 = new Stack<>(5);
        assertThat(stack1.toString()).isEqualTo("[]");
        stack1.push(1);
        assertThat(stack1.toString()).isEqualTo("[1]");
        stack1.push(2);
        stack1.push(100);
        assertThat(stack1.toString()).isEqualTo("[1, 2, 100]");
        assertThat(stack1.pop()).isEqualTo(100);
        assertThat(stack1.toString()).isEqualTo("[1, 2]");
        assertThat(stack1.pop()).isEqualTo(2);
        assertThat(stack1.pop()).isEqualTo(1);
        assertThat(stack1.isEmpty()).isTrue();
        assertThrows(RuntimeException.class, stack1::pop);

        // Check for overflow.
        Stack<Integer> stack2 = new Stack<>(10);
        for (int i = 0; i < 11; i++) {
            if (i == 10) {
                int finalI = i;
                assertThrows(RuntimeException.class, () -> stack2.push(finalI));
            } else {
                stack2.push(i);
            }
        }
        assertThat(stack2.toString()).isEqualTo("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]");
    }
}

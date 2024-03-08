package com.example.project.chap10;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QueueTest {
    @Test
    void testQueueOperations() {
        Queue<Integer> queue1 = new Queue<>(11);
        assertThat(queue1.toString()).isEqualTo("[]");
        for (int i = 100; i < 106; i++) {
            queue1.enqueue(i);
        }
        assertThat(queue1.toString()).isEqualTo("[100, 101, 102, 103, 104, 105]");
        for (int i = 0; i < 6; i++) {
            assertThat(queue1.dequeue()).isEqualTo(i + 100);
        }
        assertThat(queue1.isEmpty()).isTrue();
        queue1.enqueue(15);
        queue1.enqueue(6);
        queue1.enqueue(9);
        queue1.enqueue(8);
        queue1.enqueue(4);
        assertThat(queue1.toString()).isEqualTo("[15, 6, 9, 8, 4]");
        queue1.enqueue(17);
        assertThat(queue1.toString()).isEqualTo("[15, 6, 9, 8, 4, 17]");
        queue1.enqueue(3);
        assertThat(queue1.toString()).isEqualTo("[15, 6, 9, 8, 4, 17, 3]");
        queue1.enqueue(5);
        assertThat(queue1.toString()).isEqualTo("[15, 6, 9, 8, 4, 17, 3, 5]");
        assertThat(queue1.dequeue()).isEqualTo(15);
        assertThat(queue1.toString()).isEqualTo("[6, 9, 8, 4, 17, 3, 5]");
        assertThat(queue1.dequeue()).isEqualTo(6);

        // Empty queue1 and then try to dequeue.
        while (!queue1.isEmpty()) {
            queue1.dequeue();
        }
        assertThrows(RuntimeException.class, queue1::dequeue);

        // Queue overflow.
        Queue<Integer> queue2 = new Queue<>(10);
        for (int i = 0; i < 9; i++) {
            queue2.enqueue(i);
        }
        assertThat(queue2.toString()).isEqualTo("[0, 1, 2, 3, 4, 5, 6, 7, 8]");
        assertThrows(RuntimeException.class, () -> queue2.enqueue(10));
    }
}

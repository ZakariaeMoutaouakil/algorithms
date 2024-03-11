package com.example.project.chap10;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DLLSentinelTest {
    @Test
    void search_existingNode_shouldReturnNode() {
        DLLSentinel<Integer> list = new DLLSentinel<>();
        list.prepend(1);
        list.prepend(2);
        list.prepend(3);

        LinkedListNode<Integer> node = list.search(2);

        assertThat(node).isNotNull();
        assertThat(node.data).isEqualTo(2);
    }

    @Test
    void search_nonExistingNode_shouldReturnNull() {
        DLLSentinel<Integer> list = new DLLSentinel<>();
        list.prepend(1);
        list.prepend(2);
        list.prepend(3);

        LinkedListNode<Integer> node = list.search(4);

        assertThat(node).isNull();
    }

    @Test
    void insert_insertAfterNode_shouldInsertCorrectly() {
        DLLSentinel<Integer> list = new DLLSentinel<>();
        LinkedListNode<Integer> node1 = list.prepend(1);
        LinkedListNode<Integer> node2 = list.insert(3, node1);

        assertThat(list.toString()).isEqualTo("[1, 3]");
        assertThat(node1.next).isEqualTo(node2);
        assertThat(node2.prev).isEqualTo(node1);
    }

    @Test
    void prepend_insertAtHead_shouldInsertCorrectly() {
        DLLSentinel<Integer> list = new DLLSentinel<>();
        list.prepend(1);
        list.prepend(2);

        assertThat(list.toString()).isEqualTo("[2, 1]");
    }

    @Test
    void append_insertAtTail_shouldInsertCorrectly() {
        DLLSentinel<Integer> list = new DLLSentinel<>();
        list.append(1);
        list.append(2);

        assertThat(list.toString()).isEqualTo("[1, 2]");
    }

    @Test
    void delete_existingNode_shouldDeleteCorrectly() {
        DLLSentinel<Integer> list = new DLLSentinel<>();
        LinkedListNode<Integer> node1 = list.prepend(1);
        LinkedListNode<Integer> node2 = list.prepend(2);
        assertThat(list).hasSize(2);

        list.delete(node1);
        System.out.println("List after deletion: " + list);
        System.out.println("Node2.next after deletion: " + node2.next);

        assertThat(list.toString()).isEqualTo("[2]");
        assertThat(list).hasSize(1);
    }

    @Test
    @SuppressWarnings("unchecked")
    void testPrivateFieldAccess() throws NoSuchFieldException, IllegalAccessException {
        // Create an instance of DLLSentinel (for example)
        DLLSentinel<Integer> dllSentinel = new DLLSentinel<>();

        // Use reflection to access the private field "sentinel"
        Class<?> dllSentinelClass = dllSentinel.getClass();
        Field sentinelField = dllSentinelClass.getDeclaredField("sentinel");
        sentinelField.setAccessible(true);

        // Get the value of the private field
        LinkedListNode<Integer> sentinelValue = (LinkedListNode<Integer>) sentinelField.get(dllSentinel);

        // Assert that the value is not null (or perform further assertions as needed)
        assertNotNull(sentinelValue);

        assertThatThrownBy(() -> dllSentinel.delete(sentinelValue))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Cannot delete sentinel.");
    }

    @Test
    void deleteAll_shouldDeleteAllNodes() {
        DLLSentinel<Integer> list = new DLLSentinel<>();
        list.prepend(1);
        list.prepend(2);
        list.prepend(3);

        list.deleteAll();

        assertThat(list.toString()).isEqualTo("[]");
    }

    @Test
    void copy_shouldReturnCopyOfList() {
        DLLSentinel<Integer> list = new DLLSentinel<>();
        list.prepend(1);
        list.prepend(2);
        list.prepend(3);

        DLLSentinel<Integer> copy = list.copy();

        assertThat(copy.toString()).isEqualTo("[3, 2, 1]");
    }

    @Test
    void iterator_shouldIterateOverAllNodes() {
        DLLSentinel<Integer> list = new DLLSentinel<>();
        list.prepend(1);
        list.prepend(2);
        list.prepend(3);

        assertThat(list).containsExactly(3, 2, 1);
    }
}

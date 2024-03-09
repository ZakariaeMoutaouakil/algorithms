package com.example.project.chap10;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.NoSuchElementException;

public class LinkedListTest {

    @Test
    void testLinkedListOperations() {
        // Insert
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList1.prepend(i);
        }
        assertThat(linkedList1.toString()).isEqualTo("[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]");

        // Search
        LinkedListNode<Integer> node = linkedList1.search(5);
        assertThat(node).isNotNull();
        assertThat(node.data).isEqualTo(5);

        // Copy
        LinkedList<Integer> linkedList2 = linkedList1.copy();
        linkedList2.prepend(99);
        assertThat(linkedList1.toString()).isEqualTo("[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]");
        assertThat(linkedList2.toString()).isEqualTo("[99, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0]");

        // Delete
        LinkedList<Integer> linkedList3 = new LinkedList<>();
        linkedList3.prepend(5);
        linkedList3.prepend(6);
        linkedList3.prepend(7);
        LinkedListNode<Integer> x = linkedList3.search(6);
        assertThat(x).isNotNull();
        linkedList3.delete(x);
        assertThat(linkedList3.search(6)).isNull();
        assertThat(linkedList3.toString()).isEqualTo("[7, 5]");
    }

    @Test
    void testSearch() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.prepend(1);
        linkedList.prepend(2);
        linkedList.prepend(3);

        LinkedListNode<Integer> node = linkedList.search(2);
        assertThat(node).isNotNull();
        assertThat(node.data).isEqualTo(2);

        node = linkedList.search(4);
        assertThat(node).isNull();
    }

    @Test
    void testInsert() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.prepend(1);
        linkedList.prepend(3);

        LinkedListNode<Integer> node = linkedList.search(1);
        LinkedListNode<Integer> newNode = linkedList.insert(2, node);
        assertThat(newNode.data).isEqualTo(2);

        assertThat(linkedList.toString()).isEqualTo("[3, 1, 2]");
    }

    @Test
    void testPrepend() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.prepend(1);
        linkedList.prepend(2);

        assertThat(linkedList.toString()).isEqualTo("[2, 1]");
    }

    @Test
    void testDelete() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.prepend(1);
        LinkedListNode<Integer> node = linkedList.prepend(2);
        linkedList.prepend(3);

        linkedList.delete(node);
        assertThat(linkedList.toString()).isEqualTo("[3, 1]");
    }

    @Test
    void testConstructorWithHead() {
        LinkedListNode<Integer> headNode = new LinkedListNode<>(1);
        headNode.next = new LinkedListNode<>(2);
        headNode.next.prev = headNode;

        LinkedList<Integer> linkedList = new LinkedList<>(headNode);

        assertThat(linkedList.toString()).isEqualTo("[1, 2]");
    }

    @Test
    void testDeleteAll() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.prepend(1);
        linkedList.prepend(2);

        linkedList.deleteAll();
        assertThat(linkedList.toString()).isEqualTo("[]");
    }

    @Test
    void testCopy() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.prepend(1);
        linkedList.prepend(2);

        LinkedList<Integer> copyList = linkedList.copy();
        assertThat(copyList.toString()).isEqualTo("[2, 1]");

        // Ensure modifying the original doesn't affect the copy
        linkedList.prepend(3);
        assertThat(copyList.toString()).isEqualTo("[2, 1]");
    }

    @Test
    void testIterator() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.prepend(1);
        linkedList.prepend(2);
        linkedList.prepend(3);

        assertThat(linkedList).containsExactly(3, 2, 1);
    }

    @Test
    void testToString() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.prepend(1);
        linkedList.prepend(2);
        linkedList.prepend(3);

        assertThat(linkedList.toString()).isEqualTo("[3, 2, 1]");
    }

    @Test
    void testIteratorThrowsException() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.prepend(1);

        assertThatThrownBy(() -> {
            LinkedList.LinkedListIterator<Integer> iterator = (LinkedList.LinkedListIterator<Integer>) linkedList.iterator();
            iterator.next();
            iterator.next();
        }).isInstanceOf(NoSuchElementException.class);
    }
}

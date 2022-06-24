package data_structures;

import java.util.Objects;
import java.util.function.Predicate;

class Node<T> {
    T data;
    Node<T> next;
    Node<T> previous;

    Node(T data) {
        this.data = data;
    }

    boolean hasNext() {
        Predicate<Node<T>> hasNext = Objects::nonNull;
        return hasNext.test(next);
    }
}

class LinkedList<T> {
    Node<T> head;

    LinkedList() {
        this.head = null;
    }

    int size() {
        int counter = 0;
        Node<T> current = this.head;
        while (current != null) {
            current = current.next;
            counter++;
        }
        return counter;
    }

    void add(T data) {
        Node<T> toAdd = new Node<>(data);
        if (this.head == null) {
            this.head = toAdd;
        } else {
            Node<T> current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = toAdd;
        }
    }

    void insert(T data, int pos) {
        Node<T> toInsert = new Node<>(data);
        Node<T> current = this.head;
        for (int i = 0; i < pos - 1; i++) {
            current = current.next;
        }
        Node<T> nextNodeAfterInsert = current.next; // node to be hypothetically shifted right
        nextNodeAfterInsert.previous = toInsert; // assign toInsert node before the node to shifted right
        current.next = toInsert; // assign toInsert after current node
        Node<T> next = current.next; //get the inserted node
        next.next = nextNodeAfterInsert; // assign node to be shifted right, to right of inserted node
    }

    void delete(int pos) {
        Node<T> current = this.head;
        for (int i = 0; i < pos - 1; i++) {
            current = current.next;
        }
        Node<T> nextNodeAfterDelete = current.next.next;
        nextNodeAfterDelete.previous = current;
        current.next = nextNodeAfterDelete;
    }

    Node<T> get(int pos) {
        Node<T> current = this.head;
        for (int i = 0; i < pos; i++) {
            current = current.next;
        }
        return current;
    }

    Node<T> reverse() {
        Node<T> current = this.head;
        Node<T> prev = null;
        while (current != null) {
            Node<T> next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        current = prev;
        return current;
    }
}

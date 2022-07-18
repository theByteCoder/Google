package datastructures.linkedlist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class LinkedListsNode<Integer> {
    Integer data;
    LinkedListsNode<Integer> next;

    LinkedListsNode(Integer data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedLists<Integer> {

    LinkedListsNode<Integer> head;

    void add(Integer data) {
        LinkedListsNode<Integer> newNode = new LinkedListsNode<>(data);
        if (this.head == null) {
            this.head = newNode;
        } else {
            LinkedListsNode<Integer> current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    Integer get(int position) throws Exception {
        if (this.head == null) {
            throw new Exception("List is empty");
        } else {
            LinkedListsNode<Integer> current = this.head;
            for (int counter = 0; counter < position; counter++) {
                current = current.next;
            }
            return current.data;
        }
    }

    void createCycle(int sourcePos, int destinationPos) {
        LinkedListsNode<Integer> source = this.head;
        LinkedListsNode<Integer> destination = this.head;
        for (int i = 0; i < sourcePos; i++) {
            source = source.next;
        }
        for (int j = 0; j < destinationPos; j++) {
            destination = destination.next;
        }
        source.next = destination;
    }

    boolean detectIsCyclic() {
        Set<Integer> isVisited = new HashSet<>();
        LinkedListsNode<Integer> curr = this.head;
        while (curr != null) {
            if (isVisited.contains(curr.data)) {
                return true;
            } else {
                isVisited.add(curr.data);
                curr = curr.next;
            }
        }
        return false;
    }

    public ArrayList<Integer> toList() {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedListsNode<Integer> curr = this.head;
        while (curr != null) {
            list.add(curr.data);
            curr = curr.next;
        }
        return list;
    }
}

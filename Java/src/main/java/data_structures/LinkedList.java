package data_structures;

class Node<T> {
    T data;
    Node<T> next;
    Node<T> previous;

    Node(T data) {
        this.data = data;
    }
}

class LinkedList<T> {
    Node<T> head;

    LinkedList() {
        this.head = null;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node<T> current = head;
        while (current != null) {
            res.append(current.data).append(", ");
            current = current.next;
        }
        return res.toString();
    }

    void add(T data) {
        Node<T> toAdd = new Node<>(data);
        if (head == null) {
            head = toAdd;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = toAdd;
        }
    }

    void insert(T data, int pos) {
        Node<T> toInsert = new Node<>(data);
        Node<T> current = head;
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
        Node<T> current = head;
        for (int i = 0; i < pos - 1; i++) {
            current = current.next;
        }
        Node<T> nextNodeAfterDelete = current.next.next;
        nextNodeAfterDelete.previous = current;
        current.next = nextNodeAfterDelete;
    }
}

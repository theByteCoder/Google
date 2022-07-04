package algorithm.recurssion;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class RecursiveMergeSortLinkedList {

    public static void main(String[] args) {
        Node n1 = new Node(0);
        Node n2 = new Node(2);
        Node n3 = new Node(4);
        Node n4 = new Node(6);

        Node n11 = new Node(1);
        Node n22 = new Node(3);
        Node n33 = new Node(5);
        Node n44 = new Node(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        n11.next = n22;
        n22.next = n33;
        n33.next = n44;

        Node merged = sortedMerge(n1, n11);

        while (merged != null) {
            System.out.println(merged.data);
            merged = merged.next;
        }
    }

    private static Node sortedMerge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        if (a.data <= b.data) {
            a.next = sortedMerge(a.next, b);
            return a;
        } else {
            b.next = sortedMerge(a, b.next);
            return b;
        }
    }

}

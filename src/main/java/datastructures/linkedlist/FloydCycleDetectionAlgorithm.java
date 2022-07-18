package datastructures.linkedlist;

public class FloydCycleDetectionAlgorithm {

    public static boolean floydWay(LinkedListsNode<Integer> head) {
        LinkedListsNode<Integer> slow = head;
        LinkedListsNode<Integer> fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}

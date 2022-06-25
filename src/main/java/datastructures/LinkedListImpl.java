package datastructures;

import java.util.logging.Logger;

public class LinkedListImpl {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(LinkedList.class.getName());
        LinkedList<Integer> linkedList = new LinkedList<>();

        // add
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(7);
        linkedList.add(8);
        linkedList.add(10);

        // insert
        linkedList.insert(2, 2);
        linkedList.insert(5, 5);
        linkedList.insert(6, 6);
        linkedList.insert(9, 9);

        // toString
        Node<Integer> listHead = linkedList.head;
        printLinkedList(listHead);

        // delete
        linkedList.delete(2);
        linkedList.delete(3);

        listHead = linkedList.head;
        printLinkedList(listHead);

        // get
        Node<Integer> any = linkedList.get(1);
        String str = String.valueOf(any.data);
        logger.info(str);

        // hasNext
        str = String.valueOf(any.hasNext());
        logger.info(str);

        listHead = linkedList.head;
        printLinkedList(listHead);

        any = linkedList.get(8);
        str = String.valueOf(any.data);
        logger.info(str);

        // hasNext
        str = String.valueOf(any.hasNext());
        logger.info(str);

        // size
        String size = String.valueOf(linkedList.size());
        logger.info(size);

        // reverse
        Node<Integer> reversedListHead = linkedList.reverse();
        String res = printLinkedList(reversedListHead);
        logger.info(res);
    }

    static String printLinkedList(Node<Integer> node) {
        StringBuilder stringBuilder = new StringBuilder();
        while (node != null) {
            String str = String.format("%s ", node.data);
            stringBuilder.append(str);
            node = node.next;
        }
        return stringBuilder.toString();
    }
}

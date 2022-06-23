package data_structures;

import java.util.logging.Logger;

public class LinkedListTest {
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
        String res = linkedList.toString();
        logger.info(res);

        // delete
        linkedList.delete(2);
        linkedList.delete(3);

        res = linkedList.toString();
        logger.info(res);
    }
}

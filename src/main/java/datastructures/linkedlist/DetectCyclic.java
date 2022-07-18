package datastructures.linkedlist;

import java.util.*;

public class DetectCyclic {

    public static void main(String[] args) throws Exception {
        LinkedLists<Integer> linkedList = new LinkedLists<>();
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        System.out.println(Arrays.toString(linkedList.toList().toArray()));

        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.get(3));
        System.out.println(linkedList.get(4));
        System.out.println(linkedList.get(5));

        System.out.println(linkedList.detectIsCyclic());
        System.out.println(FloydCycleDetectionAlgorithm.floydWay(linkedList.head));

        int cyclicSource = 4;
        int cyclicDestination = 2;
        linkedList.createCycle(cyclicSource, cyclicDestination);

        System.out.println(linkedList.get(5));
        // System.out.println(Arrays.toString(linkedList.toList().toArray())); // infinite

        System.out.println(linkedList.detectIsCyclic());
        System.out.println(FloydCycleDetectionAlgorithm.floydWay(linkedList.head));

    }

}

package algorithm.sorting;

import datastructures.tree.BinarySearchTree;
import datastructures.tree.Node;

import java.util.Arrays;

public class TreeSort {

    public static void main(String[] args) {
        int[] arr = {5, 8, 3, 4, 2, 7};

        BinarySearchTree bst = new BinarySearchTree();

        Node root = null;

        for (int i : arr) {
            root = bst.insert(root, i);
        }

        bst.traverseInOrder(root);

        System.out.println(Arrays.toString(bst.inOrderList.toArray()));
    }
}

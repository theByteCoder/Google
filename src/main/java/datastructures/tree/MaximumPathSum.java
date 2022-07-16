package datastructures.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumPathSum {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, -1, -1, 5, 6, 8, -1, -1, -1, 7, -1, -1, 3, -1, -1};

        MaximumPathSum maxPathSum = new MaximumPathSum();
        Node root = maxPathSum.buildTree(arr);
        maxPathSum.traversePreOrder(root);

        System.out.println(Arrays.toString(maxPathSum.preOrderList.toArray()));
        System.out.println(maxPathSum.height(root));
        System.out.println(maxPathSum.maxHeightSum(root));

    }

    private int index = -1;

    private Node buildTree(int[] array) {
        this.index++;
        int data = array[this.index];
        if (data == -1) return null;
        Node newNode = new Node(data);
        newNode.left = buildTree(array);
        newNode.right = buildTree(array);
        return newNode;
    }

    ArrayList<Integer> preOrderList = new ArrayList<>();

    private void traversePreOrder(Node root) {
        if (root == null) {
            preOrderList.add(null);
            return;
        }
        preOrderList.add(root.data);
        traversePreOrder(root.left);
        traversePreOrder(root.right);
    }

    private int height(Node root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }


    private int maxHeightSum(Node root) {
        if (root == null) return 0;
        int leftData = maxHeightSum(root.left);
        int rightData = maxHeightSum(root.right);

        return Math.max(leftData, rightData) + root.data;
    }

}

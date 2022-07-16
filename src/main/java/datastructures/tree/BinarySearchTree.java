package datastructures.tree;

import java.util.ArrayList;

public class BinarySearchTree {

    public ArrayList<Integer> inOrderList;

    public BinarySearchTree() {
        this.inOrderList = new ArrayList<>();
    }

    public Node insert(Node root, int data) {
        if (root == null) return new Node(data);
        if (root.data > data) root.left = insert(root.left, data);
        else if (root.data < data) root.right = insert(root.right, data);
        return root;
    }

    public void traverseInOrder(Node root) {
        if (root == null) return;
        traverseInOrder(root.left);
        this.inOrderList.add(root.data);
        traverseInOrder(root.right);
    }
}

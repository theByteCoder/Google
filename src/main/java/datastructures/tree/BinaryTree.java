package datastructures.tree;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    private int index = -1;

    public Node buildTreePreOrder(int[] nodes) {
        this.index++;
        if (nodes[this.index] == -1) return null;
        Node newNode = new Node(nodes[this.index]);
        newNode.left = buildTreePreOrder(nodes);
        newNode.right = buildTreePreOrder(nodes);
        return newNode;
    }

    public Node buildTreeLevelOrder(int[] nodes, int idx) {
        if (nodes[idx] == -1) return null;
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTreeLevelOrder(nodes, 2 * idx + 1);
        newNode.right = buildTreeLevelOrder(nodes, 2 * idx + 2);
        return newNode;
    }
}

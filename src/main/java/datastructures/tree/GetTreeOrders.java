package datastructures.tree;

import java.util.*;

public class GetTreeOrders {
    public static void main(String[] args) {
        int[] n = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        GetTreeOrders getTreeOrders = new GetTreeOrders();

        Node root = getTreeOrders.buildTree(n);

        getTreeOrders.traverseTreePreOrder(root);
        System.out.println(Arrays.toString(getTreeOrders.preOrderTraversed.toArray()));

        getTreeOrders.traverseTreeInOrder(root);
        System.out.println(Arrays.toString(getTreeOrders.inOrderTraversed.toArray()));

        getTreeOrders.traverseTreePostOrder(root);
        System.out.println(Arrays.toString(getTreeOrders.postOrderTraversed.toArray()));

        getTreeOrders.traverseTreeLevelOrder(root);
        System.out.println(Arrays.toString(getTreeOrders.levelOrderTraversed.toArray()));

        System.out.println(getTreeOrders.countNodes(root));
        System.out.println(getTreeOrders.sumOfNodes(root));
        System.out.println(getTreeOrders.getHeight(root));
    }

    private int index = -1;
    List<Integer> preOrderTraversed = new ArrayList<>();
    List<Integer> inOrderTraversed = new ArrayList<>();
    List<Integer> postOrderTraversed = new ArrayList<>();
    List<Integer> levelOrderTraversed = new ArrayList<>();

    private Node buildTree(int[] nodes) {
        this.index++;
        if (nodes[this.index] == -1) return null;
        Node newNode = new Node(nodes[this.index]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;
    }

    private void traverseTreePreOrder(Node root) {
        if (root != null) {
            preOrderTraversed.add(root.data);
            traverseTreePreOrder(root.left);
            traverseTreePreOrder(root.right);
        }
    }

    private void traverseTreeInOrder(Node root) {
        if (root != null) {
            traverseTreeInOrder(root.left);
            inOrderTraversed.add(root.data);
            traverseTreeInOrder(root.right);
        }
    }

    private void traverseTreePostOrder(Node root) {
        if (root != null) {
            traverseTreePostOrder(root.left);
            traverseTreePostOrder(root.right);
            postOrderTraversed.add(root.data);
        }
    }

    private void traverseTreeLevelOrder(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode != null) {
                levelOrderTraversed.add(currentNode.data);
                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            } else {
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.add(null);
                }
            }
        }
    }

    private int countNodes(Node root) {
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private int sumOfNodes(Node root) {
        if (root == null) return 0;
        return sumOfNodes(root.left) + sumOfNodes(root.right) + root.data;
    }

    private int getHeight(Node root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}

package datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;

class TreeInformation {
    int height;
    int diameter;

    TreeInformation(int height, int diameter) {
        this.height = height;
        this.diameter = diameter;
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

    public static int countNodes(Node root) {
        if (root == null) return 0;
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        return leftCount + rightCount + 1;
    }

    public int sumOfNodes(Node root) {
        if (root == null) return 0;
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        return root.data + leftSum + rightSum;
    }

    public int sumOfNodesAtKthLevel(Node root, int k) {
        if (root == null) return 0;
        int sum = 0;
        int level = 1;
        int isSameLevel = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Node node = queue.poll();
                size--;

                if (level == k) {
                    isSameLevel = 1;
                    sum += node != null ? node.data : 0;
                } else {
                    addToQueue(node, queue);
                }
            }
            level++;
            if (isSameLevel == 1) break;
        }
        return sum;
    }

    private static void addToQueue(Node node, Queue<Node> queue) {
        if (node != null) {
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static int height(Node root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int diameterBruteForce(Node root) {
        if (root == null) return 0;
        int leftDiameter = diameterBruteForce(root.left);
        int rightDiameter = diameterBruteForce(root.right);
        int rootDiameter = height(root.left) + height(root.right) + 1;
        return Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
    }

    public TreeInformation diameterOptimised(Node root) {
        if (root == null) return new TreeInformation(0, 0);
        TreeInformation left = diameterOptimised(root.left);
        TreeInformation right = diameterOptimised(root.right);

        int height = Math.max(left.height, right.height) + 1;

        int rootDiameter = left.height + right.height + 1;
        int diameter = Math.max(rootDiameter, Math.max(left.diameter, right.diameter));

        return new TreeInformation(height, diameter);
    }

    private boolean isTreeIdentical(Node root, Node subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.data == subRoot.data)
            return isTreeIdentical(root.left, subRoot.left) && isTreeIdentical(root.right, subRoot.right);
        return false;
    }

    public boolean isSubTreeOfTree(Node root, Node subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;
        if (subRoot.data == root.data && isTreeIdentical(root, subRoot)) return true;
        return isSubTreeOfTree(root.left, subRoot.left) || isSubTreeOfTree(root.right, subRoot.right);
    }
}

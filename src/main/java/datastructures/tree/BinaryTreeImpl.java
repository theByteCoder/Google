package datastructures.tree;

import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeImpl {

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();

        Node root = tree.buildTreePreOrder(nodes);
        Print.leftView(root);
        System.out.println();

        tree = new BinaryTree();
        root = tree.buildTreePreOrder(nodes);

        tree.buildTreeLevelOrder(nodes, 0);

        Print.preOrder(root);
        System.out.println();
        Print.inOrder(root);
        System.out.println();
        Print.postOrder(root);
        System.out.println();

        tree = new BinaryTree();
        root = tree.buildTreePreOrder(nodes);
        Print.levelOrder(root);

        System.out.println(BinaryTree.countNodes(root));
        System.out.println(tree.sumOfNodes(root));
        System.out.println(BinaryTree.height(root));
        System.out.println(BinaryTree.diameterBruteForce(root));
        System.out.println(tree.diameterOptimised(root).diameter);

        int[] subTreeNodes = {2, 4, -1, -1, 5, -1, -1};
        BinaryTree binarySubTree = new BinaryTree();
        Node subTreeRoot = binarySubTree.buildTreePreOrder(subTreeNodes);

        System.out.println(binarySubTree.isSubTreeOfTree(subTreeRoot, root));
    }

    static class Print {

        private Print() {
        }

        static void preOrder(Node root) {
            if (root == null) {
                System.out.print(-1 + " ");
                return;
            } else System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        static void inOrder(Node root) {
            if (root != null) {
                inOrder(root.left);
                System.out.print(root.data + " ");
                inOrder(root.right);
            } else {
                System.out.print(-1 + " ");
            }
        }

        static void postOrder(Node root) {
            if (root != null) {
                postOrder(root.left);
                postOrder(root.right);
                System.out.print(root.data + " ");
            } else {
                System.out.print(-1 + " ");
            }
        }

        static void levelOrder(Node root) {
            if (root == null) return;
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            queue.add(null);

            while (!queue.isEmpty()) {
                Node currentNode = queue.remove();
                if (currentNode == null) {
                    System.out.println();
                    if (queue.isEmpty()) {
                        break;
                    } else {
                        queue.add(null);
                    }
                } else {
                    System.out.print(currentNode.data + " ");
                    if (currentNode.left != null) {
                        queue.add(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.add(currentNode.right);
                    }
                }
            }
        }

        static void leftView(Node root) {
            while (root != null) {
                System.out.print(root.data + " ");
                if (root.left != null) {
                    root = root.left;
                } else if (root.right != null) {
                    root = root.right;
                } else {
                    root = null;
                }
            }
        }

    }

}

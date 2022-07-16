package datastructures.tree;

public class PrintTreeOrders {
    private int index = -1;

    private Node buildPreOderTree(int[] nodes) {
        this.index++;
        if (nodes[this.index] == -1) return null;
        Node newNode = new Node(nodes[this.index]);
        newNode.left = buildPreOderTree(nodes);
        newNode.right = buildPreOderTree(nodes);
        return newNode;
    }

    public static void main(String[] args) {
        int[] n = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = new PrintTreeOrders().buildPreOderTree(n);
        printPreOrder(root);
        printInOrder(root);
        printPostOrder(root);
    }

    private static void printPreOrder(Node root) {
        if(root == null) {
            System.out.println();
            return;
        }
        System.out.print(root.data + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    private static void printInOrder(Node root) {
        if(root == null) {
            System.out.println();
            return;
        }
        printPreOrder(root.left);
        System.out.print(root.data + " ");
        printPreOrder(root.right);
    }

    private static void printPostOrder(Node root) {
        if(root == null) {
            System.out.println();
            return;
        }
        printPreOrder(root.left);
        printPreOrder(root.right);
        System.out.print(root.data + " ");
    }
}

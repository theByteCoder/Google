package datastructures.tree;

public class LowestCommonAncestor {

    private static int index = -1;

    public static void main(String[] args) {
        int[] n = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = buildPreOrder(n);
        int num1 = 2;
        int num2 = 5;
        int num3 = 10;

        Node lcaRoot = lca(root, num1, num2);
        if (lcaRoot != null) System.out.println(lcaRoot.data);

        lcaRoot = lca(root, num1, num3);
        if (lcaRoot != null) System.out.println(lcaRoot.data);
    }

    private static Node buildPreOrder(int[] nodes) {
        index++;
        if (nodes[index] == -1) return null;
        Node newNode = new Node(nodes[index]);
        newNode.left = buildPreOrder(nodes);
        newNode.right = buildPreOrder(nodes);
        return newNode;
    }

    private static Node lca(Node root, int a, int b) {
        if (root == null) return null;
        if (root.data == a || root.data == b) {
            return root;
        }
        Node leftSubTree = lca(root.left, a, b);
        Node rightSubTree = lca(root.right, a, b);
        if (leftSubTree == null) return rightSubTree;
        if (rightSubTree == null) return leftSubTree;
        return root;
    }
}

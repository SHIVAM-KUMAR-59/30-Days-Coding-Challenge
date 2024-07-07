
// Write a function to check whether a given tree is balanced or not
// Balanced tree is a tree in which the difference between the height of left and right subtrees is not more than one for all nodes.

public class Balanced {

    private Node root;

    public class Node {
        private final int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null)
            return true;
        int diff = height(node.left) - height(node.right);
        if (diff > 1 || diff < -1)
            return false;
        return isBalanced(node.left) && isBalanced(node.right);
    }
}

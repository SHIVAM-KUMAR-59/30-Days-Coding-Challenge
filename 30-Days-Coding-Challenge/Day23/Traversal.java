
// Write a funtcion to perform Pre - Order, In - Order and Post- Order Traversals in a given Binary Tree

public class Traversal {

    // Basic Node class
    private static class Node {
        int value;
        Node left;
        Node right;
    }

    private Node root; // Root Node ( Level 0 )
    // Insert Elements

    // Pre - Order Traversal
    public void PreOrderTraversal() {
        PreOrderTraversal(root);
    }

    private void PreOrderTraversal(Node node) {
        if (node == null)
            return;
        System.out.println(node.value + " ");
        PreOrderTraversal(node.left);
        PreOrderTraversal(node.right);
    }

    // In - Order Traversal
    public void InOrderTraversal() {
        InOrderTraversal(root);
    }

    private void InOrderTraversal(Node node) {
        if (node == null)
            return;
        InOrderTraversal(node.left);
        System.out.println(node.value + " ");
        InOrderTraversal(node.right);
    }

    // Post - Order Traversal
    public void PostOrderTraversal() {
        PostOrderTraversal(root);
    }

    private void PostOrderTraversal(Node node) {
        if (node == null)
            return;
        PostOrderTraversal(node.left);
        PostOrderTraversal(node.right);
        System.out.println(node.value + " ");
    }
}

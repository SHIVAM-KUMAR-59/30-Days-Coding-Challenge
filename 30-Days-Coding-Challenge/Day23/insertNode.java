
// Write a function to Insert nodes in a Binary Tree and a Binary Search Tree\

import java.util.Scanner;

public class insertNode {

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

    public void populate(Scanner scanner) {
        System.out.println("Enter the Root Node Value: ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }

    // Function to insert a new node with given key in a Binary Tree
    private void populate(Scanner scanner, Node node) {
        // Insert Left
        System.out.println("Do you want to enter left of " + node.value + " (Write 'true' for yes and 'false' for no)");
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter the left node value of: " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }
        // Insert Right
        System.out
                .println("Do you want to enter right of " + node.value + " (Write 'true' for yes and 'false' for no)");
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter the left node value of: " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }

    // Function to insert a new node with given key in a Binary Search Tree
    public void insert(int value) {
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (value < node.value) {
            node.left = insert(value, node.left);
        }
        if (value > node.value) {
            node.right = insert(value, node.right);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

}
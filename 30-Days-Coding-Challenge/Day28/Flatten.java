
// 114. Flatten Binary Tree to Linked List ( Medium )
// Question Link-
// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
// Given the root of a binary tree, flatten the tree into a "linked list": The
// "linked list" should use the same TreeNode class where the right child
// pointer points to the next node in the list and the left child pointer is
// always null. The "linked list" should be in the same order as a pre-order
// traversal of the binary tree.

public class Flatten {

    // Basic Tree Node class
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void flatten(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                // Find the rightmost empty element
                TreeNode temp = current.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = current.right;
                current.right = current.left;
                current.left = null;
                current = current.right;
            }
        }
    }

}

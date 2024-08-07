
// 98. Validate Binary Search Tree ( Medium )
// Question Link -
// https://leetcode.com/problems/validate-binary-search-tree/description/
// Given the root of a binary tree, determine if it is a valid binary search
// tree (BST). A valid BST is defined as follows: The left subtree of a node
// contains only nodes with keys less than the node's key. The right subtree of
// a node contains only nodes with keys greater than the node's key. Both the
// left and right subtrees must also be binary search trees.

public class ValidateBST {

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

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

}

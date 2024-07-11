
// 993. Cousins in Binary Tree ( Easy )
// Question Link -
// https://leetcode.com/problems/cousins-in-binary-tree/description/
// Given the root of a binary tree with unique values and the values of two
// different nodes of the tree x and y, return true if the nodes corresponding
// to the values x and y in the tree are cousins, or false otherwise. Two nodes
// of a binary tree are cousins if they have the same depth with different
// parents.Note that in a binary tree, the root node is at the depth 0, and
// children of each depth k node are at the depth k + 1.

public class Cousins {

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

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        TreeNode xx = FindNode(root, x);
        TreeNode yy = FindNode(root, y);
        return (level(root, xx, 0) == level(root, yy, 0)) && (!isSibling(root, xx, yy));
    }

    TreeNode FindNode(TreeNode node, int x) {
        if (node == null) {
            return null;
        }
        if (node.val == x) {
            return node;
        }
        TreeNode left = FindNode(node.left, x);
        if (left != null) {
            return left;
        }
        return FindNode(node.right, x);
    }

    boolean isSibling(TreeNode node, TreeNode x, TreeNode y) {
        if (node == null) {
            return false;
        }
        return ((node.left == x && node.right == y) || (node.left == y && node.right == x) || isSibling(node.left, x, y)
                || isSibling(node.right, x, y));
    }

    int level(TreeNode node, TreeNode x, int lev) {
        if (node == null) {
            return 0;
        }
        if (node == x) {
            return lev;
        }
        int l = level(node.left, x, lev + 1);
        if (l != 0) {
            return l;
        }
        return level(node.right, x, lev + 1);
    }
}

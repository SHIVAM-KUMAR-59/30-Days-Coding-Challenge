
//107. Binary Tree Level Order Traversal II ( Medium )
// Question Link - https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
// Given the root of a binary tree, return the bottom-up level order traversal
// of its nodes' values. (i.e., from left to right, level by level from leaf to root).

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Traversal2 {
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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        levelOrderTraversal(root, lists);
        Collection.reverse(lists);
        return lists;
    }

    void levelOrderTraversal(TreeNode root, List<List<Integer>> lists) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            lists.add(level);
        }
    }
}

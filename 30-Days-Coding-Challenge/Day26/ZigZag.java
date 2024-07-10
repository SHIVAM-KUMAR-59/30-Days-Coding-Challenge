
// 103. Binary Tree Zigzag Level Order Traversal ( Medium )
// Quetion Link -
// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
// Given the root of a binary tree, return the zigzag level order traversal of
// its nodes' values. (i.e., from left to right, then right to left for the next
// level and alternate between).

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigZag {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; ++i) {
                if (!reverse) { // Remove from first and add at the back
                    TreeNode node = queue.pollFirst();
                    level.add(node.val);

                    if (node.left != null) {
                        queue.addLast(node.left);
                    }
                    if (node.right != null) {
                        queue.addLast(node.right);
                    }
                } else { // Remove from back and add at the first
                    TreeNode node = queue.pollLast();
                    level.add(node.val);
                    if (node.right != null) {
                        queue.addFirst(node.right);
                    }
                    if (node.left != null) {
                        queue.addFirst(node.left);
                    }
                }
            }
            reverse = !reverse;
            ans.add(level);
        }
        return ans;
    }

}

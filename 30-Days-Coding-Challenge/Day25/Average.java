
// 637. Average of Levels in Binary Tree ( Easy )
// Question Link - https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
// Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Average {

    // Basic Tree Node class
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double levelSum = 0;

            for (int i = 0; i < levelSize; ++i) {
                TreeNode node = queue.poll();
                levelSum += node.val;

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            levelSum /= levelSize;
            ans.add(levelSum);
        }
        return ans;
    }
}

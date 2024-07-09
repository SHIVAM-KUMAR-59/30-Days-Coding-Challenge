
// Level Order Successor of a Node
// Question Link - https://www.geeksforgeeks.org/level-order-successor-of-a-node-in-binary-tree/
// Given a binary tree and a node in the binary tree, find Levelorder successor of the given node. That is, the node that appears after the given node in the level order traversal of the tree.

import java.util.LinkedList;
import java.util.Queue;

public class Successor {
    // Basic Tree Node class
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode FindSuccessor(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            if (node.val == key) {
                break;
            }
        }
        return queue.peek();
    }

}


// Design an algorithm to serialize and deserialize a binary tree. Serialization is the process of converting a tree to a string representation, and deserialization is the process of converting the string back to the original tree structure.

import java.util.*;

public class Tree {

    // Basic TreeNode class
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "null";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr != null) {
                sb.append(curr.val);
                q.offer(curr.left);
                q.offer(curr.right);
            } else {
                sb.append("null");
            }
            sb.append(",");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "null")
            return null;

        Queue<Integer> vals = asValueQueue(data);
        Queue<TreeNode> nodeQ = new LinkedList<>();
        TreeNode root = new TreeNode(vals.poll());
        nodeQ.offer(root);
        TreeNode curr, left, right;
        while (!vals.isEmpty()) {
            curr = nodeQ.poll();
            Integer l = vals.poll();
            Integer r = vals.poll();
            if (l != null) {
                curr.left = new TreeNode(l);
                nodeQ.offer(curr.left);
            }
            if (r != null) {
                curr.right = new TreeNode(r);
                nodeQ.offer(curr.right);
            }
        }

        return root;
    }

    private Queue<Integer> asValueQueue(String data) {
        Queue<Integer> vals = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : data.toCharArray()) {
            if (ch == ',') {
                if (sb.toString().equals("null")) {
                    vals.offer(null);
                } else {
                    vals.offer(Integer.parseInt(sb.toString()));
                }
                sb = new StringBuilder();
            } else {
                sb.append(ch);
            }
        }
        return vals;
    }

}

// 116. Populating Next Right Pointers in Each Node ( Medium )
// Question Link -
// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
// You are given a perfect binary tree where all leaves are on the same level,
// and every parent has two children. The binary tree has the following
// definition: struct Node { int val; Node *left; Node *right; Node *next; }
// Populate each next pointer to point to its next right node. If there is no
// next right node, the next pointer should be set to NULL. Initially, all next
// pointers are set to NULL.

public class Populating {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {

        if (root == null) {
            return null;
        }
        Node leftMost = root;
        while (leftMost.left != null) {
            Node current = leftMost;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }
}

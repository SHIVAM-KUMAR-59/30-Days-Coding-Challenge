
// 876. Middle of the Linked List ( Medium )
// Question Link - https://leetcode.com/problems/middle-of-the-linked-list/description/
// Given the head of a singly linked list, return the middle node of the linked list. If there are two middle nodes, return the second middle node.

public class MiddleList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }
}

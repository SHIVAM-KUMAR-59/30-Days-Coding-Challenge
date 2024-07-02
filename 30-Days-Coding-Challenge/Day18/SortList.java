
// 148. Sort List ( Medium )
// Question Link - https://leetcode.com/problems/sort-list/description/
// Given the head of a linked list, return the list after sorting it in ascending order.

public class SortList {
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

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        ListNode newHead = merge(left, right);
        return newHead;
    }

    // Function to merge the two sorted Lists
    public static ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (left != null && right != null) {
            if (left.val < right.val) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        if (left != null) {
            temp.next = left;
        }
        if (right != null) {
            temp.next = right;
        }
        return head.next;
    }

    // Function to find mid
    public static ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if (head == null || head.next == null) {
            return head;
        }
        fast = fast.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }

}
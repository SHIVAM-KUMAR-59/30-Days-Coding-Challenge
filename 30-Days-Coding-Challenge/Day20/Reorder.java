
// 143. Reorder List ( Medium )
// Question Link - https://leetcode.com/problems/reorder-list/description/
// You are given the head of a singly linked-list. The list can be represented as: L0 → L1 → … → Ln - 1 → Ln Reorder the list to be on the following form: L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … You may not modify the values in the list's nodes. Only nodes themselves may be changed.

public class Reorder {

    // Definition for singly-linked list.
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

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode HeadFirst = head;
        ListNode mid = MidNode(head);
        ListNode HeadSecond = Reverse(mid);
        // Re-arrange
        while (HeadFirst != null && HeadSecond != null) {
            ListNode temp = HeadFirst.next;
            HeadFirst.next = HeadSecond;
            HeadFirst = temp;
            temp = HeadSecond.next;
            HeadSecond.next = HeadFirst;
            HeadSecond = temp;
        }
        // Setting the next pg tail to null
        if (HeadFirst != null) {
            HeadFirst.next = null;
        }
    }

    // Function to calculate the Middle of the Linked List
    public ListNode MidNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // Function to Reverse the Linked List
    public ListNode Reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;
        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }
}

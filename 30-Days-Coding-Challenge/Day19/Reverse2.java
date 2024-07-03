
// 92. Reverse Linked List II ( Medium )
// Question Link - https://leetcode.com/problems/reverse-linked-list-ii/description/
// Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

public class Reverse2 {

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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        // Skip the first left - 1 nodes
        ListNode present = head;
        ListNode previous = null;
        for (int i = 0; present != null && i < left - 1; i++) {
            previous = present;
            present = present.next;
        }
        ListNode last = previous;
        ListNode NewEnd = present;

        // Reverse between left and right
        ListNode next = present.next;
        for (int i = 0; present != null && i < right - left + 1; i++) {
            present.next = previous;
            previous = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        if (last != null) {
            last.next = previous;
        } else {
            head = previous;
        }
        NewEnd.next = present;
        return head;
    }
}

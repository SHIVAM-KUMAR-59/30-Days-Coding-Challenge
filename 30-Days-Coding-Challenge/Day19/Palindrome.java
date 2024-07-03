
public class Palindrome {

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

    public boolean isPalindrome(ListNode head) {

        ListNode mid = MiddleNode(head);
        ListNode HeadSecond = ReverseList(mid);
        ListNode RereverseHead = HeadSecond;

        // Compare both sides
        while (head != null && HeadSecond != null) {
            if (head.val != HeadSecond.val) {
                break;
            }
            head = head.next;
            HeadSecond = HeadSecond.next;
        }
        ReverseList(RereverseHead);
        return head == null || HeadSecond == null;
    }

    // To find out the middle node
    public ListNode MiddleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // To reverse the List
    public ListNode ReverseList(ListNode head) {
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

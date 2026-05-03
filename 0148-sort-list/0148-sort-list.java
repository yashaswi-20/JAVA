class Solution {

    // Merges two SORTED lists into one sorted list
    ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }

        // Attach the remaining nodes
        curr.next = (left != null) ? left : right;
        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        // Base case: 0 or 1 node is already sorted
        if (head == null || head.next == null) return head;

        // Find the middle — start fast one step ahead to avoid
        // slow == head on a 2-node list (which would cause infinite recursion)
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split into two halves
        ListNode rightHead = slow.next;
        slow.next = null;           // cut the list

        // Recursively sort each half, then merge
        ListNode left  = sortList(head);
        ListNode right = sortList(rightHead);

        return merge(left, right);
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head==null)return null;
        if(head.next==null)return null;
        ListNode slow=head;
        ListNode fast=head;
        int i=0;
        while(fast!=null){
            i++;
            fast=fast.next;
        }
        int half=i/2-1;
        for(int j=0;j<half;j++){
            slow=slow.next;
        }

        slow.next=slow.next.next;
        return head;

    }
}
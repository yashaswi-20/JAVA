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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)return null;
        if(head.next==null)return null;

        int totalNodes=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            totalNodes++;
        }
        int fromStart=totalNodes-n;

        temp=head;
        int start=1;
        if(fromStart==0){
            head=head.next;
        }else{
        while(start!=fromStart && start<fromStart && temp.next!=null){
            temp=temp.next;
            start++;
        }
        temp.next=temp.next.next;
        }
        return head;


    }
}
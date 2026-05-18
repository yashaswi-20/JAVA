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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null)return head;
        ListNode temp=head;
        ListNode slow=temp;
        ListNode fast=head;
        int count=0;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        k=k%count;
        if(k==0) return head;
        int i=0;
        while(fast!=null && i<k ){
            fast=fast.next;
            i++;
        }
       if(fast!=null){
        fast=fast.next;
       }
        while(fast!=null ){
            fast=fast.next;
            slow=slow.next;
        }
        temp=slow.next;
        ListNode curr=temp;
        slow.next=null;
        // ListNode prev=head;

        // while(curr!=null){
        //     ListNode next=curr.next;
        //     curr.next=prev;
        //     prev=curr;
        //     curr=next;

        // }

        while(temp!=null && temp.next!=null){
            temp=temp.next;
        }
        if(temp!=null){
        temp.next=head;
        }
       //System.out.println(temp.val);
        return curr;
    }
}
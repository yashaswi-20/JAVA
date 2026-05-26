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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prevG=dummy;
        while(true){
            ListNode kth=prevG;
            for(int i=0;i<k;i++){
                kth=kth.next;
                if(kth==null){
                    return dummy.next;
                }
            }
            ListNode nextG=kth.next;
            ListNode prev=nextG;
            ListNode curr=prevG.next;
            while(curr!=nextG){
                ListNode next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            ListNode temp=prevG.next;
            prevG.next=kth;
            prevG=temp;
        }
    }
}
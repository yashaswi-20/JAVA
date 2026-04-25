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
    ListNode solve(ListNode curr,ListNode prev){
        if(curr==null){
            return prev;
        }
        ListNode next=curr.next;
        curr.next=prev;
        prev=curr;
         return solve(next,prev);
    }
    public ListNode reverseList(ListNode head) {
        if(head==null)return null;
        ListNode prev=null;
        ListNode next=head.next;
        ListNode res=solve(head,prev);
        return res;
    }
}
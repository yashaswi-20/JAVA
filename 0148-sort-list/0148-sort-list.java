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

    ListNode merge(ListNode left,ListNode right){
      ListNode dummy =new ListNode(0);
      ListNode temp=dummy;

      while(left!=null && right!=null){
        if(left.val<right.val){
            temp.next=left;
            left=left.next;
        }else{
            temp.next=right;
            right=right.next;
        }
        temp=temp.next;
      }
      temp.next = (left != null) ? left : right;
      return dummy.next;
    }


    ListNode split(ListNode head){
        if(head==null || head.next==null)return head;
        
       
     
        ListNode slow=head;
        ListNode fast=head.next.next;           
        while(fast!=null && fast.next!=null){
           
                slow=slow.next;
            
            fast=fast.next.next;

        }
        ListNode rightHead=slow.next;
        slow.next=null;
        ListNode leftNode=split(head);
         
        ListNode rightNode=split(rightHead);
        return merge(leftNode,rightNode);
        
    }
    public ListNode sortList(ListNode head) {
       
        //System.out.println(slow.val);
       return split(head);
      // return head;
    }
}
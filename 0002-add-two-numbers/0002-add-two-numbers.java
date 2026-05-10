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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode res=new ListNode(0);
       ListNode last=res;
       int carry=0;
        ListNode first=l1;
        ListNode second=l2;

       while(first!=null && second!=null){
        int sum =0;
        if(carry>0){
         sum =first.val + second.val+1;
        carry=0;
        }else{
         sum =first.val + second.val;
        }
        //System.out.println(sum);
        int k=0;
        if(sum>9){
            k=sum%10;
            carry=1;
        }else{
            k=sum%10;
        }
        res.next=new ListNode(k);
        res=res.next;
        first=first.next;
        second=second.next;
       }
       ListNode next=null;
       if(first!=null || second!=null){
         next= (first==null)?second : first;
       }

        while(next!=null){
             int sum =0;
        if(carry>0){
         sum =next.val+1;
        carry=0;
        }
        else{
         sum =next.val;
        }
      //  System.out.println(sum);
        int k=0;
        if(sum>9){
            k=sum%10;
            carry=1;
        }else{
            k=sum%10;
        }
        res.next=new ListNode(k);
        res=res.next;
        next=next.next;
        }

        if(carry==1){
            res.next=new ListNode(1);
        }

       return last.next;
    }
}
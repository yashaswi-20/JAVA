class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null)return null;
        if(head.next==null)return head;

        ListNode odd=head;
        ListNode temp1=odd;
        ListNode even=head.next;
        ListNode temp2=even;
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            if(count>1){
                if(count %2==0){
                    odd.next=temp;
                    odd=temp;
                }else{
                    even.next=temp;
                    even=temp;
                }
            }
            count++;
            temp=temp.next;
        }
        even.next=null;
        odd.next=temp2;
        return head;

    }
}
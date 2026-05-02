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
    public ListNode sortList(ListNode head) {
        ListNode temp=head;
        ArrayList<Integer>list=new ArrayList<>();
        while(temp!=null){
            list.add(temp.val);
            temp=temp.next;
        }
        Collections.sort(list,(a,b)-> a-b);
        temp=new ListNode(0,null);
        ListNode temp2=temp;
        for(int i=0;i<list.size();i++){
            temp.next=new ListNode(list.get(i),null);
            temp=temp.next;
        }
        return temp2.next;
    }
}
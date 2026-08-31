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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ArrayList<Integer>list=new ArrayList<>();
        int prev=head.val;
        int curr=-1;
        int next=-1;
        ListNode temp=head;
        if(temp.next!=null){
            curr=temp.next.val;
            temp=temp.next;
        }
        int count=2;
        while(temp!=null){
            if(temp.next!=null){
                if(prev<curr && temp.next.val<curr){
                    list.add(count);
                    
                }
                else if(prev>curr && temp.next.val>curr){
                    list.add(count);
                }

                prev=curr;
                curr=temp.next.val;
                count++;
            }
            
            temp=temp.next;
           

        }

        Collections.sort(list);
        System.out.println(list);
        int res[]=new int[2];
        if(list.size()<2){
            res[0]=-1;
            res[1]=-1;
            return res;
        }
       
        
        int diff2=list.get(list.size()-1) - list.get(0);
        res[1]=diff2;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i+1)-list.get(i)<min){
                min=list.get(i+1)-list.get(i);
            }
        }
        res[0]=min;

        return res;

    }
}
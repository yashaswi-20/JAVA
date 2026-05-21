/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
       
       HashMap<Node,Node> map=new HashMap<>();
       Node temp=head;
       Node dummy=new Node (0);
       Node rem=dummy;
        while(temp!=null){
          Node copy=new Node(temp.val);
          dummy.next=copy;
          map.put(temp,copy);
          temp=temp.next;
          dummy=dummy.next;
      
        }
        temp=head;
        if(rem!=null){
            rem=rem.next;
        }
        Node res=rem;
        while(rem!=null){
            rem.random=map.get(temp.random);
            rem=rem.next;
            temp=temp.next;
        }


     

        return res;
    }
}
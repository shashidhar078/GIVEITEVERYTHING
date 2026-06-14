/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public Node intersectPoint(Node head1, Node head2) {
        // code here
        Node t1=head1;
        Node t2=head2;
        Node temp1=head1;
        Node temp2=head2;
        
        while(t1!=t2)
        {
            if(t1.next==null)
            {
                t1=temp1;        
            }
            else
            {
                t1=t1.next;
            }
            if(t2.next==null)
            {
                t2=temp2;
            }
            else
            {
                t2=t2.next;
            }
        }
        return t1;
    }
}
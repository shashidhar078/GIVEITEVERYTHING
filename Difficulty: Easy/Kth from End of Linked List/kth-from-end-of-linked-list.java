/* Structure of linked list Node
class Node
{
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/
class Solution {
    int getKthFromLast(Node head, int k) {
        // code here
        //lets use slow fast pointer approach over here 
        Node slow=head;
        Node fast=head;
        
        int n=0;
        while(n<k)
        {
            if(fast==null)
            {
                return -1;
            }
            fast=fast.next;
            n++;
        }
        if(fast==null)
        {
            return head.data;
        }
        
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        
        return slow.next.data;
        
    }
}
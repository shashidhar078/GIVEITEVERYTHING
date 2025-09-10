/*
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    public Node segregate(Node head) {
        // code here
        int zero=0;
        int one=0;
        int two=0;
        Node dummy=head;
        while(dummy!=null)
        {
            if(dummy.data==0)
            {
                zero++;
            }
            else if(dummy.data==1)
            {
                one++;
            }
            else if(dummy.data==2)
            {
                two++;
            }
            dummy=dummy.next;
        }
        Node temp=head;
        for(int i=1;i<=zero;i++)
        {
            if(temp!=null)
            {
                temp.data=0;
                temp=temp.next;
            }
        }
        for(int i=1;i<=one;i++)
        {
            if(temp!=null)
            {
                temp.data=1;
                temp=temp.next;
            }
        }
        for(int i=1;i<=two;i++)
        {
            if(temp!=null)
            {
                temp.data=2;
                temp=temp.next;
            }
        }
        return head;
    }
}
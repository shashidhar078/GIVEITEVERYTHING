/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node addOne(Node head) {
        // code here.
    //     head=reverseNode(head);
    //     Node temp=head;
    //     int carry=1;
    //     int sum=0;
    //     while(temp!=null)
    //     {
    //         sum=temp.data+carry;
    //         temp.data=sum%10;
    //         carry=sum/10;
            
    //         if(temp.next==null&&carry>0)
    //         {
    //             temp.next=new Node(carry);
    //             temp=temp.next;
                
    //         }
    //         temp=temp.next;
    //     }
    //     head=reverseNode(head);
    //     return head;
        
        
       
    // }
    // public static Node reverseNode(Node head)
    // {
    //      Node prev=null;
    //     Node curr=head;
    //     Node next;
    //      while(curr!=null)
    //         {
    //             next=curr.next;
    //             curr.next=prev;
    //             prev=curr;
    //             curr=next;
    //         }
    //         head=prev;
    //      return head;
    // }
    //it is taking lot of time 
        Node nonNine=head;
        Node secondToNine=null;
        while(nonNine!=null)
        {
           if(nonNine.data!=9)
           {
               secondToNine=nonNine;
           }
           nonNine=nonNine.next;
            
        }
        if(secondToNine==null)
        {
            Node makeZero=head;
            Node carry=new Node(1);
             carry.next=head;
              head=carry;
             while(makeZero!=null)
            {
                  makeZero.data=0;
                
                makeZero=makeZero.next;
            }
           return head;
        }
        if(secondToNine.next==null)
        {
            secondToNine.data+=1;
            return head;
        }
        secondToNine.data++;
        Node temp=secondToNine.next;
        while(temp!=null)
        {
            temp.data=0;
            temp=temp.next;
        }
        return head;
    }
}
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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp=head;
        ListNode tail=head;
        int len=0;
        ListNode nextNode=null;
        ListNode curr=head;
        if(head==null||head.next==null||k==0)
        {
            return head;
        }
        while(temp!=null)
        {
            len++;
            tail=temp;
            temp=temp.next;
            
        }
        if(k%len==0)
        {
            return head;
        }
        tail.next=head;
        int diff=0;
        k=k%len;
            diff=len-k;
            while((diff-1)>0)
            {
                diff--;
                curr=curr.next;
                
            }
            nextNode=curr.next;
            curr.next=null;
            head=nextNode;
        
       
        return head;
    }
}
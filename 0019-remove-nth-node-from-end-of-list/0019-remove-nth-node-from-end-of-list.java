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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int k=0;
        ListNode temp1=head;
        ListNode ans=head;
        while(temp1!=null)
        {
            temp1=temp1.next;
            k++;
        }
        if(k==1||n==k)
        {
            return head.next;
        }
        int limit=k-n+1;
        ListNode prev=head;
        ListNode curr=head;
        for(int i=1;i<limit;i++)
        {
            curr=curr.next;
            if(i<limit-1)
            {
                prev=prev.next;
            }
        }
        if(curr!=null&&curr.next!=null)
        {
            prev.next=curr.next;
        }
        else
        {
            prev.next=null;
        }

        return ans;
        
    }
}
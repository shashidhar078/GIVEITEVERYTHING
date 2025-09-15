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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode calLen=head;
        ListNode kthNode=head;
        ListNode prevNode=null;
        ListNode nextNode=null;
        ListNode resNode=null;
        int count=0;
        int len=0;
        while(calLen!=null)
        {
            calLen=calLen.next;
            len++;
        }
        while(count+k<=len)
        {
            int i=1;
            while(i<k)
            {
                kthNode=kthNode.next;
                i++;
            }
            nextNode=kthNode.next;
            kthNode.next=null;
            resNode=reverse(temp);
            if(temp==head)
            {
                head=resNode;
            }
            else
            {
                prevNode.next=resNode;
            }
            prevNode=temp;
            temp=nextNode;
            kthNode=temp;
            count+=k;
        }
        if(prevNode!=null)
        {
            prevNode.next=nextNode;
        }
        return head;
    }
    public static ListNode reverse(ListNode head)
    {
        ListNode curr=head;
        ListNode prev=null;
        ListNode next;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}
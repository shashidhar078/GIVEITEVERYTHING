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
    public int pairSum(ListNode head) {
        ListNode p1=head;
        ListNode p2=head;

        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        p2=reverseList(slow);
        // if(slow.next!=null)
        // slow.next=null;

        int sum=0;
        int maxSum=0;
        while(p1!=null&&p2!=null)
        {
            sum=p1.val+p2.val;
            maxSum=Math.max(sum,maxSum);
            p1=p1.next;
            p2=p2.next;
        }
        return maxSum;
    }
    public static ListNode reverseList(ListNode newHead)
    {
        ListNode temp=newHead;
        ListNode front=null;
        ListNode prev=null;

        while(temp!=null)
        {
            front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
    }
}
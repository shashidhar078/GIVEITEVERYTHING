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
    public ListNode sortList(ListNode head) {
        head=merge(head);
        return head;
    }
    public static ListNode getMid(ListNode head)
    {
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static ListNode merge(ListNode head)
    {
        if(head==null||head.next==null)
        {
            return head;
        }
        ListNode mid=getMid(head);
        ListNode rightHead=mid.next;
        mid.next=null;
        ListNode newLeft=merge(head);
        ListNode newRight=merge(rightHead);
        return mergeList(newLeft,newRight);
    }
    public static ListNode mergeList(ListNode left,ListNode right)
    {
        ListNode leftp=left;
        ListNode rightp=right;
        ListNode temp=new ListNode(-1);
        ListNode res=temp;
        while(leftp!=null&&rightp!=null)
        {
            if(leftp.val<rightp.val)
            {
                temp.next=leftp;
                leftp=leftp.next;
                temp=temp.next;
            }
            else
            {
                temp.next=rightp;
                rightp=rightp.next;
                temp=temp.next;
            }
        }
        while(leftp!=null)
        {
            temp.next=leftp;
            leftp=leftp.next;
            temp=temp.next;
        }
        while(rightp!=null)
        {
            temp.next=rightp;
            rightp=rightp.next;
            temp=temp.next;
        }
        return res.next;
    }
}
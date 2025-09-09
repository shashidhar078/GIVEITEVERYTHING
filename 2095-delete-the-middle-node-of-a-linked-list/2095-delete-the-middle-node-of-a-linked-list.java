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
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow;
        ListNode fast;
        slow=head;
        fast=head;
        ListNode prev=head;
        int length=0;
        while(prev!=null)
        {
            length++;
            prev=prev.next;
        }
        if(length==2)
        {
            head.next=null;
            return head;
        }
        else if(length==1)
        {
            return null;
        }
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode inc=head;
        while(inc.next!=slow)
        {
            inc=inc.next;
        }
        inc.next=slow.next;
        return head;
    }
}
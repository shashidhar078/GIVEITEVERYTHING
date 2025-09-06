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
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode prev=null;
        ListNode curr=slow;
        ListNode next;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        ListNode temp1;
        ListNode temp2=head;
        temp1=prev;
        while(temp1!=null)
        {
            if(temp1.val!=temp2.val)
            {
                return false;
            }
            temp1=temp1.next;
            temp2=temp2.next; 
        }
        return true;
    }
}
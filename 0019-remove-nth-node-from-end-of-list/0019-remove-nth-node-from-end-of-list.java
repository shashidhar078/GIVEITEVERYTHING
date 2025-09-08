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
        int length=0;
        ListNode temp=head;
        while(temp!=null)
        {
            length++;
            temp=temp.next;
        }
        if(length==0)
        {
            return null;
        }
        if(n==length)
        {
            return head.next;
        }
        int i=1;
        ListNode nextP=head;
        while(i<length-n)
        {
            nextP=nextP.next;
            i++;
        }
        nextP.next=nextP.next.next;
        return head;
    }
}
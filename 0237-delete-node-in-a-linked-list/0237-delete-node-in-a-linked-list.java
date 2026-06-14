/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode temp=node.next;
        int t=0;
        t=node.val;
        node.val=temp.val;
        temp.val=t;

        node.next=temp.next;
    }
}
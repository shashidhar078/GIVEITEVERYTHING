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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>(
            (a,b)->a.val-b.val
        );

        for(ListNode list:lists)
        {
            if(list!=null)
            {
                pq.add(list);
            }
            
        }
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
         dummy=curr;
        while(!pq.isEmpty())
        {
            ListNode temp=pq.poll();

            curr.next=temp;
            curr=curr.next;

            if(temp.next!=null)
            {
                pq.add(temp.next);
            }
        }
        return dummy.next;
    }
}
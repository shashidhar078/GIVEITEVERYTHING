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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode n1=l1;
            ListNode n2=l2;
            ListNode dummy=new ListNode(0);
            ListNode res=dummy;
            int sum=0;
            int carry=0;
            while(n1!=null&&n2!=null)
            {
                sum=n1.val+n2.val+carry;
                carry=sum/10;
                sum=sum%10;
                res.next=new ListNode(sum);
                res=res.next;
                n1=n1.next;
                n2=n2.next;
            }
            
            while(n1!=null)
            {
                sum=n1.val+carry;
                carry=sum/10;
                 sum=sum%10;
                 res.next=new ListNode(sum);
                res=res.next;
                n1=n1.next;
            }
            
             while(n2!=null)
            {
                sum=n2.val+carry;
                carry=sum/10;
                 sum=sum%10;
                 res.next=new ListNode(sum);
                res=res.next;
                n2=n2.next;
            }
            
            if(carry>0)
            {
                res.next=new ListNode(carry);
                res=res.next;
            }
            return dummy.next;

        }
}
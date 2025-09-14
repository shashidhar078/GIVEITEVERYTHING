/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            //better approach by taking difference 
        //    ListNode t1;
        //    ListNode t2;
        //    t1=headA;
        //    t2=headB;
        //    int length1=0;
        //    int length2=0;
        //    while(t1!=null)
        //    {
        //      length1++;
        //      t1=t1.next;
        //    }
        //    while(t2!=null)
        //    {
        //      length2++;
        //      t2=t2.next;
        //    }
        //    int diff=0;
        //    ListNode temp1=headA;
        //    ListNode temp2=headB;
        //    if(length2>length1)
        //    {
        //      diff=length2-length1;
        //      while(diff>0)
        //      {
        //         diff--;
        //         temp2=temp2.next;
        //      }
        //    }
        //    else
        //    {
        //      diff=length1-length2;
        //      while(diff>0)
        //      {
        //         diff--;
        //         temp1=temp1.next;
        //      }
        //    }
        //    while(temp1!=temp2)
        //    {
        //     temp1=temp1.next;
        //     temp2=temp2.next;
        //    }
        //    if(temp1==null&&temp2==null)
        //    {
        //     return null;
        //    }
        //    ListNode res=temp1;
        //    return res;
        //optimal approach
        ListNode t1=headA;
        ListNode t2=headB;
        ListNode tempHeadA=headA;
        ListNode tempHeadB=headB;
        while(t1!=t2)
        {
            if(t1.next==null&&t2.next==null)
            {
                return null;
            }
            if(t1.next==null)
            {
                t1=tempHeadB;
            }
            else
            {
                t1=t1.next;
            }
            
            if(t2.next==null)
            {
                t2=tempHeadA;
            }
            else
            {
                 t2=t2.next;
            }
           
            
        }
         
        return t1;
    }
}
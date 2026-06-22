/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        //Follow up level order directly 
        Queue<TreeNode> q=new LinkedList<>();
        PriorityQueue<Long> pq=new PriorityQueue<>();
        q.add(root);
        q.add(null);
        int level=0;
        level++;
        long sum=0;
        while(!(q.isEmpty()))
        {
            TreeNode curr=q.remove();
            if(curr==null)
            {
                pq.add(sum);
                if(pq.size()>k)
                {
                    pq.poll();
                }
                if(q.isEmpty())
                {
                    break;
                }
                else
                {
                    q.add(null);
                    sum=0;
                    level++;
                }
            }
            else
            {
                 sum+=curr.val;
                if(curr.left!=null)
                {
                    q.add(curr.left);
                    
                }
                if(curr.right!=null)
                {
                    q.add(curr.right);
                }
            }
        }
        if(k>level)
        {
            return -1;
        }
        long max=0;
        max=pq.peek();
        return max;
    }
}
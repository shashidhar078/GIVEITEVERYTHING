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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null)
        {
            return res;
        }
        q.add(root);
        q.add(null);
        List<Integer> ans=new ArrayList<>();
        int flag=0;
        while(!(q.isEmpty()))
        {
            TreeNode curr=q.remove();
            if(curr==null)
            {
                if(flag==1)
                {
                    Collections.reverse(ans);
                    res.add(ans);
                    flag=0;
                }
                else
                {
                    res.add(ans);
                    flag=1;
                }
                if(q.isEmpty())
                {
                    break;
                }
                else
                {
                    ans=new ArrayList<>();
                    q.add(null);
                }
            }
            else
            {
                ans.add(curr.val);
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
        return res;
    }
}
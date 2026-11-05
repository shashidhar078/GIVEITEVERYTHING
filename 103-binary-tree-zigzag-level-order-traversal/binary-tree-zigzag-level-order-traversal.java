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
        List<List<Integer>> list=new ArrayList<>();
        if(root==null)
        {
            return list;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int flag=0;
        while(!(q.isEmpty()))
        {
            int size=q.size();
             List<Integer> ans=new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode node=q.poll();
                if(node!=null)
                {
                    ans.add(node.val);
                    if(node.left!=null)
                    {
                        q.add(node.left);
                    }
                    if(node.right!=null)
                    {
                        q.add(node.right);
                    }
                }
            }
            if(flag==1)
            {
                Collections.reverse(ans);
            }
            flag=1-flag;
            list.add(ans);
        }
        return list;
    }
}
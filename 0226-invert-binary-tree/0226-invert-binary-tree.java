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
    public TreeNode invertTree(TreeNode root) {
        //i will just traverse reversely using level ordering 
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null)
        {
            return null;
        }
        q.add(root);
        q.add(null);

        while(!(q.isEmpty()))
        {
            TreeNode curr=q.remove();
            if(curr==null)
            {
                if(q.isEmpty())
                {
                    break;
                }
                else
                {
                    q.add(null);
                }
            }
            else
            {
                TreeNode temp=curr.left;
                curr.left=curr.right;
                curr.right=temp;
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
        return root;
    }
}
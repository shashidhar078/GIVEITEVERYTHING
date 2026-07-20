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
    public TreeNode searchBST(TreeNode root, int val) {
        return search(root,val,null);
    }
    public TreeNode search(TreeNode root,int val,TreeNode ans)
    {
        if(root==null)
        {
            return null;
        }
        if(root.val==val)
        {
            return root;
        }
        if(val<root.val)
        {  
             ans=search(root.left,val,ans);
        }
        else
        {  
             ans=search(root.right,val,ans);
        }
        return ans;
    }
}
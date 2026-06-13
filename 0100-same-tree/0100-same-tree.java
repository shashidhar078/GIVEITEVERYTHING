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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean ans=isIdentical(p,q);
        return ans;
    }
    public static boolean isIdentical(TreeNode root,TreeNode subroot)
    {
        if(root==null&&subroot==null)
        {
            return true;
        }
        else if(root==null||subroot==null||root.val!=subroot.val)
        {
            return false;
        }
        if(!(isIdentical(root.left,subroot.left)))
        {
            return false;
        }
        if(!(isIdentical(root.right,subroot.right)))
        {
            return false;
        }
        return true;
    }
}
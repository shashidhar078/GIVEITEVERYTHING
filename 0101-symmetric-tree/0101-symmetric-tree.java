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
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
        {
            return true;
        }
        return symmetricHelp(root.left,root.right);
    }
    public boolean symmetricHelp(TreeNode rootLeft,TreeNode rootRight)
    {
        if(rootLeft==null&&rootRight==null)
        {
            return true;
        }
        if(rootLeft==null||rootRight==null||rootLeft.val!=rootRight.val)
        {
            return false;
        }
        boolean f1=symmetricHelp(rootLeft.left,rootRight.right);
        boolean f2=symmetricHelp(rootLeft.right,rootRight.left);
        return (f1&&f2);
    }
}
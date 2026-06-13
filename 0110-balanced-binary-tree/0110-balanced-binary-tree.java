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
    public boolean isBalanced(TreeNode root) {
        boolean res=checkBalance(root);
        return res;
    }
    public static boolean checkBalance(TreeNode root)
    {   
        if(root==null)
        {
            return true;
        }
        boolean left=checkBalance(root.left);
         int lh=height(root.left);
        boolean right=checkBalance(root.right);
       
        int rh=height(root.right);
        int diff=Math.abs(lh-rh);
        if(left&&right&&diff<=1)
        {
           return true;
        }
        return false;
    }
    public static int height(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int lh=height(root.left);
        int rh=height(root.right);
        return Math.max(lh,rh)+1;
    }
}
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
    static int maxi=0;
    public int maxPathSum(TreeNode root) {
        maxi=Integer.MIN_VALUE;
        int a=maxP(root);
        return maxi;
    }
    public static int maxP(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int lsum=Math.max(0,maxP(root.left));
        int rsum=Math.max(0,maxP(root.right));
        maxi=Math.max(maxi,lsum+rsum+root.val);
        return root.val+Math.max(lsum,rsum);
    }
}
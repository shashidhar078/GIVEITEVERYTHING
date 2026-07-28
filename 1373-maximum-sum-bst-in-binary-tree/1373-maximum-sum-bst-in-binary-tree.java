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
    int ans=0;
    class Info{
        boolean isBst;
        int min;
        int max;
        int sum;

        Info(boolean isBst,int min,int max,int sum)
        {
            this.isBst=isBst;
            this.min=min;
            this.max=max;
            this.sum=sum;
        }
    }
    public int maxSumBST(TreeNode root) {
        solve(root);
        return ans;
    }
    public Info solve(TreeNode root)
    {
        if(root==null)
        {
            return new Info(true,Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }
        Info left=solve(root.left);
        Info right=solve(root.right);
        if(left.isBst&&right.isBst&&root.val>left.max&&root.val<right.min)
        {
            int sum=root.val+left.sum+right.sum;
            ans=Math.max(ans,sum);
            return new Info(true,Math.min(root.val,left.min),Math.max(root.val,right.max),sum);
        }
        return new Info(false,Integer.MIN_VALUE,Integer.MAX_VALUE,0);
    }
}
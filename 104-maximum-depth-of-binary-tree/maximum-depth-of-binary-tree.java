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
    public int maxDepth(TreeNode root) {
        return heightTree(root);
    }
    public static int heightTree(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int left=heightTree(root.left);
        int right=heightTree(root.right);
        int ans=Math.max(left,right)+1;
        return ans;
    }
}
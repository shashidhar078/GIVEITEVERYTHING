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
        int res=findMax(root);
        return res;
    }
    public static int findMax(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int lh=findMax(root.left);
        int rh=findMax(root.right);
        int height=Math.max(lh,rh)+1;
        return height;
    }
}
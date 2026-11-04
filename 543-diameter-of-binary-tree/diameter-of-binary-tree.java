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
    public int diameterOfBinaryTree(TreeNode root) {
        maxi=0;
        int a=diameter(root);       
        return maxi;
    }
    public static int diameter(TreeNode node)
    {
        if(node==null)
        {
            return 0;
        }
        int lh=diameter(node.left);
        int rh=diameter(node.right);
        maxi=Math.max(maxi,lh+rh);
        return 1+Math.max(lh,rh);
    }
}
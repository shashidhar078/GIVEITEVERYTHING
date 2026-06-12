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
    public int diameterOfBinaryTree(TreeNode root) {
        int res=calDiam(root);
        return res;
    }
    public static int calDiam(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int ld=calDiam(root.left);
        int lh=height(root.left);
        int rd=calDiam(root.right);
        int rh=height(root.right);
        int selfDiam=rh+lh;
        return Math.max(selfDiam,Math.max(ld,rd));
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
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
     int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        int res=calHeight(root);
        return diameter;
    }
    //This approach will take O(n2)
    // public static int calDiam(TreeNode root)
    // {
    //     if(root==null)
    //     {
    //         return 0;
    //     }
    //     int ld=calDiam(root.left);
    //     int lh=height(root.left);
    //     int rd=calDiam(root.right);
    //     int rh=height(root.right);
    //     int selfDiam=rh+lh;
    //     return Math.max(selfDiam,Math.max(ld,rd));
    // }
    // public static int height(TreeNode root)
    // {
    //     if(root==null)
    //     {
    //         return 0;
    //     }
    //     int lh=height(root.left);
    //     int rh=height(root.right);
    //     return Math.max(lh,rh)+1;
    // }
   
    //we will calculate directly height and self diam with single dfs pass only 

    public int calHeight(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int lh=calHeight(root.left);
        int rh=calHeight(root.right);
        diameter=Math.max(diameter,lh+rh); //self root diam implicit
        return Math.max(lh,rh)+1;
    }

}
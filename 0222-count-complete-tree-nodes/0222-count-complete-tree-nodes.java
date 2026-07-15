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
    public int countNodes(TreeNode root) {
        return countN(root);
    }
    public static int countN(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int leftcount=countN(root.left);
        int rightcount=countN(root.right);
        return leftcount+rightcount+1;
        
    }
}
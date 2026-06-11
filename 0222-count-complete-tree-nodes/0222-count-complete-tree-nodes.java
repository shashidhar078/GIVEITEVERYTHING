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
        int count=countN(root);
        return count;
    }
    public static int countN(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int lc=countN(root.left);
        int rc=countN(root.right);
        return lc+rc+1;
    }
}
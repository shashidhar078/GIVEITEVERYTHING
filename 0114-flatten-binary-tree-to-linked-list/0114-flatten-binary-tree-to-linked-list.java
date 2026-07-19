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
    TreeNode head=null;
    public void flatten(TreeNode root) {
        
        flatList(root);
    }
    public  void flatList(TreeNode root)
    {
        if(root==null)
        {
            return;
        }

        flatList(root.right);
        flatList(root.left);
        root.right=head;
        root.left=null;
        head=root;
    }
}
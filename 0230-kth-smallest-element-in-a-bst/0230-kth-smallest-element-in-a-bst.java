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
    public int kthSmallest(TreeNode root, int k) {
        //solving it through inorder directly since 
        //inorder of a bst is always sorted in order
        ArrayList<Integer> arr=new ArrayList<>();
        inorder(root,arr);
        int ans=arr.get(k-1);
        return ans;
    }
    public static void inorder(TreeNode root,ArrayList<Integer> arr)
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }
}
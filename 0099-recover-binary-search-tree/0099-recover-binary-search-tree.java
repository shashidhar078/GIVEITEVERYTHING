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
    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> arr=new ArrayList<>();
        inorder(root,arr);
        TreeNode first=null;
        TreeNode second=null;
        for(int i=1;i<arr.size();i++)
        {
            if(arr.get(i-1).val>arr.get(i).val)
            {
                if(first==null)
                {
                    first=arr.get(i-1);
                }
                second=arr.get(i);
            }
        }

        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }
    public static void inorder(TreeNode root,ArrayList<TreeNode> arr)
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left,arr);
        arr.add(root);
        inorder(root.right,arr);
    }
}
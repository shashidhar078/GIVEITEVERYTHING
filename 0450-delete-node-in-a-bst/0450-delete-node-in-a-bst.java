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
    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root,key);
    }
    public TreeNode delete(TreeNode root,int key)
    {
        if(root==null)
        {
            return null;
        }
        if(key<root.val)
        {
            root.left=delete(root.left,key);
        }
        else if(key>root.val)
        {
            root.right=delete(root.right,key);
        }
        else
        {
            if(root.left==null&&root.right==null)
            {
                return null;
            }
            else if(root.left==null)
            {
                return root.right;
            }
            else if(root.right==null)
            {
                return root.left;
            }
            else
            {
                TreeNode ics=findChild(root.right);
                root.val=ics.val;
                root.right=delete(root.right,ics.val);
            }
        }
        return root;
        
    }
    public static TreeNode findChild(TreeNode root)
    {
        while(root.left!=null)
        {
            root=root.left;
        }
        return root;
    }
}
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans=new ArrayList<>();
        StringBuilder str=new StringBuilder();
         allPaths(root,ans,str);
         return ans;
    }
    public void allPaths(TreeNode root,List<String> ans,StringBuilder str)
    {
        if(root==null)
        {
          return;
        }
        int len=str.length();
        str.append(root.val);
        if(root.left==null&&root.right==null)
        {
            ans.add(str.toString());
        }
        else
        {
            str.append("->");
        }
        allPaths(root.left,ans,str);
        allPaths(root.right,ans,str);
        str.setLength(len);
    }
}
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
    int preIndx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            mpp.put(inorder[i],i);
        }
        return build(preorder,inorder,0,inorder.length-1,mpp);
    }
    public  TreeNode build(int[] preorder,int[] inorder,int left,int right,HashMap<Integer,Integer> mpp)
    {
        if(left>right)
        {
            return null;
        }
        TreeNode root=new TreeNode(preorder[preIndx++]);
        // preIndx++;
        int rootIndx=mpp.get(root.val);
        root.left=build(preorder,inorder,left,rootIndx-1,mpp);
        root.right=build(preorder,inorder,rootIndx+1,right,mpp);
        return root;
    }
}
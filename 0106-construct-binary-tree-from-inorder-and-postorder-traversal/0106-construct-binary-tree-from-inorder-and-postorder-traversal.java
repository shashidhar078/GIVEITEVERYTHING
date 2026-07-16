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
    int postIndx=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> mpp=new HashMap<>();
        postIndx=inorder.length-1;
        for(int i=0;i<inorder.length;i++)
        {
            mpp.put(inorder[i],i);
        }
        return build(inorder,postorder,0,inorder.length-1,mpp);
    }
    public TreeNode build(int[] inorder,int[] postorder,int left,int right,HashMap<Integer,Integer> mpp)
    {
        if(left>right)
        {
            return null;
        }
        TreeNode root=new TreeNode(postorder[postIndx--]);
        int rootIndx=mpp.get(root.val);
        root.right=build(inorder,postorder,rootIndx+1,right,mpp);
        root.left=build(inorder,postorder,left,rootIndx-1,mpp);
        
        return root;
    }
}
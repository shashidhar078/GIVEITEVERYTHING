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
    public boolean findTarget(TreeNode root, int k) {
        HashMap<Integer,Integer> mpp=new HashMap<>();
        ArrayList<Integer> arr=new ArrayList<>();
        inorder(root,arr);
        for(int i=0;i<arr.size();i++)
        {

            mpp.put(arr.get(i),i);
        }
        // mpp.put(0,0);
        for(int i=0;i<arr.size();i++)
        {
            int v=k-arr.get(i);
            if(mpp.containsKey(v)&&mpp.get(v)!=i)
            {
                return true;
            }
        }
        return false;
    }
    public void inorder(TreeNode root,ArrayList<Integer> arr)
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
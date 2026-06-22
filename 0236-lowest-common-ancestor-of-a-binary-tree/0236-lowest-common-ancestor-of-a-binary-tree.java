/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        ArrayList<TreeNode> path1=new ArrayList<>();
        ArrayList<TreeNode> path2=new ArrayList<>();
        funcPath1(root,p,path1);
        funcPath1(root,q,path2);
        int i=0;
        for(;i<path1.size() && i<path2.size();i++)
        {
            if(path1.get(i).val!=path2.get(i).val)
            {
                break;
            }
        }
        TreeNode n=path1.get(i-1);
        return n;

    }
    public boolean funcPath1(TreeNode root,TreeNode p,ArrayList<TreeNode> path1)
    {
        if(root==null)
        {
            return false;
        }
        path1.add(root);
        if(root.val==p.val)
        {
            return true;
        }
        boolean f1=funcPath1(root.left,p,path1);
        boolean f2=funcPath1(root.right,p,path1);
        if(f1||f2)
        {
            return true;
        }
        path1.remove(path1.size()-1);
        return false;
    }
    public boolean funcPath2(TreeNode root,TreeNode q,ArrayList<TreeNode> path2)
    {
        if(root==null)
        {
            return false;
        }
        path2.add(root);
        if(root.val==q.val)
        {
            return true;
        }
        boolean f1=funcPath2(root.left,q,path2);
        boolean f2=funcPath2(root.right,q,path2);
        if(f1||f2)
        {
            return true;
        }
        path2.remove(path2.size()-1);
        return false;
    }
}
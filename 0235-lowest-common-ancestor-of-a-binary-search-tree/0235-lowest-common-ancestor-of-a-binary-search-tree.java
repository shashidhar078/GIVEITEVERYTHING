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
    boolean foundP=false;
    boolean foundQ=false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<Integer> arr=new ArrayList<>();
        ArrayList<Integer> res=new ArrayList<>();
        findP(root,p,arr);
        findQ(root,q,res);
       int num=-1;

        for(int i=0;i<arr.size() && i<res.size();i++)
        {
            if(arr.get(i).equals(res.get(i)))
            {
                num=arr.get(i);
            }
            else
            {
                break;
            }
        }
        TreeNode n=new TreeNode(num);
        return n;
    }
    public  void findP(TreeNode root,TreeNode p,ArrayList<Integer> arr)
    {
        if(root==null)
        {
            return;
        }
        arr.add(root.val);
        if(root.val==p.val)
        {
            foundP=true;
            return;
        }
        findP(root.left,p,arr);
        findP(root.right,p,arr);  
        if(!foundP)
        arr.remove(arr.size()-1);
    }
    public  void findQ(TreeNode root,TreeNode q,ArrayList<Integer> res)
    {
        if(root==null)
        {
            return;
        }
        res.add(root.val);
        if(root.val==q.val)
        {
            foundQ=true;
            return;
        }
        findQ(root.left,q,res);
        findQ(root.right,q,res);  
        if(!foundQ)
        res.remove(res.size()-1);
    }
}
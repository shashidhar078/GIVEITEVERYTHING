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
 class Info{
    TreeNode node;
    int level;
    Info(TreeNode node,int level)
    {
        this.node=node;
        this.level=level;
    }
 }
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        //we will go through level ordering itself
        Queue<Info> q=new LinkedList<>();
        List<Integer> arr=new ArrayList<>();
        HashMap<Integer,TreeNode> mpp=new HashMap<>();
        if(root==null)
        {
            return arr;
        }
        q.add(new Info(root,0));
        q.add(null);
        int lastLevel=0;
        while(!(q.isEmpty()))
        {
            Info curr=q.remove();
            if(curr==null)
            {
                if(q.isEmpty())
                {
                    break;
                }
                else
                {
                    q.add(null);
                }
            }
            else
            {
                mpp.put(curr.level,curr.node);
                curr.level++;
                if(curr.node.left!=null)
                {
                    q.add(new Info(curr.node.left,curr.level));
                }
                if(curr.node.right!=null)
                {
                    q.add(new Info(curr.node.right,curr.level));
                }
                lastLevel=curr.level;
            }
        }
        for(int i=0;i<lastLevel;i++)
        {
            TreeNode d=mpp.get(i);
            arr.add(d.val);
        }
        return arr;
    }
}
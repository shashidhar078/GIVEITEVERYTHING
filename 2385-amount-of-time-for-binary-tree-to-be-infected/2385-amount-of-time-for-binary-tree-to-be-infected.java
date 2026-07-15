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
    public int amountOfTime(TreeNode root, int start) {
       HashMap<TreeNode,TreeNode> mpp=new HashMap<>();
       parent_track(root,mpp);
       TreeNode target=findTarget(root,start);
       HashSet<TreeNode> hs=new HashSet<>();
       Queue<TreeNode> q=new LinkedList<>();
       q.add(target);
       hs.add(target);
       int sec=0;
       while(!q.isEmpty())
       {
            int size=q.size();
            boolean burned=false;
            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();
                if(curr.left!=null&&!hs.contains(curr.left))
                {
                    burned=true;
                    q.add(curr.left);
                    hs.add(curr.left);
                }
                if(curr.right!=null&&!hs.contains(curr.right))
                {
                    burned=true;
                    q.add(curr.right);
                    hs.add(curr.right);
                }
                if(mpp.get(curr)!=null&&!hs.contains(mpp.get(curr)))
                {
                    burned=true;
                    q.add(mpp.get(curr));
                    hs.add(mpp.get(curr));
                }
            }
            if(burned==true)
            {
                sec+=1;
            }
       }
       return sec;
    }
    public static void parent_track(TreeNode root,HashMap<TreeNode,TreeNode> mpp)
    {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        mpp.put(root,null);
        while(!q.isEmpty())
        {
            TreeNode curr=q.poll();
            if(curr.left!=null)
            {
                q.add(curr.left);
                mpp.put(curr.left,curr);
            }
            if(curr.right!=null)
            {
                q.add(curr.right);
                mpp.put(curr.right,curr);
            }
        }
    }
    public static TreeNode findTarget(TreeNode root,int start)
    {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode curr=q.poll();
            if(curr.val==start)
            {
                return curr;
            }
            if(curr.left!=null)
            {
                q.add(curr.left);
            }
            if(curr.right!=null)
            {
                q.add(curr.right);
            }
        }
        return null;
    }
}
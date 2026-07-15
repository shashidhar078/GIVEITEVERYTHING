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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> hs=new HashMap<>();
        parent_track(root,hs);
        Queue<TreeNode> q=new LinkedList<>();
        q.add(target);
        HashSet<TreeNode> visited=new HashSet<>();
        List<Integer> arr=new ArrayList<>();
        int distance=0;
        visited.add(target);
        while(!q.isEmpty())
        {
            distance++;
            if(distance>k)
            {
                break;
            }
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();
                if(curr.left!=null&&!visited.contains(curr.left))
                {
                    q.add(curr.left);
                    visited.add(curr.left);
                }
                if(curr.right!=null&&!visited.contains(curr.right))
                {
                    q.add(curr.right);
                    visited.add(curr.right);
                }
                if(hs.get(curr)!=null&&!visited.contains(hs.get(curr)))
                {
                    q.add(hs.get(curr));
                    visited.add(hs.get(curr));
                }
            }
            
        }
        while(!q.isEmpty())
        {
            TreeNode a=q.poll();
            arr.add(a.val);
        }
        return arr;

    }
    public static void parent_track(TreeNode root,HashMap<TreeNode,TreeNode> hs)
    {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        hs.put(root,null);
        while(!q.isEmpty())
        {
            TreeNode curr=q.poll();
            if(curr.left!=null)
            {
                q.add(curr.left);
                hs.put(curr.left,curr);
            }
            if(curr.right!=null)
            {
                q.add(curr.right);
                hs.put(curr.right,curr);
            }
        }
    }
}
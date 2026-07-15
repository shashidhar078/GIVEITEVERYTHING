/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public int minTime(Node root, int target) {
        // code here
        HashMap<Node,Node> hs=new HashMap<>();
        parent_track(root,hs);
        int sec=0;
        Queue<Node> q=new LinkedList<>();
        HashSet<Node> visited=new HashSet<>();
        Node t=findTarget(root,target);
        q.add(t);
        visited.add(t);
        while(!q.isEmpty())
        {
            boolean burned=false;
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                Node curr=q.poll();
                if(curr.left!=null&&!visited.contains(curr.left))
                {
                    burned=true;
                    q.add(curr.left);
                    visited.add(curr.left);
                }
                if(curr.right!=null&&!visited.contains(curr.right))
                {
                    burned=true;
                    q.add(curr.right);
                    visited.add(curr.right);
                }
                if(hs.get(curr)!=null&&!visited.contains(hs.get(curr)))
                {
                    burned=true;
                    q.add(hs.get(curr));
                    visited.add(hs.get(curr));
                }
            }
            if(burned==true)
            {
                sec+=1;
            }
        }
        return sec;
    }
    public static void parent_track(Node root,HashMap<Node,Node> hs)
    {
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        hs.put(root,null);
        while(!q.isEmpty())
        {
            Node curr=q.poll();
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
    public static Node findTarget(Node root,int target)
    {
        if(root==null)
        {
            return null;
        }
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            Node curr=q.poll();
            if(curr.data==target)
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
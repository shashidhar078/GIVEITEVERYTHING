/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/

class Info{
    Node node;
    int level;
    Info(Node node,int level)
    {
        this.node=node;
        this.level=level;
    }
 }

class Solution {
    public ArrayList<Integer> leftView(Node root) {
        // code here
        
    Queue<Info> q=new LinkedList<>();
        ArrayList<Integer> arr=new ArrayList<>();
        HashMap<Integer,Node> mpp=new HashMap<>();
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
                if(!(mpp.containsKey(curr.level))) 
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
            Node d=mpp.get(i);
            arr.add(d.data);
        }
        return arr;
    }
}
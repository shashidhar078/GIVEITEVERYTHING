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
class Info
{
    Node node;
    int hd;
    Info(Node node,int hd)
    {
        this.node=node;
        this.hd=hd;
    }
}
class Solution {
    public ArrayList<Integer> topView(Node root) {
        // code here
        //we require a class to create object to make a blueprint
        //of consisting of node and horizontal distance
        //implement level ordering
        Queue<Info> q=new LinkedList<>();
        HashMap<Integer,Node> mpp=new HashMap<>();
        
        q.add(new Info(root,0));
        q.add(null);
        
        int min=0;
        int max=0;
        
        while(!(q.isEmpty()))
        {
            Info curr=q.remove();
            if(curr==null)
            {
                if(q.isEmpty())
                {
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else
            {
                if(!(mpp.containsKey(curr.hd)))
                {
                    mpp.put(curr.hd,curr.node);
                }
                if(curr.node.left!=null)
                {
                    q.add(new Info(curr.node.left,curr.hd-1));
                    min=Math.min(min,curr.hd-1);
                }
                if(curr.node.right!=null)
                {
                    q.add(new Info(curr.node.right,curr.hd+1));
                    max=Math.max(max,curr.hd+1);
                }
            }
        }
        ArrayList<Integer> arr=new ArrayList<>();
            for(int i=min;i<=max;i++)
            {
                Node d=mpp.get(i);
                arr.add(d.data);
            }
            return arr;
    }
}
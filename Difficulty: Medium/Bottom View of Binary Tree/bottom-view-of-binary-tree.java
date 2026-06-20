/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;

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
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        //override the map everytime thats it 
        //that will be the point of difference of 
        //top view and bottom view
        
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
                else
                {
                    q.add(null);
                }
            }
            else
            {
                mpp.put(curr.hd,curr.node);
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
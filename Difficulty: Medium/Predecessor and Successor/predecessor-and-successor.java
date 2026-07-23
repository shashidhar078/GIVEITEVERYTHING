/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    Node p=null;
    Node s=null;
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
         pred(root,key);
         ArrayList<Node> ans=new ArrayList<>();
         ans.add(p);
         ans.add(s);
         return ans;
    }
    public void pred(Node root,int key)
    {
        if(root==null)
        {
            return;
        }
        if(key<root.data)
        {
            s=root;
            pred(root.left,key);
        }
        if(key>root.data)
        {
            p=root;
            pred(root.right,key);
        }
        if(root.data==key)
        {
            if(root.left!=null)
            p=findLeft(root.left);
            if(root.right!=null)
            s=findRight(root.right);
        }
    }
    public Node findLeft(Node root)
    {
        while(root.right!=null)
        {
            root=root.right;
        }
        return root;
    }
    public Node findRight(Node root)
    {
        while(root.left!=null)
        {
            root=root.left;
        }
        return root;
    }
}
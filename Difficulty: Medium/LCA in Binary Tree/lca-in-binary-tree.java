/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        this.data = val;
        left = right = null;
    }
}
}*/

class Solution {
    Node lca(Node root, int n1, int n2) {
        // code here
        //Lets solve this by optimal approach 
        return commonPath(root,n1,n2);
    }
    public Node commonPath(Node root,int n1,int n2)
    {
        if(root==null)
        {
            return null;
        }
        if(root.data==n1||root.data==n2)
        {
            return root;
        }
        Node left=commonPath(root.left,n1,n2);
        Node right=commonPath(root.right,n1,n2);
        if(left==null)
        {
            return right;
        }
        if(right==null)
        {
            return left;
        }
        return root;
        
    }
}
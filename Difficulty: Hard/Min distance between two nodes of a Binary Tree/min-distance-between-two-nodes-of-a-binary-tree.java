/* A binary tree node
class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public int findDist(Node root, int a, int b) {
        // code here
        Node lca=findLca(root,a,b);
        int d1=findD(lca,a);
        int d2=findD(lca,b);
        return d1+d2;
    }
    public Node findLca(Node root,int a,int b)
    {
        if(root==null)
        {
            return null;
        }
        if(root.data==a||root.data==b)
        {
            return root;
        }
        Node left=findLca(root.left,a,b);
        Node right=findLca(root.right,a,b);
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
    public int findD(Node root,int n)
    {
        if(root==null)
        {
            return -1;
        }
        if(root.data==n)
        {
            return 0;
        }
        int left=findD(root.left,n);
        int right=findD(root.right,n);
        if(left==-1&&right==-1)
        {
            return -1;
        }
        else if(left==-1)
        {
            return right+1;
        }
        else
        {
            return left+1;
        }
        // return left+right;
    }
}
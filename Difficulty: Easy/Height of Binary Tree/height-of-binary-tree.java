/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val)
    {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public int height(Node root) {
           // code here
        int res=findHeight(root);
        return res-1;
    }
    public static int findHeight(Node root)
    {
        if(root==null)
        {
            return 0;
        }
        int lh=findHeight(root.left);
        int rh=findHeight(root.right);
        int height=Math.max(lh,rh)+1;
        return height;
    }
}
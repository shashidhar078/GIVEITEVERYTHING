/*
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

class Solution {
    public boolean isBST(Node root) {
        // code here
        return BST(root,null,null);
    }
    public static boolean BST(Node root,Node min,Node max)
    {
        if(root==null)
        {
            return true;
        }
        if(min!=null&&root.data<=min.data)
        {
            return false;
        }
        if(max!=null&&root.data>=max.data)
        {
            return false;
        }
        return BST(root.left,min,root)&&BST(root.right,root,max);
    }
}
/*
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    void mirror(Node root) {
        // code here
        Vmirror(root);
    }
    public Node Vmirror(Node root)
    {
        if(root==null)
        {
            return null;
        }
        Node lefts=Vmirror(root.left);
        Node rights=Vmirror(root.right);
        root.left=rights;
        root.right=lefts;
        return root;
    }
}
/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}
*/

class Solution {
    static int sumBT(Node root) {
        // code here
        int res=sumOfNodes(root);
        return res;
    }
    public static int sumOfNodes(Node root)
    {
        if(root==null)
        {
            return 0;
        }
        int ls=sumOfNodes(root.left);
        int rs=sumOfNodes(root.right);
        return root.data+ls+rs;
    }
}
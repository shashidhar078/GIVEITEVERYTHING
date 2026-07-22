/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    int max=-1;
    public int findMaxFork(Node root, int k) {
        // code here.
        greatMax(root,k);
        return max;
    }
    public void greatMax(Node root,int k)
    {
        if(root==null)
        {
            return;
        }
        greatMax(root.left,k);
        if(root.data<=k)
        {
            max=Math.max(max,root.data);
        }
        greatMax(root.right,k);
    }
}
/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        left = right = null;
    }
} */

class Solution {
    int num=Integer.MAX_VALUE;
    int findCeil(Node root, int x) {
        // code here
        ceil(root,x);
        if(num==Integer.MAX_VALUE)
        {
            return -1;
        }
        return num;
    }
    public void ceil(Node root,int x)
    {
        if(root==null)
        {
            return;
        }
        if(root.data==x)
        {
            num=x;
            return;
        }
        if(root.data>x)
        {
            num=Math.min(num,root.data);
        }
        if(x<root.data)
        {
            ceil(root.left,x);
        }
        if(x>root.data)
        {
            ceil(root.right,x);
        }
    }
}
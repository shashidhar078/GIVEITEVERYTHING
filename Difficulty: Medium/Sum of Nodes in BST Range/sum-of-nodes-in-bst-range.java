/*
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
    int sum=0;
    public int nodeSum(Node root, int l, int r) {
        // code here
        solve(root,l,r);
        return sum;
    }
    public void solve(Node root,int l,int r)
    {
        if(root==null)
        {
            return;
        }
        if(root.data>=l&&root.data<=r)
        {
            solve(root.left,l,r);
            sum+=root.data;
            solve(root.right,l,r);
        }
        else if(root.data<=l)
        {
            solve(root.right,l,r);
        }
        else
        {
            solve(root.left,l,r);
        }
    }
}

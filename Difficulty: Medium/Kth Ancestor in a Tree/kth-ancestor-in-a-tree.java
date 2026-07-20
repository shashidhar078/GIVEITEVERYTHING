/* Definition for Node
class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int val) {
        data = val;
        left = right = null;
    }
};
*/

class Solution {
    int ans=-1;
    public int kthAncestor(Node root, int k, int node) {
        // code here
        KNode(root,k,node);
        return ans;
    }
    public int KNode(Node root,int k,int node)
    {
        if(root==null)
        {
            return -1;
        }
        if(root.data==node)
        {
            return 0;
        }
        int left=KNode(root.left,k,node);
        int right=KNode(root.right,k,node);
        if(left==-1&&right==-1)
        {
            return -1;
        }
        int max=Math.max(left,right);
        if(max+1==k)
        {
            ans=root.data;
        }
        return max+1;
    }
}
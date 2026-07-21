/* Structure of BST tree Node
class Node {
    public int data;
    public Node left;
    public Node right;
    public Node(int val) {
        data = val;
        left = right = null;
    }
};*/
class Solution {
    public ArrayList<Integer> nodesInRange(Node root, int low, int high) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        nodes(ans,root,low,high);
        return ans;
    }
    public static void nodes(ArrayList<Integer> ans,Node root,int low,int high)
    {
        if(root==null)
        {
            return;
        }
        if(root.data>=low&&root.data<=high)
        {
            nodes(ans,root.left,low,high);
            ans.add(root.data);
            nodes(ans,root.right,low,high);
        }
        else if(root.data<low)
        {
            nodes(ans,root.right,low,high);
            // ans.add(root.data);
        }
        else
        {
            nodes(ans,root.left,low,high);
            // ans.add(root.data);
        }
    }
}
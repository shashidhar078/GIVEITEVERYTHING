/* Node Structure
class Node{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
} */
class Solution {
    public boolean isSumProperty(Node root) {
        //  code here
        return sumProperty(root);
    }
    public static boolean sumProperty(Node root)
    {
        if(root==null)
        {
            return true;
        }
        if(root.left == null && root.right == null)
        {
            return true;
        }
        int childVal=0;
        if(root.left!=null)
        {
            childVal+=root.left.data;
        }
        if(root.right!=null)
        {
            childVal+=root.right.data;
        }
        if(childVal!=root.data)
        {
            return false;
        }
        boolean left=sumProperty(root.left);
        boolean right=sumProperty(root.right);
        return (left&&right);
    }
}
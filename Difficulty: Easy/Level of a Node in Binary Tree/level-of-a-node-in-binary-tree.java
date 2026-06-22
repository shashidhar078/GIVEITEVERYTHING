class Solution {
    /* Returns level of given data value */
    int getLevel(Node node, int data) {
        // Write your code here
        //Lets try this problem using recursion instead of BFS
        return searchForkey(node,data,1);
    }
    public int searchForkey(Node node,int data,int level)
    {
        if(node==null)
        {
            return 0;
        }
        if(node.data==data)
        {
            return level;
        }
        int left=searchForkey(node.left,data,level+1);
        if(left!=0)
        {
            return left;
        }
        int right=searchForkey(node.right,data,level+1);
         if(right!=0)
        {
            return right;
        }
        return 0;
    }
}
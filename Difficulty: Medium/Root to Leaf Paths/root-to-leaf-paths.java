/* Definition for Node
class Node
{
    int data;
    Node left;
    Node right;
    Node(int val)
    {
        this.data = val;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public ArrayList<ArrayList<Integer>> paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> res=new ArrayList<>();
        addPath(root,ans,res);
        return ans;
    }
    public static void addPath(Node root,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> res)
    {
        if(root==null)
        {
            return;
        }
        res.add(root.data);
        if(root.left==null&&root.right==null)
        {
            ans.add(new ArrayList<>(res));
        }
        addPath(root.left,ans,res);
        addPath(root.right,ans,res);
        res.remove(res.size()-1);
    }
}
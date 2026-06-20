/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Info
 {
    TreeNode node;
    int row;
    int col;
    Info(TreeNode node,int row,int col)
    {
        this.node=node;
        this.row=row;
        this.col=col;
    }
 }
 class Pair{
    int row;
    int val;
    Pair(int row,int val)
    {
        this.row=row;
        this.val=val;
    }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Info> q=new LinkedList<>();
        HashMap<Integer,ArrayList<Pair>> mpp=new HashMap<>();

        q.add(new Info(root,0,0));
        q.add(null);
        int min=0;
        int max=0;

        while(!(q.isEmpty()))
        {
            Info curr=q.remove();
            if(curr==null)
            {
                if(q.isEmpty())
                {
                    break;
                }
                else
                {
                    q.add(null);
                }
            }
            else
            {
                int row=curr.row;
                int col=curr.col;

                if(!(mpp.containsKey(col)))
                {
                    mpp.put(col,new ArrayList<>());
                }
                mpp.get(col).add(new Pair(row,curr.node.val));
                if(curr.node.left!=null)
                {
                    q.add(new Info(curr.node.left,row+1,col-1));
                    min=Math.min(min,col-1);
                }
                if(curr.node.right!=null)
                {
                    q.add(new Info(curr.node.right,row+1,col+1));
                    max=Math.max(max,col+1);
                }
            }
        }
        List<List<Integer>> res=new ArrayList<>();
         for(int col = min; col <= max; col++) {

            List<Pair> list = mpp.get(col);

            Collections.sort(list, (a, b)-> {
                if(a.row == b.row) {
                    return a.val - b.val;
                }
                return a.row - b.row;
            });

            List<Integer> currList = new ArrayList<>();

            for(Pair p : list) {
                currList.add(p.val);
            }   //adding values of type Pair here 
            res.add(currList);
        }
        return res;
    }
}
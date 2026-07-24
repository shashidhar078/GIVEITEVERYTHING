/*
class Node {
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    public ArrayList<Integer> inOrder(Node root) {
        // code here
        ArrayList<Integer> inorder=new ArrayList<>();
        
        Node curr=root;
        
        while(curr!=null)
        {
            if(curr.left==null)
            {
                inorder.add(curr.data);
                curr=curr.right;
            }
            else
            {
                Node next=curr.left;
                while(next.right!=null&&next.right!=curr)
                {
                    next=next.right;
                }
                
                if(next.right==null)
                {
                    next.right=curr;
                    curr=curr.left;
                    
                }
                else
                {
                    next.right=null;
                    inorder.add(curr.data);
                    curr=curr.right;
                }
            }
        }
        return inorder;
    }
}
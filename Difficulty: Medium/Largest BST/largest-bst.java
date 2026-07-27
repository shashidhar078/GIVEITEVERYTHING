/* class Node {
    int data;
    Node left, right;
    public Node(int d) {
     data = d;
     left = right = null;
   }
} */

class Solution {

    static class Info {
        int min;
        int max;
        int size;

        Info(int min,int max,int size) {
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }


    static int largestBst(Node root) {

        return solve(root).size;
    }


    static Info solve(Node root) {

        if(root == null) {
            return new Info(
                Integer.MAX_VALUE,
                Integer.MIN_VALUE,
                0
            );
        }


        Info left = solve(root.left);
        Info right = solve(root.right);


        // current node forms BST
        if(root.data > left.max &&
           root.data < right.min)
        {

            return new Info(
                Math.min(root.data,left.min),
                Math.max(root.data,right.max),
                left.size + right.size + 1
            );
        }


        // invalid BST
        return new Info(
            Integer.MIN_VALUE,
            Integer.MAX_VALUE,
            Math.max(left.size,right.size)
        );
    }

}
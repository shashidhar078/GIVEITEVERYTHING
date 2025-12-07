class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        ArrayList<Integer>  ans=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        for(int i=n-1;i>=0;i--)
        {
            if(st.isEmpty())
            {
                ans.add(-1);
            }
            else if(!st.isEmpty()&&st.peek()>arr[i])
            {
                ans.add(st.peek());
            }
            else if(!st.isEmpty()&&st.peek()<=arr[i])
            {
                while(!st.isEmpty()&&st.peek()<=arr[i])
                {
                    st.pop();
                }
                if(st.isEmpty())
                {
                    ans.add(-1);
                }
                else
                {
                    ans.add(st.peek());
                }
            }
            st.push(arr[i]);
        }
        Collections.reverse(ans);
        return ans;
    }
}
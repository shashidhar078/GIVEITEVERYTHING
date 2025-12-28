class Solution {
    static ArrayList<Integer> preGreaterEle(int[] arr) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<arr.length;i++)
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
        return ans;
    }
}
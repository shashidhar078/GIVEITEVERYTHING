class Solution {
    public int[] nextGreaterElements(int[] nums) {
        ArrayList<Integer> arr=new ArrayList<>();
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        int ridx=0;
        for(int i=2*n-1;i>=0;i--)
        {
            ridx=i%n;
            if(st.isEmpty()&&i<n)
            {
                arr.add(-1);
            }
            else if(!st.isEmpty()&&st.peek()>nums[ridx])
            {
                if(i<n)
                {
                    arr.add(st.peek());
                } 
            }
            else if(!st.isEmpty()&&st.peek()<=nums[ridx])
            {
                while(!st.isEmpty()&&st.peek()<=nums[ridx])
                {
                    st.pop();
                }
                if(st.isEmpty()&&i<n)
                {
                    arr.add(-1);
                }
                else
                {
                   if(i<n)
                    {
                        arr.add(st.peek());
                    } 
                }
            }
            st.push(nums[ridx]);
        }
            Collections.reverse(arr);
            int[] res = new int[arr.size()];
            for(int i = 0; i < arr.size(); i++) {
                res[i] = arr.get(i);
                 
            }
            return res;
    } 
       
    }
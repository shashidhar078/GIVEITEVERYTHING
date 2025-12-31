class Solution {
    public int sumSubarrayMins(int[] arr) {
        // long total=0;
        // int mod=1_000_000_007;
        // for(int i=0;i<arr.length;i++)
        // {
        //     int minNum=Integer.MAX_VALUE;
        //     // total+=arr[i];
        //     for(int j=i;j<arr.length;j++)
        //     {
        //         minNum=Math.min(minNum,arr[j]);
        //         total=(total+minNum)%mod;
        //     }
            
        // }
        // return (int)total;
        //optimal solution 
        int n=arr.length;
        int[] prev=new int[n];
        int[] next=new int[n];
        next=nextEle(arr);
        prev=prevEle(arr);
        long total=0;
        int mod=1_000_000_007;
        int left=0;
        int right=0;
        for(int i=0;i<arr.length;i++)
        {
            left=i-prev[i];
            right=next[i]-i;
            total = (total + (long) left * right * arr[i]) % mod;
        }
        return (int)total;
        
    }
    public static int[] nextEle(int[] arr)
    {
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int[] ans=new int[n];
        for(int i=arr.length-1;i>=0;i--)
        {
           while(!st.isEmpty()&&arr[st.peek()]>=arr[i])
           {
                st.pop();
           }
           ans[i]=st.isEmpty()?n:st.peek();
           st.push(i);
        }
        return ans;
    }
    public static int[] prevEle(int[] arr)
    {
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int[] ans=new int[n];
        for(int i=0;i<arr.length;i++)
        {
           while(!st.isEmpty()&&arr[st.peek()]>arr[i])
           {
                st.pop();
           }
           ans[i]=st.isEmpty()?-1:st.peek();
           st.push(i);
        }
        return ans;
    }
}
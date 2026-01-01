class Solution {
    public long subArrayRanges(int[] nums) {
        long maxNum=subMax(nums);
        long minNum=subMin(nums);
        return maxNum-minNum;
    }
    public static long subMin(int[] arr)
    {    
        int n=arr.length;
        int[] prev=new int[n];
        int[] next=new int[n];
        next=nextEle(arr);
        prev=prevEle(arr);
        long total=0;
        int left=0;
        int right=0;
        for(int i=0;i<arr.length;i++)
        {
            left=i-prev[i];
            right=next[i]-i;
            total = (total + (long) left * right * arr[i]);
        }
        return total;
        
    }
    public static long subMax(int[] arr)
    {    
        int n=arr.length;
        int[] prev=new int[n];
        int[] next=new int[n];
        next=nextEleGreater(arr);
        prev=prevEleGreater(arr);
        long total=0;
        int left=0;
        int right=0;
        for(int i=0;i<arr.length;i++)
        {
            left=i-prev[i];
            right=next[i]-i;
            total = (total + (long) left * right * arr[i]);
        }
        return total;
        
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
    public static int[] nextEleGreater(int[] arr)
    {
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int[] ans=new int[n];
        for(int i=arr.length-1;i>=0;i--)
        {
           while(!st.isEmpty()&&arr[st.peek()]<=arr[i])
           {
                st.pop();
           }
           ans[i]=st.isEmpty()?n:st.peek();
           st.push(i);
        }
        return ans;
    }
    public static int[] prevEleGreater(int[] arr)
    {
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int[] ans=new int[n];
        for(int i=0;i<arr.length;i++)
        {
           while(!st.isEmpty()&&arr[st.peek()]<arr[i])
           {
                st.pop();
           }
           ans[i]=st.isEmpty()?-1:st.peek();
           st.push(i);
        }
        return ans;
    }
    
}

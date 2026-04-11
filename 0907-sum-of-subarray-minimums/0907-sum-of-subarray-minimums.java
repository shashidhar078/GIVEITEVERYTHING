class Solution {
    public int sumSubarrayMins(int[] arr) {
        //check for frequencies and calculate next smaller element and previous smaller element

        int[] next=new int[arr.length];
        int[] prev=new int[arr.length];
        next=funNext(arr);
        prev=funPrev(arr);
        int mod = (int)1e9 + 7;
        int right=0;
        int left=0;
        long freq=0;
        long val=0;
        long total=0;
        for(int i=0;i<arr.length;i++)
        {
            right=next[i]-i;
            left=i-prev[i];

            freq=right*left*1L;

            val=(freq*arr[i])%mod;

            total=((total+val)%mod);
        }
        return (int)total;
    }
    public static int[] funNext(int[] arr)
    {
        Stack<Integer> st=new Stack<>();
        int[] next=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--)
        {
            if(st.isEmpty())
            {
                next[i]=arr.length;
            }
            else if(!st.isEmpty()&&arr[st.peek()]<arr[i])
            {
                next[i]=st.peek();
            }
            else if(!st.isEmpty()&&arr[st.peek()]>=arr[i])
            {
                while(!st.isEmpty()&&arr[st.peek()]>=arr[i])
                {
                    st.pop();
                }
                if(st.isEmpty())
                {
                    next[i]=arr.length;
                }
                else
                {
                    next[i]=st.peek();
                }
            }
            st.push(i);
        }
        return next;
    }
    public static int[] funPrev(int[] arr)
    {
        Stack<Integer> st=new Stack<>();
        int[] prev=new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            if(st.isEmpty())
            {
                prev[i]=-1;
            }
            else if(!st.isEmpty()&&arr[st.peek()]<=arr[i])
            {
                prev[i]=st.peek();
            }
            else if(!st.isEmpty()&&arr[st.peek()]>arr[i])
            {
                while(!st.isEmpty()&&arr[st.peek()]>arr[i])
                {
                    st.pop();
                }
                if(st.isEmpty())
                {
                    prev[i]=-1;
                }
                else
                {
                    prev[i]=st.peek();
                }
            }
            st.push(i);
        }
        return prev;
    }
}
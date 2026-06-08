// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        //by extreme brute force solution 
        // int sum=0;
        // int maxLen=0;
        // for(int i=0;i<arr.length;i++)
        // {
        //     sum=0;
        //     for(int j=i;j<arr.length;i++)
        //     {
        //         sum+=arr[j];
        //         if(sum==k)
        //         {
        //             maxLen=Math.max(maxLen,j-i+1);
        //         }
        //     }
        // }
        // return maxLen;
        
        //lets optimize this using prefix array sum 
        //we are going to do a reverse engineering kind of stuff
        //this solution is the optimal for both positives and negatives
        
        int sum=0;
        int maxLen=0;
        HashMap<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(sum==k)
            {
                maxLen=Math.max(maxLen,i+1);
            }
            if(mpp.containsKey(sum-k))
            {
                int j=mpp.get(sum-k);
                maxLen=Math.max(maxLen,i-j);
            }
            if(!mpp.containsKey(sum))
            {
                mpp.put(sum,i);
            }
        }
        return maxLen;
    }
}

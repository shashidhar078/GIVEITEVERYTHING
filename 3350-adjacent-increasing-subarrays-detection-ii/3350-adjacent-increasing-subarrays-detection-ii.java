class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n=nums.size();
        int[] right=new int[n];
        int[] left=new int[n];
        int maxk=0;
        left[0]=1;
        for(int i=1;i<n-1;i++)
        {
            if(nums.get(i)>nums.get(i-1))
            {
                left[i]=left[i-1]+1;
            }
            else
            {
                left[i]=1;
            }
        }
        right[n-1]=1;
        for(int i=n-2;i>=0;i--)
        {
            if(nums.get(i)<nums.get(i+1))
            {
                right[i]=right[i+1]+1;
            }
            else
            {
                right[i]=1;
            }
        }
        for(int i=0;i<n-1;i++)
        {
            int mink=Math.min(left[i],right[i+1]);
            maxk=Math.max(maxk,mink);
        }
        return maxk;
    }
}
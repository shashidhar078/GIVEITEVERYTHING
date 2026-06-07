class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if(nums.length==0)
        {
            return 0;
        }
        int lastsmall=nums[0];
         int len=1;   
         int maxLen=1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==nums[i-1])
            {
                continue;
            }
            if(lastsmall==nums[i]-1)
            {
                len=len+1;
                lastsmall=nums[i];
            }
            else
            {
                len=1;
                 lastsmall=nums[i];
            }
            maxLen=Math.max(len,maxLen);
        }
        return maxLen;
    }
}
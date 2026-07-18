class Solution {
    public int findGCD(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        int j=2;
        int ans=1;
        while(j<=max)
        {
            if((min%j==0)&&(max%j==0))
            {
                ans=j;
            }
            j++;
        }
        return ans;
    }
}
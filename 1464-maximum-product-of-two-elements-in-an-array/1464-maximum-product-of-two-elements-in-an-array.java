class Solution {
    public int maxProduct(int[] nums) {
        int prod=1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                prod=1;
                prod*=(nums[i]-1)*(nums[j]-1);
                max=Math.max(prod,max);
            }
        }

        return max;
    }
}
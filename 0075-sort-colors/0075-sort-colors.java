class Solution {
    public void sortColors(int[] nums) {
        int z=0;
        int o=0;
        int t=0;


        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                z++;
            }
            else if(nums[i]==1)
            {
                o++;
            }
            else
            {
                t++;
            }
        }
        int idx=0;
        while(z>0)
        {
            nums[idx]=0;
            z--;
            idx++;
        }
        while(o>0)
        {
            nums[idx]=1;
            o--;
            idx++;
        }
        while(t>0)
        {
            nums[idx]=2;
            t--;
            idx++;
        }
    }
}
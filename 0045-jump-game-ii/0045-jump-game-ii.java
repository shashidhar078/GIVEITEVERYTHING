class Solution {
    public int jump(int[] nums) {
        int maxIndx=0;
        int count=0;
        int curr=0;
        for(int i=0;i<nums.length-1;i++)
        {

           maxIndx=Math.max(maxIndx,i+nums[i]);
           if(i==curr)
           {
             count++;
             curr=maxIndx;
           }
            
        }
        return count;
    
    }
}
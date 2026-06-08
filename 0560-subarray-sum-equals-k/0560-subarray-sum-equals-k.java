class Solution {
    public int subarraySum(int[] nums, int k) {
         int sum=0;
        int count=0;
        HashMap<Integer,Integer> mpp=new HashMap<>();
        mpp.put(0,1);
        int rem=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            rem=sum-k;
            count+=mpp.getOrDefault(rem,0);
            mpp.put(sum,mpp.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
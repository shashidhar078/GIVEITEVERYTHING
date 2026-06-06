class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> arr=new ArrayList<>();
        HashMap<Integer,Integer> hs=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
        
            hs.put(nums[i],hs.getOrDefault(nums[i],0)+1);
        }
        int n=nums.length;
        for(int i=0;i<nums.length;i++)
        {
            if(hs.get(nums[i])>(n/3))
            {
                if(!(arr.contains(nums[i])))
                {
                    arr.add(nums[i]);
                }
            }
        }
        return arr;
    }
}
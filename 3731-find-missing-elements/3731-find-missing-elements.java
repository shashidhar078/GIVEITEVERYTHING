class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int min=nums[0];
        int max=nums[nums.length-1];

        ArrayList<Integer> arr=new ArrayList<>();

        int k=0;
        for(int i=min;i<=max;i++)
        {
            if(nums[k]==i)
            {
                k++;
            }
            else
            {
                arr.add(i);
            }
        }
        return arr;
    }
}
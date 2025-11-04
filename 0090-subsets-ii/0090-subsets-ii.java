class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        subSets(0,ans,res,nums,n);
        return ans;
    }
    public static void subSets(int i,List<List<Integer>> ans,List<Integer> res,int[] nums,int n)
    {
        ans.add(new ArrayList<>(res));
        for(int j=i;j<nums.length;j++)
        {
            if(j>i&&nums[j]==nums[j-1]) continue;
            res.add(nums[j]);
            subSets(j+1,ans,res,nums,n);
            res.remove(res.size()-1);
        }
    }
}
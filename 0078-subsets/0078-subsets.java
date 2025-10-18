class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        int n=nums.length;
         List<Integer> ds=new ArrayList<>();
        return printSub(0,ans,nums,n,ds);
    }
    public static List<List<Integer>> printSub(int i,List<List<Integer>> ans,int[] nums,int n,List<Integer> ds)
    {
       
        if(i==n)
        {
            ans.add(new ArrayList<>(ds));
            return ans;
        }
        ds.add(nums[i]);
        printSub(i+1,ans,nums,n,ds);
        ds.remove(ds.size()-1);
        printSub(i+1,ans,nums,n,ds);
        return ans;
    }
}
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums=new int[9];
        int j=1;
        for(int i=0;i<nums.length;i++)
        {
            nums[i]=j++;
        }
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ls=new ArrayList<>();
        comboNum(n,nums,ans,ls,0,k);
        return ans;
    }
    public static void comboNum(int n,int[] nums,List<List<Integer>> ans,List<Integer> ls,int index,int k)
    {
        if(index==nums.length)
        {
            if(n==0)
            {
                if(ls.size()==k)
                {
                    ans.add(new ArrayList<>(ls));
                }
            }
            return;
        }
        if(nums[index]<=n)
        {
            ls.add(nums[index]);
            comboNum(n-nums[index],nums,ans,ls,index+1,k);
            ls.remove(ls.size()-1);
        }
        comboNum(n,nums,ans,ls,index+1,k);
    }
}
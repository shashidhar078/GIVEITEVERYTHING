class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        int arr[]=new int[9];
        int j=1;
        for(int i=0;i<arr.length;i++)
        {   
            
            arr[i]=j++;
        }
        int l=arr.length;
        funSub(0,n,ans,res,k,l,arr);
        return ans;
    }
    public static void funSub(int i,int target,List<List<Integer>> ans,List<Integer> res,int k,int l,int[] nums)
    {
        
        if(res.size()==k)
        {
            if(target==0)
            {
                ans.add(new ArrayList<>(res));
            }
            return;
        }
         if(i==l)
        {
            return;
        }
        if(nums[i]<=target)
        {
            res.add(nums[i]);
            funSub(i+1,target-nums[i],ans,res,k,l,nums);
            res.remove(res.size()-1);
        }
        funSub(i+1,target,ans,res,k,l,nums);
    }
}
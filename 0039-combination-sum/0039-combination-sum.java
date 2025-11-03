class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        int n=candidates.length;
        funCombo(0,candidates,ans,res,n,target);
        return ans;
    }
    public static void funCombo(int i,int[] arr,List<List<Integer>> ans,List<Integer> res,int n,int target)
    {
        if(i==n)
        { 
            if(target==0)
            {
                ans.add(new ArrayList<>(res));
            }
            
            return;
        }
        if(arr[i]<=target)
        {
             res.add(arr[i]);
            funCombo(i,arr,ans,res,n,target-arr[i]);
             res.remove(res.size()-1);
        }
        //  funCombo(i+1,arr,ans,res,n,target);
      
        
        funCombo(i+1,arr,ans,res,n,target);

    }
}
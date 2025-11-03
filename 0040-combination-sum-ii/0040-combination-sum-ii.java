class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        int n=candidates.length;
        Arrays.sort(candidates);  
        funCombo(0,ans,res,candidates,n,target);
        return ans;
    }
    // public static void funCombo(int i,List<List<Integer>> ans,List<Integer> res,int[] arr,int n,int target,HashSet<List<Integer>> mpp)
    // {
    //     if(i==n)
    //     {
    //         if(target==0)
    //         {   
    //             List<Integer> copy=new ArrayList<>(res);
    //             if(!mpp.contains(copy))
    //             {
    //                 ans.add(copy);
    //                 mpp.add(copy);
    //             }
                
    //         }
    //         return;
    //     }
    //     if(arr[i]<=target)
    //     {
    //         res.add(arr[i]);
    //         funCombo(i+1,ans,res,arr,n,target-arr[i],mpp);
    //         res.remove(res.size()-1);
    //     }
    //     funCombo(i+1,ans,res,arr,n,target,mpp);
    // }
     public static void funCombo(int i,List<List<Integer>> ans,List<Integer> res,int[] arr,int n,int target)
    {
       
            if(target==0)
            {   
                List<Integer> copy=new ArrayList<>(res);
                    ans.add(copy);
                return;
            }
            
        for(int j=i;j<arr.length;j++)
        {
            if(j>i&&arr[j]==arr[j-1]) continue;
            if(arr[j]>target) break;

            res.add(arr[j]);
             funCombo(j+1,ans,res,arr,n,target-arr[j]);
             res.remove(res.size()-1);

        }
       
    }
}
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ls=new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(ans,ls,candidates,target,0,0);
        return ans;
    }
    public static void combinationSum(List<List<Integer>> ans,List<Integer> ls,int[] arr,int target,int index,int sum)
    {
        
            if(sum==target)
            {
                ans.add(new ArrayList<>(ls));
            }
           
        for(int j=index;j<arr.length;j++)
        {
            if(j>index&&arr[j]==arr[j-1])
            {
                continue;
            }
            if (sum + arr[j] > target) break;
            ls.add(arr[j]);
            sum=sum+arr[j];
            combinationSum(ans,ls,arr,target,j+1,sum);
            sum=sum-arr[j];
            ls.remove(ls.size()-1);
        }
        
    } 
}
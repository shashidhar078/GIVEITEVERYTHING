class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ls=new ArrayList<>();
        generateCombo(ans,ls,candidates,target,0);
        return ans;
    }
    public static void generateCombo(List<List<Integer>> ans,List<Integer> ls,int[] arr,int target,int index)
    {
        if(index==arr.length)
        {
            if(target==0)
            {
                ans.add(new ArrayList<>(ls));
            }
            return;
        }

        if(arr[index]<=target)
        {
            ls.add(arr[index]);
            target=target-arr[index];
            generateCombo(ans,ls,arr,target,index);
            ls.remove(ls.size()-1);
            target=target+arr[index];
        }
        generateCombo(ans,ls,arr,target,index+1);
    }
}
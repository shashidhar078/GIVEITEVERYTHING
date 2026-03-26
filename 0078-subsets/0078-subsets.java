class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ls=new ArrayList<>();
        generateSubset(ans,ls,nums,0);
        return ans;
    }
    public static void generateSubset(List<List<Integer>> ans,List<Integer> ls,int[] arr,int index)
    {
        if(index==arr.length)
        {
            ans.add(new ArrayList<>(ls));
        }
        if(index<arr.length)
        {
            ls.add(arr[index]);
            generateSubset(ans,ls,arr,index+1);
            ls.remove(ls.size()-1);
            generateSubset(ans,ls,arr,index+1);
        }
        
    }
}
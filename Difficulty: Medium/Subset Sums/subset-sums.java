// User function Template for Java//User function Template for Java
class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        int n=arr.length;
        subSet(0,0,arr,ans,n);
        Collections.sort(ans);
        return ans;
    }
    public static void subSet(int i,int sum,int[] arr,ArrayList<Integer> ans,int n)
    {
        if(i==n)
        {
            ans.add(sum);
            return;
        }
        subSet(i+1,sum+arr[i],arr,ans,n);
        subSet(i+1,sum,arr,ans,n);
    }
}
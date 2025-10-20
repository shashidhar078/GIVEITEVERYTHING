class Solution {
    public boolean isSorted(int[] arr) {
        // code here
        int i=0;
        int n=arr.length;
        return checkSort(i,n,arr);
    }
    public static boolean checkSort(int i,int n,int[] arr)
    {
        if(i==arr.length-1)
        {
            return true;
        }
        if(arr[i]>arr[i+1])
        {
            return false;
        }
        return checkSort(i+1,n,arr);
    }
}
class Solution {
    public int search(int arr[], int x) {
        // code here
        int i=0;
        int n=arr.length;
        return funSearch(i,n,arr,x);
    }
    public static int funSearch(int i,int n,int[] arr,int x)
    {
        if(i==n)
        {
            return -1;
        }
        if(arr[i]==x)
        {
            return i;
        }
        return funSearch(i+1,n,arr,x);
    }
}

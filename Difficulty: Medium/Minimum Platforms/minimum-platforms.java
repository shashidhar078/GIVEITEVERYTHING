class Solution {
    public int minPlatform(int arr[], int dep[]) {
        //  code here
        int count=0;
        int i=0;
        int j=0;
        
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int res=0;
        while(i<arr.length&&j<dep.length)
        {
            if(arr[i]<=dep[j])
            {
                count++;
                i++;
            }
            else if(arr[i]>dep[j])
            {
                count--;
                j++;
            }
            res=Math.max(res,count);
        }
        return res;
    }
}

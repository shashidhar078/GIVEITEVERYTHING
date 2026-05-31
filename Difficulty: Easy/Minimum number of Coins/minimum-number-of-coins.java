class Solution {
    public int findMin(int n) {
        // code here
        int[] curr={10,5,2,1};
        
        int count=0;
        
        for(int i=0;i<curr.length;i++)
        {
            while(curr[i]<=n)
            {
                count++;
                n=n-curr[i];
            }
        }
        return count;
    }
}

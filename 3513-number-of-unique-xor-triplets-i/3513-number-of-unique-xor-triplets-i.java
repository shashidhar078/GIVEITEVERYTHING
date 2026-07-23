class Solution {
    public int uniqueXorTriplets(int[] nums) {
        
        int n=nums.length;
        if(n<=2)
        {
            return n;
        }
        
        int bits=0;
        int temp=n;

        while(temp>0)
        {
            bits++;
            temp/=2;
        }

        return (int)Math.pow(2,bits);
    }
}
class Solution {
    static final long mod = 1000000007;
    public int countGoodNumbers(long n) {
        long ans=1;
        long evenCount=(n+1)/2;
        long oddCount=n/2;
        ans=(pow(5,evenCount)*pow(4,oddCount))%mod;
        return (int)ans;
    }
    public static long pow(long x,long y)
    {
        long res=1;
        x=x%mod;
        while(y>0)
        {
            if(y%2==0)
            {
                x=(x*x)%mod;
                y=y/2;
            }
            else 
            {
                res=(res*x)%mod;
                y=y-1;
            }
        }
        return res;
    }
}
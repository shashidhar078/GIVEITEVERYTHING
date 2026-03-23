class Solution {
    public double myPow(double x, int n) {
        long num=(long)n;
        return power(x,num);
    }
    public static double power(double x,long n)
    {
        if(n<0)
        {
            return 1.0/myPower(x,-n);
        }
        return myPower(x,n);
    }
    public static double myPower(double x,long n)
    {
        if(n==0)
        {
            return 1;
        }
        if(n==1)
        {
            return x;
        }
        if(n%2==0)
        {
            return myPower(x*x,n/2);
        }
        return x*myPower(x,n-1);
    }
}
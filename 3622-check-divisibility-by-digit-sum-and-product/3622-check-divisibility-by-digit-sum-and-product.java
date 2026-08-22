class Solution {
    public boolean checkDivisibility(int n) {
        int sum=findSum(n);
        int product=findProduct(n);
        int res=sum+product;
        if(n%res==0)
        {
            return true;
        }
        return false;
    }
    public static int findSum(int n)
    {
        int sum=0;
        while(n>0)
        {
            int i=n%10;
            sum+=i;
            n=n/10;
        }
        return sum;
    }
    public static int findProduct(int n)
    {
        int prod=1;
         while(n>0)
        {
            int i=n%10;
            prod*=i;
            n=n/10;
        }
        return prod;
    }
}
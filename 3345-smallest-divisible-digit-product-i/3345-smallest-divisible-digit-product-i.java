class Solution {
    public int smallestNumber(int n, int t) {
        
        for(int i=n;i<=100;i++)
        {
            if(func(i,t))
            {
                return i;
            }
        }
        return -1;
    }
    public static boolean func(int n,int t)
    {
        int v=1;
        while(n>0)
        {
            int j=n%10;
            v=v*j;
            n=n/10;
        }
        if(v%t==0){
            return true;
        }
        return false;
    }
}
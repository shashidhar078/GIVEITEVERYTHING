class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans=new int[spells.length];
        Arrays.sort(potions);
        for(int i=0;i<spells.length;i++)
        {
            int val=arrayBinary(spells,potions,success,i);
            System.out.println(val);
            int res=potions.length-val;
            ans[i]=res;

        }
        return ans;
    }
    public static int arrayBinary(int[] spells,int[] potions,long success,int i)
    {
         int l=0;
            int r=potions.length-1;
            int indx=potions.length;
         while(l<=r)
            {
                int mid=l+(r-l)/2;
                if((long)spells[i]*potions[mid]>=success)
                {
                    indx=mid;
                    r=mid-1;
                }
                else
                {
                    l=mid+1;
                }
            }
            return indx;
    }
}
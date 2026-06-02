class Solution {
    public int maxProfit(int[] prices) {
        int small=prices[0];
        int max=0;
        for(int i=1;i<prices.length;i++)
        {
            if(small>prices[i])
            {
                small=prices[i];
            }
            int profit=prices[i]-small;
            max=Math.max(max,profit);
        }
        return max;
    }
}
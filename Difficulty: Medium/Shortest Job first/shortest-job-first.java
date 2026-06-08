class Solution {
    static int solve(int bt[]) {
        // code here
        Arrays.sort(bt);
        int wTime=0;
        int avg=0;
        int total=0;
        for(int i=1;i<bt.length;i++)
        {
            wTime+=bt[i-1];
            total+=wTime;
        }
        
        avg=(total/bt.length);
        
        return avg;
    }
}

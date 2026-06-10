class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=0;

        int count=0;

        Arrays.sort(intervals,Comparator.comparingInt(o->o[1]));
        int[] curr=intervals[0];
        for(int i=1;i<intervals.length;i++)
        {
            if(curr[1]>intervals[i][0])
            {
                count++;
            }
            else
            {
                curr=intervals[i];
            }
        }
        return count;
    }
}
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        int i=0;

        ArrayList<int[]> res=new ArrayList<>();

    
            while(i<n&&intervals[i][1]<newInterval[0])
            {
                res.add(intervals[i]);
                i=i+1;
            }
            while(i<n&&intervals[i][0]<=newInterval[1])
            {
                newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
                newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
                i=i+1;
            }
            res.add(newInterval);
            while(i<n)
            {
                res.add(intervals[i]);
                i=i+1;
            }
            
        int[][] ans=new int[res.size()][2];

        for(int j=0;j<ans.length;j++)
        {
            ans[j]=res.get(j);
        }
        return ans;
    }
}
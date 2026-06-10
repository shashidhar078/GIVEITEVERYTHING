class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        

        ArrayList<int[]> res=new ArrayList<>();
        Arrays.sort(intervals,Comparator.comparingInt(o->o[0]));
        
        int[] curr=intervals[0];
        for(int i=1;i<intervals.length;i++)
        {
            if(curr[1]>=intervals[i][0])
            {
                curr[1]=Math.max(curr[1],intervals[i][1]);
            }
            else
            {
                res.add(curr);
                curr=intervals[i];
            }
        }
        res.add(curr);
        int[][] ans=new int[res.size()][2];
        for(int j=0;j<ans.length;j++)
        {
            ans[j]=res.get(j);
        }
        return ans;
    }
}
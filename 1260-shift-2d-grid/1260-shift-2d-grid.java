class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        int m=grid.length;
        int n=grid[0].length;
        while(k>0)
        {
            int[][] res=new int[m][n];
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(i==m-1&&j==n-1)
                    {
                        res[0][0]=grid[i][j];
                    }
                    else if(j==n-1)
                    {
                        res[i+1][0]=grid[i][n-1];
                    }
                    else
                    {
                        res[i][j+1]=grid[i][j];
                    }
                }
                
            }
            grid=res;
            k--;
        }
        for(int i=0;i<m;i++)
        {
            List<Integer> row=new ArrayList<>();
            for(int j=0;j<n;j++)
            {
                row.add(grid[i][j]);
            }
            ans.add(row);
        }
        return ans;
    }
}
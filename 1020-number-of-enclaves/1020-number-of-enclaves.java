class Solution {
    int[] drow={-1,0,1,0};
    int[] dcol={0,-1,0,1};
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] visited=new int[m][n];

        int count=0;
        for(int i=0;i<n;i++)
        {
            if(grid[0][i]==1)
            dfs(0,i,visited,grid);
        }
        for(int i=0;i<m;i++)
        {
            if(grid[i][0]==1)
            dfs(i,0,visited,grid);
        }
        for(int i=0;i<n;i++)
        {
            if(grid[m-1][i]==1)
            dfs(m-1,i,visited,grid);
        }
        for(int i=0;i<m;i++)
        {
            if(grid[i][n-1]==1)
            dfs(i,n-1,visited,grid);
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(visited[i][j]!=1&&grid[i][j]==1)
                {
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int row,int col,int[][] visited,int[][] grid)
    {
        visited[row][col]=1;

        for(int i=0;i<4;i++)
        {
            int r=row+drow[i];
            int c=col+dcol[i];

            if(r<0||r>=grid.length||c<0||c>=grid[0].length)
            {
                continue;
            }
            if(visited[r][c]!=1&&grid[r][c]==1)
            {
                dfs(r,c,visited,grid);
            }
        }
    }
}
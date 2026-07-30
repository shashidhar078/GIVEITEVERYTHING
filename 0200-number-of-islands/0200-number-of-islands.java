class Solution {
    public int numIslands(char[][] grid) {
        
        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    dfs(i,j,grid);
                    count++;
                }
                
            }
        }
        return count;
    }
    public static void dfs(int row,int col,char[][] grid)
    {
        int rowsize=grid.length;
        int colsize=grid[0].length;

        if(row<0||row>=rowsize||col<0||col>=colsize||grid[row][col]=='0')
        {
            return;
        }

        grid[row][col]='0';

        dfs(row-1,col,grid);
        dfs(row+1,col,grid);
        dfs(row,col+1,grid);
        dfs(row,col-1,grid);
    }
}
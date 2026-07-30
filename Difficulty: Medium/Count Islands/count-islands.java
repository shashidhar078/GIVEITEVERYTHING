class Solution {
    public int countIslands(char[][] grid) {
        // Code here
        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='L')
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
        int rowSize=grid.length;
        int colSize=grid[0].length;
        
        if(row<0||row>=rowSize||col<0||col>=colSize||grid[row][col]=='W')
        {
            return;
        }
        
        grid[row][col]='W';
        
        dfs(row+1,col,grid);
        dfs(row-1,col,grid);
        dfs(row,col+1,grid);
        dfs(row,col-1,grid);
        
        dfs(row - 1, col - 1, grid);
        dfs(row - 1, col + 1, grid);
        dfs(row + 1, col - 1, grid);
        dfs(row + 1, col + 1, grid);
    }
}
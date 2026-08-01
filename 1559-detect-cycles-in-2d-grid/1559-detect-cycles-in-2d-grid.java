class Solution {
    int[] drow={-1,0,1,0};
    int[] dcol={0,-1,0,1};
    public boolean containsCycle(char[][] grid) {
        
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                visited[i][j]=false;
            }
        }
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(visited[i][j]==false)
                {
                    if(detect(i,j,-1,-1,visited,grid))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public  boolean detect(int row,int col,int parrow,int parcol,boolean[][] visited,char[][] grid)
    {
        visited[row][col]=true;
        
        for(int i=0;i<4;i++)
        {
            int nr=row+drow[i];
            int nc=col+dcol[i];
            if(nr<0||nr>=grid.length||nc<0||nc>=grid[0].length)
            {
                continue;
            }
            if(grid[nr][nc]!=grid[row][col])
            {
                continue;
            }
            if(!visited[nr][nc])
            {
                if(detect(nr,nc,row,col,visited,grid))
                {
                    return true;
                }
            }
            else if(nr!=parrow||nc!=parcol)
            {
                return true;
            }
        }
        return false;
    }
}
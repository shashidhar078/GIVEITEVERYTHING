class Solution {
    class Pair
    {
        int row;
        int col;
        int t;
        Pair(int row,int col,int t)
        {
            this.row=row;
            this.col=col;
            this.t=t;
        }
    }
    public int orangesRotting(int[][] grid) {
        int cntFresh=0;
        int row=grid.length;
        int col=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        int[][] visited=new int[row][col];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                {
                  q.add(new Pair(i,j,0));
                  visited[i][j]=1;
                }
                else
                {
                    visited[i][j]=0;
                }
                if(grid[i][j]==1)
                {
                    cntFresh++;
                }
            }
        }

        int time=0;
        int[] drow={-1,0,1,0};
        int[] dcol={0,-1,0,1};
        int rot=0;
        while(!q.isEmpty())
        {
           int r=q.peek().row;
           int c=q.peek().col;
           int t=q.peek().t;
           time=Math.max(t,time);
           q.poll();
           for(int i=0;i<4;i++)
           {
                int nr=r+drow[i];
                int nc=c+dcol[i];
                if(nr>=0&&nr<row&&nc>=0&&nc<col&&visited[nr][nc]==0&&grid[nr][nc]==1)
                {
                    q.add(new Pair(nr,nc,t+1));
                    visited[nr][nc]=1;
                    grid[nr][nc]=2;
                    rot++;
                }
           } 
        }
        if(rot!=cntFresh)
        {
            return -1;
        }
        return time;
    }
}
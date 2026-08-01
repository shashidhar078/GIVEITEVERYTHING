class Solution {
    int[] drow={-1,0,1,0};
    int[] dcol={0,-1,0,1};
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        int[][] visited=new int[m][n];

        for(int i=0;i<n;i++)
        {
            if(board[0][i]=='O'&&visited[0][i]==0)
            {
                dfs(0,i,visited,board);
            }
        }
        for(int i=0;i<m;i++)
        {
            if(board[i][0]=='O'&&visited[i][0]==0)
            {
                dfs(i,0,visited,board);
            }
        }
        for(int i=0;i<n;i++)
        {
            if(board[m-1][i]=='O'&&visited[m-1][i]==0)
            {
                dfs(m-1,i,visited,board);
            }
        }
        for(int i=0;i<m;i++)
        {
            if(board[i][n-1]=='O'&&visited[i][n-1]==0)
            {
                dfs(i,n-1,visited,board);
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(visited[i][j]!=1&&board[i][j]=='O')
                {
                    board[i][j]='X';
                }
            }
        }
    }
    public void dfs(int row,int col,int[][] visited,char[][] board)
    {
        visited[row][col]=1;

        for(int i=0;i<4;i++)
        {
            int nr=row+drow[i];
            int nc=col+dcol[i];

            if(nr<0||nr>=board.length||nc<0||nc>=board[0].length)
            {
                continue;
            }
            if(visited[nr][nc]!=1&&board[nr][nc]=='O')
            {
                // visited[nr][nc]=1;
                dfs(nr,nc,visited,board);
            }
        }
    }
}
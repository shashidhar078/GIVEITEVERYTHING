class Solution {
    class Pair{
        int row;
        int col;
        int d;

        Pair(int row,int col,int d)
        {
            this.row=row;
            this.col=col;
            this.d=d;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] ans=new int[m][n];


        Queue<Pair> q=new LinkedList<>();
        int[][] visited=new int[m][n];

        int[] drow={-1,0,1,0};
        int[] dcol={0,-1,0,1};

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                {
                    q.add(new Pair(i,j,0));
                    visited[i][j]=1;
                    // ans[i][j]=0;
                }
            }
        }

        while(!q.isEmpty())
        {
            int row=q.peek().row;
            int col=q.peek().col;
            int d=q.peek().d;
            ans[row][col]=d;
            q.remove();
            for(int i=0;i<4;i++)
            {
                int nr=row+drow[i];
                int nc=col+dcol[i];
                if(nr>=0&&nr<m&&nc>=0&&nc<n&&visited[nr][nc]==0)
                {
                    visited[nr][nc]=1;
                    q.add(new Pair(nr,nc,d+1));
                }
            }
        }
        return ans;
    }
}
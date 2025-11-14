class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        char board[][]=new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]='.';
            }
        }
        solve(0,board,ans,n);
        return ans;
    }
    public static boolean isSafe(int row,int col,char[][] board,int n)
    {
        int dupRow=row;
        int dupCol=col;

        //upward diagonal
        while(row>=0&&col>=0)
        {
            if(board[row][col]=='Q')
            {
                return false;
            }
            row--;
            col--;
        }

        //leftside check
        row=dupRow;
        col=dupCol;
        while(col>=0)
        {
            if(board[row][col]=='Q')
            {
                return false;
            }
            col--;
        }

        //downward diagonal
        row=dupRow;
        col=dupCol;
        while(row<=n-1&&col>=0)
        {
            if(board[row][col]=='Q')
            {
                return false;
            }
            row++;
            col--;
        }

        return true;

    }
    public static void solve(int col,char[][] board,List<List<String>> ans,int n)
    {
        if(col==n)
        {
            List<String> res=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                String s=new String(board[i]);
                res.add(s);
            }
            ans.add(res);
            return;
        }
        for(int row=0;row<n;row++)
        {
            if(isSafe(row,col,board,n))
            {
                board[row][col]='Q';
                solve(col+1,board,ans,n);
                board[row][col]='.';
            }
        }
    }
}
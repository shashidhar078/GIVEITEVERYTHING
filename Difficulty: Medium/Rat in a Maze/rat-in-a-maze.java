class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ArrayList<String> res=new ArrayList<>();
        int n=maze.length;
        int visited[][]=new int[n][n];
        solve(0,0,maze,res,n,"",visited);
        return res;            
    }
    public static void solve(int i,int j,int[][] maze,ArrayList<String> res,int n,String ans,int[][] visited)
    {
        if(i==n-1&&j==n-1)
        {
            res.add(ans);
            return;
        }
        
        visited[i][j]=1;
        //downward
        if(isSafe(i+1,j,maze,n,visited))
        {
            solve(i+1,j,maze,res,n,ans+'D',visited);
        }
        
        //leftward
         if(isSafe(i,j-1,maze,n,visited))
        {
            solve(i,j-1,maze,res,n,ans+'L',visited);
        }
        
        //rightward
        if(isSafe(i,j+1,maze,n,visited))
        {
            solve(i,j+1,maze,res,n,ans+'R',visited);
        }
        
        //upward
        if(isSafe(i-1,j,maze,n,visited))
        {
            solve(i-1,j,maze,res,n,ans+'U',visited);
        }
        
        
        
       
        
        visited[i][j]=0;
    }
    public static boolean  isSafe(int row,int col,int[][] maze,int n,int[][] visited)
    {
        if(row>=0&&col>=0&&row<=n-1&&col<=n-1&&visited[row][col]==0&&maze[row][col]==1)
        {
            return true;
        }
        return false;
    }
}


class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        int n=maze.length;
        ArrayList<String> ans=new ArrayList<>();
        int[][] visited=new int[n][n];
        searchRoute(0,0,ans,maze,"",visited,n);
        Collections.sort(ans);
        return ans;
    }
    public static void searchRoute(int i,int j,ArrayList<String> ans,int[][] maze,String s,int[][] visited,int n)
    {
        if(i==n-1&&j==n-1)
        {
            ans.add(s);
            return;
        }
        
        
        visited[i][j]=1;
        //downward direction 
        
        if(isSafe(i+1,j,maze,visited,n))
        {
            searchRoute(i+1,j,ans,maze,s+"D",visited,n);
        }
        
        //upward direction 
        if(isSafe(i-1,j,maze,visited,n))
        {
             searchRoute(i-1,j,ans,maze,s+"U",visited,n);
        }
        
        //Right direction
        if(isSafe(i,j+1,maze,visited,n))
        {
            searchRoute(i,j+1,ans,maze,s+"R",visited,n);
        }
        
        //left direction 
        if(isSafe(i,j-1,maze,visited,n))
        {
             searchRoute(i,j-1,ans,maze,s+"L",visited,n);
        }
        
        visited[i][j]=0;
                
    }
    public static boolean isSafe(int i,int j,int[][] maze,int[][] visited,int n)
    {
        if(i>=0&&j>=0&&i<=n-1&&j<=n-1&&maze[i][j]==1&&visited[i][j]==0)
        {
            return true;
        }
        return false;
    }
}
class Solution {
    int[] drow={-1,0,1,0};
    int[] dcol={0,-1,0,1};
    public int countDistinctIslands(char[][] grid) {
        // code here
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        int[][] visited=new int[m][n];
        HashSet<ArrayList<String>> set=new HashSet<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(visited[i][j]!=1&&grid[i][j]=='L')
                {
                    ArrayList<String> shape=new ArrayList<>();
                    dfs(i,j,i,j,grid,visited,shape);
                    set.add(shape);
                }
            }
        }
        return set.size();
    }
    public void dfs(int row,int col,int baser,int basec,char[][] grid,int[][] visited,ArrayList<String> shape)
    {
        visited[row][col]=1;
        int cr=row-baser;
        int cc=col-basec;
        shape.add(cr+","+cc);
        for(int i=0;i<4;i++)
        {
            int r=row+drow[i];
            int c=col+dcol[i];
            
            if(r<0||r>=grid.length||c<0||c>=grid[0].length)
            {
                continue;
            }
            if(visited[r][c]!=1&&grid[r][c]=='L')
            {
                dfs(r,c,baser,basec,grid,visited,shape);
            }
        }
    }
}
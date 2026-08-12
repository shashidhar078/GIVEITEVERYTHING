class Solution {
    class Tuple{
        int first;
        int second;
        int third;
        Tuple(int first,int second,int third)
        {
            this.first=first;
            this.second=second;
            this.third=third;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dist=new int[grid.length][grid[0].length];
        Queue<Tuple> q=new LinkedList<>();
        q.add(new Tuple(1,0,0));
        int n=grid.length;
       
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1)
    return -1;
     if(n==1)
        {
                        return 1;
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        dist[0][0]=1;
        int[] dr = {-1,-1,-1,0,0,1,1,1};
        int[] dc = {-1,0,1,-1,1,-1,0,1};
        while(!q.isEmpty())
        {
            Tuple it=q.peek();
            int first=it.first;
            int second=it.second;
            int third=it.third;
            q.remove();
            for(int k=0;k<8;k++)
            {
                int nr = second + dr[k];
                int nc = third + dc[k];
                if(nr>=0&&nr<grid.length&&nc>=0&&nc<grid[0].length&&grid[nr][nc]==0&&first+1<dist[nr][nc])
                {
                    dist[nr][nc]=1+first;
                    if(nr==n-1&&nc==n-1)
                    {
                        return first+1;
                    }
                    q.add(new Tuple(first+1,nr,nc));
                }
            }
        }
        return -1;
    }
}
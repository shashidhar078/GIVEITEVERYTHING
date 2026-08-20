class Solution {
    class Tuple{
        int dist;
        int row;
        int col;
        Tuple(int dist,int row,int col)
        {
             this.dist=dist;
             this.row=row;
             this.col=col;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Tuple> pq=new PriorityQueue<>((a,b)->a.dist-b.dist);
        int m=heights.length;
        int n=heights[0].length;

        int[][] dist=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                dist[i][j]=Integer.MAX_VALUE;
            }
        }

        pq.add(new Tuple(0,0,0));

        int[] row={-1,0,1,0};
        int[] col={0,-1,0,1};

        while(!pq.isEmpty())
        {
            Tuple t=pq.peek();
            pq.remove();
            int diff=t.dist;
            int newrow=t.row;
            int newcol=t.col;

            if(newrow==m-1&&newcol==n-1)
            {
                return diff;
            }

            for(int i=0;i<4;i++)
            {
                int r=newrow+row[i];
                int c=newcol+col[i];

                if(r>=0&&r<m&&c>=0&&c<n)
                {
                    int newDiff=Math.max(Math.abs(heights[newrow][newcol]-heights[r][c]),diff);
                    if(newDiff < dist[r][c])
                    {
                        dist[r][c]=newDiff;
                        pq.add(new Tuple(newDiff,r,c));
                    }
                }
            }
        }
        return -1;
    }
}
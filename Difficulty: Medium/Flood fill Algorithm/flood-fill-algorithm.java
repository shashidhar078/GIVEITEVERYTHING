class Solution {
    class Pair{
        int first=0;
        int second=0;
        
        Pair(int first,int second)
        {
            this.first=first;
            this.second=second;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // code here
     int row=image.length;
     int col=image[0].length;
     int[][] res=new int[row][col];
     
     Queue<Pair> q=new LinkedList<>();
    //  int[][] visited=new int[row][col];
     
     int oldColor=image[sr][sc];
     
    if(oldColor == newColor)
    {
        return image;
    }
     
     q.add(new Pair(sr,sc));
    //  visited[sr][sc]=1;
     image[sr][sc]=newColor;
     int[] drow={-1,0,1,0};
     int[] dcol={0,-1,0,1};
     while(!q.isEmpty())
     {
         int r=q.peek().first;
         int c=q.peek().second;
         q.remove();
        for(int i=0;i<4;i++)
        {
            int nr=r+drow[i];
            int nc=c+dcol[i];
            
            if(nr>=0&&nr<row&&nc>=0&&nc<col&&image[nr][nc]==oldColor)
            {
                q.add(new Pair(nr,nc));
                image[nr][nc]=newColor;
            }
            
        }
     }
     return image;
    }
}
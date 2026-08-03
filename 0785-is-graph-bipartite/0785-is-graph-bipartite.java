class Solution {
    public boolean isBipartite(int[][] graph) {
        //it can be simple like if we are able to color the graph with two colors such that adjacent colors do not have the same color then it is a bipartite graph.

        
        int[] color=new int[graph.length];
        
        for(int i=0;i<graph.length;i++)
        {
            color[i]=-1;
        }
        int col=0;
        for(int i=0;i<color.length;i++)
        {
            if(color[i]==-1)
            {
                if(!bfs(i,col,color,graph))
                {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean bfs(int node,int col,int[] color,int[][] graph)
    {
        Queue<Integer> q=new LinkedList<>();
        q.add(node);
        color[node]=col;
        while(!q.isEmpty())
        {
            int currnode=q.peek();
            q.remove();
            
            for(int i:graph[currnode])
            {
                if(color[i]==-1)
                {
                    color[i]=1-color[currnode];
                    q.add(i);
                }
                else if(color[i]==color[currnode])
                {
                    return false;
                }
            }
        }
        return true;
    }
}
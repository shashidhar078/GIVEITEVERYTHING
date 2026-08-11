class Solution {
 
    public int shortestPath(int V, int[][] edges, int src, int dest) {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        Queue<Integer> q=new LinkedList<>();
        
        int[] dist=new int[V];
        
        for(int i=0;i<V;i++)
        {
            dist[i]=Integer.MAX_VALUE;
        }
        dist[src]=0;
        q.add(src);
        
        while(!q.isEmpty())
        {
            int currnode=q.peek();
            q.remove();
            for(int i:adj.get(currnode))
            {
                if(dist[i]>dist[currnode]+1)
                {
                    dist[i]=dist[currnode]+1;
                    q.add(i);
                }
            }
        }
        
        for(int i=0;i<V;i++)
        {
            if(dist[i]==Integer.MAX_VALUE)
            {
                dist[i]=-1;
            }
        }
        
        int ans=dist[dest];
        return ans;
    }
}
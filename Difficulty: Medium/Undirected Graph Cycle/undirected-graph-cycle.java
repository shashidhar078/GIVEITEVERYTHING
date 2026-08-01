class Solution {
    class Pair{
        int child=0;
        int parent=0;
        
        Pair(int child,int parent)
        {
            this.child=child;
            this.parent=parent;
        }
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        boolean[] visited=new boolean[V];
        
        
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
        
        
        for(int i=0;i<visited.length;i++)
        {
            visited[i]=false;
        }
        for(int i=0;i<V;i++)
        {
           if(visited[i]==false) {
                if(detectCycle(i,visited,adj))
                {
                    return true;
                }   
           }
        }
        return false;
    }
    public  boolean detectCycle(int src,boolean[] visited,ArrayList<ArrayList<Integer>> adj)
    {
        Queue<Pair> q=new LinkedList<>();
        visited[src]=true;
        q.add(new Pair(src,-1));
        
        while(!q.isEmpty())
        {
            int child=q.peek().child;
            int parent=q.peek().parent;
            
            q.remove();
            
            for(int adjnode:adj.get(child))
            {
                if(!visited[adjnode])
                {
                    visited[adjnode]=true;
                    q.add(new Pair(adjnode,child));
                }
                else if(parent!=adjnode)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
class Solution {
    class Pair{
        int d;
        int node;
        
        Pair(int d,int node)
        {
            this.d=d;
            this.node=node;
        }
    }
    public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];
            adj.get(u).add(new Pair(w,v));
            adj.get(v).add(new Pair(w,u));
        }
        
            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
        if(a.d != b.d)
            return a.d - b.d;
        return a.node - b.node;
    });
        int[] dist=new int[V];
        for(int i=0;i<V;i++)
        {
            dist[i]=Integer.MAX_VALUE;
        }
        dist[src]=0;
        pq.add(new Pair(0,src));
        while(!pq.isEmpty())
        {
            int currnode=pq.peek().node;
            int currdist=pq.peek().d;
            pq.remove();
            if(currdist > dist[currnode])
                continue;
            
            for(Pair i:adj.get(currnode))
            {
                int newdist=currdist+i.d;
                if(newdist<dist[i.node])
                {
                    dist[i.node]=newdist;
                    pq.add(new Pair(newdist,i.node));                                                                                                                                                                                                                                                                                                                                                                                                                                                                
                }
            }
        }
        ArrayList<Integer> arr=new ArrayList<>();
        for(int a:dist)
        {
            arr.add(a);
        }
        return arr;
    }
}
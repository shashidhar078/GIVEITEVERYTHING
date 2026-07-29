class Solution { 
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

         for(int[] edge:edges)
        {
            int u=edge[0];
            int v=edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited=new boolean[adj.size()];
        int totalCount=0;
        for(int i=0;i<visited.length;i++)
        {
            if(!visited[i])
            {
                int[] info=new int[2];
                dfs(i,adj,visited,info);

                int nodeCount=info[0];
                int edgeCount=info[1]/2;

                if(edgeCount==(nodeCount*(nodeCount-1))/2)
                {
                    totalCount++;
                }
            }
        }
        return totalCount;
    }
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] visited,int[] info)
    {
        visited[node]=true;
        
        info[0]++;
        for(int a:adj.get(node))
        {
             
             info[1]++;
            if(!visited[a])
            {
                
                dfs(a,adj,visited,info);
            }
        }
    }
}
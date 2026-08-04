class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
         ArrayList<Integer> arr=new ArrayList<>();
            int V=graph.length;
        int[] visited=new int[V];
        int[] path=new int[V];
        int[] safe=new int[V];
        for(int i=0;i<V;i++)
        {
            if(visited[i]!=1)
            {
                dfs(i,graph,visited,path,safe);
            }
        }

        for(int i=0;i<safe.length;i++)
        {
            if(safe[i]==2)
            {
                arr.add(i);
            }
        }
        return arr;
    }
    public static boolean dfs(int node,int[][] graph,int[] visited,int[] path,int[] safe)
    {
        visited[node]=1;
        path[node]=1;
        
        for(int i:graph[node])
        {
            if(visited[i]!=1)
            {
                if(dfs(i,graph,visited,path,safe))
                {
                    return true;
                }
            }
            else if(path[i]==1)
            {
                return true;
            }
        }
        path[node]=0;
        safe[node]=2;
        return false;
    }
}
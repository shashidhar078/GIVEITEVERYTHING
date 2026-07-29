class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<isConnected.length;i++)
        {
            adj.add(new ArrayList<>());
        }
        //change adjmatrix to adjlist
        for(int i=0;i<isConnected.length;i++)
        {
            for(int j=0;j<isConnected[i].length;j++)
            {
                if(isConnected[i][j]==1&&i!=j)
                {
                    adj.get(i).add(j);
                }
            }
        }     

        boolean[] visited=new boolean[adj.size()];
        
        int count=0;
        for(int i=0;i<visited.length;i++)
        {
            if(!visited[i])
            {
                count++;
                dfs(i,adj,visited);
            }
        }
        return count;
    }
    public static void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[]visited)
    {
        visited[node]=true;
        for(int a:adj.get(node))
        {
            if(!visited[a])
            {
                dfs(a,adj,visited);
            }
        }
    }
}
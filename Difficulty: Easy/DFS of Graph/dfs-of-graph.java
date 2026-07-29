class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> dfs=new ArrayList<>();
        boolean[] visited=new boolean[adj.size()];
        // visited[0]=true;
        solve(0,adj,dfs,visited);
        return dfs;
    }
    public void solve(int node,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> dfs,boolean[] visited)
    {
        visited[node]=true;
        dfs.add(node);
        
        for(int i:adj.get(node))
        {
            if(!visited[i])
            {
                solve(i,adj,dfs,visited);
            }
        }
    }
}
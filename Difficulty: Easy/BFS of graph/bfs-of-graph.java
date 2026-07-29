class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] visited=new boolean[adj.size()];
        Queue<Integer> q=new LinkedList<>();
        ArrayList<Integer> arr=new ArrayList<>();
        
        q.add(0);
        visited[0]=true;
        while(!q.isEmpty())
        {
            int node=q.poll();
            arr.add(node);
            
            for(int a:adj.get(node))
            {
                if(visited[a]==false)
                {
                    visited[a]=true;
                    q.add(a);
                }
            }
        }
        return arr;
    }
}
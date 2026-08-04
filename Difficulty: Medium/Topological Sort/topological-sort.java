class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            arr.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            arr.get(u).add(v);
        }
        
        Stack<Integer> st=new Stack<>();
        int[] visited=new int[V];
        
        for(int i=0;i<V;i++)
        {
            if(visited[i]==0)
            {
                dfs(i,arr,st,visited);    
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(!st.isEmpty())
        {
            ans.add(st.peek());
            st.pop();
        }
        return ans;
    }
    public static void dfs(int node,ArrayList<ArrayList<Integer>> arr,Stack<Integer> st,int[] visited)
    {
        visited[node]=1;
        for(int i:arr.get(node))
        {
            if(visited[i]==0)
            {
                dfs(i,arr,st,visited);
            }
        }
        st.push(node);
    }
}
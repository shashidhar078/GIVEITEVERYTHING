class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<Integer> arr=new ArrayList<>();

        int[] safe=new int[graph.length];

        for(int i=0;i<safe.length;i++)
        {
                if(dfs(i,safe,graph))
                {
                    arr.add(i);
                }
        }
        return arr;
    }
    public static boolean dfs(int node,int[] safe,int[][] graph)
    {
        if(safe[node]==1)
        {
            return false;
        }
        if(safe[node]==2)
        {
            return true;
        }
        safe[node]=1;
        for(int i:graph[node])
        {
                if(!dfs(i,safe,graph))
                {
                    safe[node]=0;
                    return false;
                }
        }
        safe[node]=2;
        return true;
    }
}
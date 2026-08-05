class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            arr.add(new ArrayList<>());
        }

        for(int i=0;i<invocations.length;i++)
        {
            int u=invocations[i][0];
            int v=invocations[i][1];

            arr.get(u).add(v);
        }

        HashSet<Integer> sus=new HashSet<>();

        dfs(k,sus,arr);

        for(int[] i:invocations)
        {
            int from=i[0];
            int to=i[1];

            if(!sus.contains(from)&&sus.contains(to))
            {
                List<Integer> ans=new ArrayList<>();
                for(int j=0;j<n;j++)
                {
                    ans.add(j);
                }
                return ans;
            }
        }

        List<Integer> ans=new ArrayList<>();
        for(int j=0;j<n;j++)
        {
            if(!sus.contains(j))
                    ans.add(j);
        }
                return ans;
    }
    public static void dfs(int k,HashSet<Integer> sus,ArrayList<ArrayList<Integer>> arr)
    {
        if(sus.contains(k))
        {
            return;
        }
        sus.add(k);
        for(int i:arr.get(k))
        {
            dfs(i,sus,arr);
        }
    }
}
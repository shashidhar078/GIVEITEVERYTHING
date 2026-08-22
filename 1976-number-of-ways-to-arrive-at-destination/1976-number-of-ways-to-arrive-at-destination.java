class Solution {
    class Pair{
        long first;
        int second;
        Pair(long first,int second)
        {
            this.first=first;
            this.second=second;
        }
    }
    public int countPaths(int n, int[][] roads) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Long.compare(a.first,b.first));
        int[] ways=new int[n];
        long[] dist=new long[n];

        ArrayList<ArrayList<int[]>> arr=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            arr.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++)
        {
            int u=roads[i][0];
            int v=roads[i][1];
            int t=roads[i][2];
            arr.get(u).add(new int[]{v,t});
            arr.get(v).add(new int[]{u,t});
        }
        pq.add(new Pair(0,0));

        for(int i=0;i<ways.length;i++)
        {
            ways[i]=0;
            dist[i]=Long.MAX_VALUE;
        }
        int mod = 1000000007;
        ways[0]=1;
        dist[0]=0;
        while(pq.size()!=0)
        {
            Pair p=pq.peek();
            pq.remove();
            long distance=p.first;
            int node=p.second;
            if(distance>dist[node])
            {
                continue;
            }
            for(int[] ar:arr.get(node))
            {
                int nextnode=ar[0];
                int presentd=ar[1];
                if(dist[nextnode]>presentd+distance)
                {
                    dist[nextnode]=presentd+distance;
                    pq.add(new Pair(presentd+distance,nextnode));
                    ways[nextnode]=ways[node];
                }
                else if(dist[nextnode]==presentd+distance)
                {
                     ways[nextnode]=(ways[node]+ways[nextnode])%mod;
                }
            }
        }
        int ans=ways[n-1];
        return ans;
    }
}
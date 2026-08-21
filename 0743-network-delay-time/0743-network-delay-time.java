class Solution {
    class Pair{
        int dist;
        int src;
        Pair(int dist,int src)
        {
            this.dist=dist;
            this.src=src;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.dist-b.dist);
        int[] cost=new int[n+1];
        ArrayList<ArrayList<int[]>> arr=new ArrayList<>();

        for(int i=0;i<=n;i++)
        {
            arr.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++)
        {
            int u=times[i][0];
            int v=times[i][1];
            int w=times[i][2];
            arr.get(u).add(new int[]{v,w});
        }
        for(int i=0;i<=n;i++)
        {
            cost[i]=Integer.MAX_VALUE;
        }
        cost[k]=0;
        pq.add(new Pair(0,k));
        while(!pq.isEmpty())
        {
            Pair p=pq.peek();
            pq.remove();
            int dist=p.dist;
            int src=p.src;
            for(int[] i:arr.get(src))
            {
                int next=i[0];
                int d=i[1];
                int newDist=d+dist;
                if(newDist<cost[next])
                {
                    cost[next]=newDist;
                    pq.add(new Pair(newDist,next));
                }
            }
        }
        int max=0;
        for(int i=1;i<=n;i++)
        {
            if(cost[i]==Integer.MAX_VALUE)
            {
                return -1;
            }
            max=Math.max(cost[i],max);
        }
        
        return max;
    }
}
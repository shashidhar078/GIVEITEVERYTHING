class Solution {
    class Tuple
    {
        int node;
        int dist;
        int price;
        Tuple(int node,int dist,int price)
        {
            this.node=node;
            this.dist=dist;
            this.price=price;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        // PriorityQueue<Tuple> pq=new PriorityQueue<>((a,b)->a.price-b.price);

        // ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        // for(int i=0;i<n;i++)
        // {
        //     adj.add(new ArrayList<>());
        // }
        // for(int i=0;i<flights.length;i++)
        // {
        //     int u=flights[i][0];
        //     int v=flights[i][1];
        //     int cost=flights[i][2];
        //     adj.get(u).add(new int[]{v,cost});
        // }
        // pq.add(new Tuple(src,0,0));

        // while(!pq.isEmpty())
        // {
        //     Tuple t=pq.peek();
        //     pq.remove();
        //     int curr=t.node;
        //     int d=t.dist;
        //     int p=t.price;
        //     if(curr==dst)
        //     {
        //         return p;
        //     }
        //     if(d==k+1)
        //     {
        //         continue;
        //     }
        //     for(int[] i:adj.get(curr))
        //     {
        //         int nextNode=i[0];
        //         int price=i[1];
        //         pq.add(new Tuple(nextNode,d+1,price+p));
        //     }
        // }
        Queue<Tuple> q=new LinkedList<>();
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++)
        {
            int u=flights[i][0];
            int v=flights[i][1];
            int cost=flights[i][2];
            adj.get(u).add(new int[]{v,cost});
        }
        q.add(new Tuple(src,0,0));
        int[] pricearr=new int[n];
        for(int i=0;i<pricearr.length;i++)
        {
            pricearr[i]=Integer.MAX_VALUE;
        }
        pricearr[src]=0;
        while(!q.isEmpty())
        {
            Tuple t=q.peek();
            q.remove();
            int curr=t.node;
            int dist=t.dist;
            int price=t.price;
            if(dist==k+1)
            {
                continue;
            }
            for(int[] i:adj.get(curr))
            {
                int nextNode=i[0];
                int cost=i[1];
                int newPrice=price+cost;
                if(newPrice<pricearr[nextNode])
                {
                    pricearr[nextNode]=newPrice;
                    q.add(new Tuple(nextNode,dist+1,newPrice));
                }
               
            }
        }
        if(pricearr[dst]==Integer.MAX_VALUE)
        {
            return -1;
        }
        return pricearr[dst];
    }
}
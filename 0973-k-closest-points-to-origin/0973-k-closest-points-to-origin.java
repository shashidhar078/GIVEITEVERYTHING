class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // step1 : compute the distance , avoid squaring the values , distance formula root of x2+y2
        
        //step2:build priority queue upto ele k which results O(nlogn)
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[0]*a[0]+a[1]*a[1])-(b[0]*b[0]+b[1]*b[1]));
        // for(int i=0;i<points.length;i++)
        // {
        //     x=points[i][0];
        //     y=points[i][1];

        //     int ans=(int)Math.pow(x,2)+(int)Math.pow(y,2);
        //     pq.add(ans);
        //     hs.put(ans,points[i]);
        // }

        for(int i=0;i<points.length;i++)
        {
            pq.add(points[i]);
            if(pq.size()>k)
            {
                pq.remove();
            }
        }
        int[][] res=new int[k][2];

        for(int i=0;i<k;i++)
        {
            // res[i]=pq.peek();
            // pq.remove();
            res[i]=pq.poll();
        }
        return res;
    }

}
class Solution {
    public static int minCost(int[] arr) {
        // code here
        //build pq
        if(arr.length<=1)
        {
            return 0;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++)
        {
            pq.add(arr[i]);
        }
        int len=0;
        int minCost=0;
        while(!pq.isEmpty())
        {
            int a=pq.poll();
            int b=pq.poll();
            len=a+b;
            minCost+=len;
            pq.add(len);
            if(pq.size()==1)
            {
                pq.remove();
            }
        }
        return minCost;
    }
}
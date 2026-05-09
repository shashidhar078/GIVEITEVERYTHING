class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hs=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            hs.put(nums[i],hs.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(
            (a,b)->hs.get(a)-hs.get(b)
        );
        for(int n:hs.keySet())
        {
            pq.add(n);
           if(pq.size()>k)
           {
            pq.poll();
           }
        }
        int[] res=new int[k];
        for(int i=0;i<res.length;i++)
        {
            res[i]=pq.poll();
        }
        return res;
    }
}
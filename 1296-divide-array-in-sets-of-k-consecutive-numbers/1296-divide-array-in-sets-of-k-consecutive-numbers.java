class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if((nums.length%k)!=0)
        {
            return false;
        }

        HashMap<Integer,Integer> hs=new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int i=0;i<nums.length;i++)
        {
            hs.put(nums[i],hs.getOrDefault(nums[i],0)+1);
        }

        for(int i:hs.keySet())
        {
            pq.add(i);
        }

        while(!pq.isEmpty())
        {
            int start=pq.peek();

            for(int i=start;i<k+start;i++)
            {
                if(hs.getOrDefault(i,0)==0)
                {
                    return false;
                }
                int count=hs.get(i);
                count--;
                hs.put(i,count);
                if(hs.get(i)==0)
                {
                    if(i!=pq.peek())
                    {
                        return false;
                    }
                    pq.poll();
                }
            }
        }
        return true;
    }
}
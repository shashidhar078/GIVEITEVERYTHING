class Solution {
    public int findKthLargest(int[] nums, int k) {
        //using priority queue
        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<nums.length;i++)
        {
            pq.add(nums[i]);
        }
        int i=0;
        int ans=0;
        while(!pq.isEmpty())
        {
             ans=pq.poll();
             i++;
            if(i==k)
            {
                break;
            }
           
        }
        return ans;
    }
}
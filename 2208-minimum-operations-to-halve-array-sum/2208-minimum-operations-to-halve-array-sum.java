class Solution {
    public int halveArray(int[] nums) {
        // if(nums.length<=1)
        // {
        //     return 1;
        // }
        PriorityQueue<Double> pq=new PriorityQueue<>(
            Comparator.reverseOrder()
        );
        Double totalSum=0.0;
        for(int i=0;i<nums.length;i++)
        {
            pq.add((double)nums[i]);
            totalSum+=nums[i];
        }
        Double currentSum=totalSum;
        Double val=0.0;
        // Double reducedSum=0.0;
        int count=0;
        while(currentSum>(totalSum/2))
        {
           val=pq.poll();
           currentSum-=(val/2);
           val=(val/2);
           pq.add(val);
        //    reducedSum=totalSum-currentSum;
           count++;
        }
        return count;
    }
   
}
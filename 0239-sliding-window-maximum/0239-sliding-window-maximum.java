class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //brute force solution 
        // int[] res=new int[nums.length-k+1];
        // int maxVal=0;
        // for(int i=0;i<nums.length-k+1;i++)
        // {
        //      maxVal=nums[i];
        //     for(int j=i;j<=i+k-1;j++)
        //     {
        //         maxVal=Math.max(maxVal,nums[j]);
        //     }
        //     res[i]=maxVal;
        // }
        // return res;
        //optimal solution 
        Deque<Integer> q=new LinkedList<>();
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(!q.isEmpty()&&q.peekFirst()<=i-k)
            {
                q.removeFirst();
            }
            while(!q.isEmpty()&&nums[q.peekLast()]<=nums[i])
            {
                q.removeLast();
            }
            q.addLast(i);
            if(i>=k-1)
            {
                arr.add(nums[q.peekFirst()]);
            }
        }
        int[] res=new int[arr.size()];
        for(int i=0;i<arr.size();i++)
        {
            res[i]=arr.get(i);
        }
        return res;
    }
}
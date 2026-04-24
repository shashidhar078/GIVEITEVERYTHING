class Solution {
    public int[] sortArray(int[] nums) {
        //step 1 : build max heap where it takes bottom approach from non-leaf nodes
        int n=nums.length;
        for(int i=n/2-1;i>=0;i--)
        {
            heapify(i,nums,n);
        }

        //step 2 : swap with 0 and last index , remove last ele and heapify to maintain property
        for(int i=n-1;i>0;i--)
        {
            int temp=nums[0];
            nums[0]=nums[i];
            nums[i]=temp;
            heapify(0,nums,i);
        }
        return nums;
    }
    public static void heapify(int i,int[] nums,int size)
    {
        int minIdx=i;
        int left=2*i+1;
        int right=2*i+2;


        if(left<size&&nums[left]>nums[minIdx])
        {
            minIdx=left;
        }
        if(right<size&&nums[right]>nums[minIdx])
        {
            minIdx=right;
        }

        if(minIdx!=i)
        {
            int temp=nums[i];
            nums[i]=nums[minIdx];
            nums[minIdx]=temp;
            heapify(minIdx,nums,size);
        }
    }
}
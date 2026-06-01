class Solution {
    public void nextPermutation(int[] nums) {
        int index=-1;
        int n=nums.length;
        int start=0;
        int end=n-1;
        for(int i=n-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                index=i;
                break; //for breakpoint
            }
        }
        if(index==-1)
        { //if there is no breakpoint that means it is at largest combinatio
            // so just reverse that array
            while(start<end)
            {
                int temp=nums[start];
                nums[start]=nums[end];
                nums[end]=temp;
                start++;
                end--;
            }
        }
        else{
                     for(int i=n-1;i>=index+1;i--)
                    {
                        if(nums[i]>nums[index])
                        {
                            swap(nums,i,index);
                            break;
                        }
                    }
                start=index+1;
                end=n-1;
                while(start<end)
                {
                        int temp1=nums[start];
                        nums[start]=nums[end];
                        nums[end]=temp1;
                        start++;
                        end--;
                }
                
        }

       
    }
    public static void swap(int[] nums,int a,int b)
    {
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
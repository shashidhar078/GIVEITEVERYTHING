class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        int k=0;
        int[] nums=new int[nums1.length+nums2.length];
        while(i<nums1.length&&j<nums2.length)
        {
            if(nums1[i]<nums2[j])
            {
                nums[k]=nums1[i];
                k++;
                i++;
            }
            else
            {
                nums[k]=nums2[j];
                j++;
                k++;
            }
        }
        while(i<nums1.length)
        {
            nums[k]=nums1[i];
            i++;
            k++;
        }
        while(j<nums2.length)
        {
            nums[k]=nums2[j];
            j++;
            k++;
        }
        int n=nums.length;
        double median=-1;
        if (n % 2 == 0) {
            int a = nums[n / 2 - 1];
            int b = nums[n / 2];
            median = (a + b) / 2.0;
        } else {
            median = nums[n / 2];
        }
        return median;
    }
}
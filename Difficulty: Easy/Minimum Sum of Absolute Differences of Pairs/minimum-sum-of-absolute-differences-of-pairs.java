class Solution {
    public int findMinSum(int[] a, int[] b) {
        // code here
        //following simple greedy approach here 
        Arrays.sort(a);
        Arrays.sort(b);
        int ab=0;
        int val=0;
        for(int i=0;i<a.length;i++)
        {
            ab=a[i]-b[i];
            ab=Math.abs(ab);
            val+=ab;
        }
        return val;
    }
};
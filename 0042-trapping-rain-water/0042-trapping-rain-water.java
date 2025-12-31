class Solution {
    public int trap(int[] height) {
        if(height.length<2)
        {
            return 0;
        }
        int tMin=Integer.MIN_VALUE;
        int tWater=0;
        int tVolume=0;
        int lmax=Integer.MIN_VALUE;
        int rmax=Integer.MIN_VALUE;
        int[] leftmax=new int[height.length];
        int[] rightmax=new int[height.length];
        for(int i=0;i<height.length;i++)
        {
            lmax=Math.max(lmax,height[i]);
            leftmax[i]=lmax;
        }
        for(int i=height.length-1;i>=0;i--)
        {
            rmax=Math.max(rmax,height[i]);
            rightmax[i]=rmax;
        }
        for(int i=0;i<height.length;i++)
        {
            tMin=Math.min(leftmax[i],rightmax[i]);
            tWater=(tMin-height[i])*1;
            if(tWater>0)
            {
                tVolume+=tWater;
            }
            tVolume+=0;
        }
        return tVolume;
    }
}
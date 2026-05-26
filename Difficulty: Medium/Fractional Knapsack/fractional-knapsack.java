class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        double value=0.0;
        double[][] act=new double[val.length][3];
        
        for(int i=0;i<wt.length;i++)
        {
            act[i][0]=val[i];
            act[i][1]=wt[i];
            act[i][2]=(double) val[i]/wt[i];
        }
        
        Arrays.sort(act, (a,b) -> Double.compare(b[2], a[2]));        
        for(int i=0;i<wt.length;i++)
        {
            if(capacity>=act[i][1])
            {
                value+=act[i][0];
                capacity-=act[i][1];
            }
            else
            {
                value=value+capacity*act[i][2];
                break;
            }
        }
        return value;
    }
}
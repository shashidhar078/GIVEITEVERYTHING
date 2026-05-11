class Solution {
    public int activitySelection(int[] start, int[] finish) {
        // code here
        int maxAct=0;
        
        //we are considering from activity 0 so initially activity count is added already        
        maxAct=1;
        
        int[][] activities=new int[start.length][3];
        
        for(int i=0;i<start.length;i++)
        {
            activities[i][0]=i;
            activities[i][1]=start[i];
            activities[i][2]=finish[i];
        }
        
        
        Arrays.sort(activities,Comparator.comparingInt(o->o[2]));
        
        int lastVal=activities[0][2];
        for(int i=1;i<activities.length;i++)
        {
            if(activities[i][1]>lastVal)
            {
                maxAct++;
                lastVal=activities[i][2];
            }
        }
        return maxAct;
    }
}

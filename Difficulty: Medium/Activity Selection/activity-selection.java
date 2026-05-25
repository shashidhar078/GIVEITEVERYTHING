class Solution {
    public int activitySelection(int[] start, int[] finish) {
        // code here
        int count=0;
        
        int[][] activities=new int[start.length][3];
        
        for(int i=0;i<activities.length;i++)
        {
            activities[i][0]=i;
            activities[i][1]=start[i];
            activities[i][2]=finish[i];
        }
        
        Arrays.sort(activities,Comparator.comparingDouble(o->o[2]));
        
        
        
        int finished=activities[0][2];
        count++;
        for(int i=1;i<finish.length;i++)
        {
            if(activities[i][1]>finished)
            {
                count++;
                finished=activities[i][2];
            }
        }
        return count;
    }
}

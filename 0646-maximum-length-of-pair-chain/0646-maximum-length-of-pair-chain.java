class Solution {
    public int findLongestChain(int[][] pairs) {
        //lets apply sorting on second element 
        //this is somewhat close to the activity selection problem 
        Arrays.sort(pairs,Comparator.comparingInt(o->o[1]));

        int count=1;
        int prev=pairs[0][1];
        for(int i=1;i<pairs.length;i++)
        {
            if(prev<pairs[i][0])
            {
                count++;
                prev=pairs[i][1];
            }
        }
        return count;
    }
}
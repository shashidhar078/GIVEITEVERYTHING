class Solution {
    public int minimumPushes(String word) {
        int pushes=0;
        int count=1;
        for(int i=0;i<word.length();i++)
        {
            if(i%8==0&&i!=0)
            {
                count++;
            }
            pushes+=count;
        }
        return pushes;
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Brute force approach
        // int len=0;
        // int max=0;
        // for(int i=0;i<s.length();i++)
        // {
        //     int[] hash=new int[255];
        //     for(int j=i;j<s.length();j++)
        //     {
        //         if(hash[s.charAt(j)]==1)
        //         {
        //             break;
        //         }
        //         len=j-i+1;
        //         max=Math.max(max,len);
        //         hash[s.charAt(j)]=1;
        //     }
        // }     
        // return max;
        //using sliding window
        int l=0;
        int r=0;
        HashMap<Character,Integer> mpp=new HashMap<>();
        int len=0;
        int maxLen=0;
        char c=0;
        while(r<s.length())
        {
            c=s.charAt(r);
            if(mpp.containsKey(c))
            {
                if(mpp.get(c)>=l)
                {
                    l=mpp.get(c)+1;
                    len=r-l+1;
                    maxLen=Math.max(len,maxLen);
                }
            }
            len=r-l+1;
            maxLen=Math.max(len,maxLen);
            mpp.put(c,r);
            r++;
        }
        return maxLen;
    }
    
}
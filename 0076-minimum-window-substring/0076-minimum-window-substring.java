class Solution {
    public String minWindow(String s, String t) {
        //brute force approach
        // StringBuilder res=new StringBuilder();
        // int minLen=Integer.MAX_VALUE;
        // HashMap<Character,Integer> mpp=new HashMap<>();
        // for(int i=0;i<t.length();i++)
        // {
        //     mpp.put(t.charAt(i),i);
        // }
        // for(int i=0;i<s.length();i++)
        // {
        //     StringBuilder stb=new StringBuilder();
        //     HashSet<Character> seen = new HashSet<>();
        //     int count=0;
        //     stb.append(s.charAt(i));
        //      if (mpp.containsKey(s.charAt(i))) {
        //             seen.add(s.charAt(i));
        //         }
        //          if(seen.size()==t.length())
        //         {
        //             int c=stb.length();
        //             if(minLen>c)
        //             {
        //                 minLen=c;
        //                 res=new StringBuilder(stb);
        //             }
        //         }
        //     for(int j=i+1;j<s.length();j++)
        //     {
        //         stb.append(s.charAt(j));
                
        //         if (mpp.containsKey(s.charAt(j))) {
        //             seen.add(s.charAt(j));
        //         }

        //         if(seen.size()==t.length())
        //         {
        //             int c=stb.length();
        //             if(minLen>c)
        //             {
        //                 minLen=c;
        //                 res=new StringBuilder(stb);
        //             }
        //         }
                
        //     }
        //     if(seen.size()==t.length())
        //     {
        //         int c=stb.length();
        //         if(minLen>c)
        //         {
        //                 minLen=c;
        //                  res=new StringBuilder(stb);
        //         }
        //     }
        // }
        // return res.toString();
        //Better approach 
        HashMap<Character,Integer> mpp=new HashMap<>();
        int r=0;
        int l=0;
        int count=0;
        int startindex=0;
        int minLen=Integer.MAX_VALUE;
        String res="";
        for(int i=0;i<t.length();i++)
        {
            mpp.put(t.charAt(i),mpp.getOrDefault(t.charAt(i),0)+1);
        }
        while(r<s.length())
        {
            if(mpp.getOrDefault(s.charAt(r),0)>0)
            {
                count++;
            }
             mpp.put(s.charAt(r),mpp.getOrDefault(s.charAt(r),0)-1);
            while(count==t.length())
            {
                if((r-l+1)<minLen)
                {
                    minLen=r-l+1;
                    startindex=l;
                }
                int c=mpp.get(s.charAt(l));
                c++;
                mpp.put(s.charAt(l),c);         
                if(mpp.get(s.charAt(l))>0)
               {
                    count--;
               }
               l=l+1;
            }
            r=r+1;
        }
        if(minLen==Integer.MAX_VALUE)
        {
            return res;
        }
        res=s.substring(startindex,startindex+minLen);
        return res;
    }
}
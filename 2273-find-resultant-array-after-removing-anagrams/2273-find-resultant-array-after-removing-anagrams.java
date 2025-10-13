class Solution {
    public List<String> removeAnagrams(String[] words) {
    //    HashMap<String,Integer> mpp=new HashMap<>();
       String[] str=new String[words.length];
       List<String> ans=new ArrayList<>();
       for(int i=0;i<words.length;i++)
       {    
            char[] ch=words[i].toCharArray();
            Arrays.sort(ch);
            str[i]=new String(ch);
       }
    //    for(int i=0;i<str.length;i++)
    //    {
    //         mpp.put(str[i],mpp.getOrDefault(str[i],0)+1);
    //    } 
    //    for(int i=0;i<str.length;i++)
    //    {
    //      if((mpp.getOrDefault(str[i],0)>=1))
    //      {
    //         if(i>0&&str[i].equals(str[i-1]))
    //         {
    //             continue;
    //         }
    //         ans.add(words[i]);
    //      }
    //    }
    for(int i=0;i<str.length;i++)
    {
            if(i>0&&str[i].equals(str[i-1]))
            {
                continue;
            }
            ans.add(words[i]);
    }
       return ans;
    }
}
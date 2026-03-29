class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> ls=new ArrayList<>();
        paPartition(ans,ls,s,0);
        return ans;
    }
    public static void paPartition(List<List<String>> ans,List<String> ls,String s,int index)
    {
        if(index==s.length())
        {
            ans.add(new ArrayList<>(ls));
            return;
        }
        for(int i=index;i<s.length();i++)
        {
            if(isPartition(s,index,i))
            {
                ls.add(s.substring(index,i+1));
                paPartition(ans,ls,s,i+1);
                ls.remove(ls.size()-1);
            }
        }
    }
    public static boolean isPartition(String s,int start,int end)
    {
        while(start<end)
        {
            if(s.charAt(start)!=s.charAt(end))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
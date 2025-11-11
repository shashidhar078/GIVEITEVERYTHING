class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> ans=new ArrayList<>();
        palPartition(0,s,res,ans);
        return res;        
    }
    public static void palPartition(int ind,String s,List<List<String>> res,List<String> ans)
    {
        if(ind==s.length())
        {
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int i=ind;i<s.length();i++)
        {
            if(isPalindrome(s,ind,i))
            {
                ans.add(s.substring(ind,i+1));
                palPartition(i+1,s,res,ans);
                ans.remove(ans.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String s,int start,int end)
    {
        while(start<=end)
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
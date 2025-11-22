// User function Template for Java
class Solution {
    static String[] wordBreak(String[] dict, String s) {
        // code here
        HashSet<String> hs=new HashSet<>();
        for(int i=0;i<dict.length;i++)
        {
            hs.add(dict[i]);
        }
        StringBuilder res=new StringBuilder();
        ArrayList<String> ans=new ArrayList<>();
        findWord(0,s,ans,hs,0,res);
        String[] finAns=new String[ans.size()];
        int i=0;
        for(String a:ans)
        {
            finAns[i++]=a;
        }
        return finAns;
    }
    public static void findWord(int indx,String s,ArrayList<String> ans,HashSet<String> hs,int j,StringBuilder res)
    {
        if(indx==s.length())
        {
               ans.add(new String(res));
               return;
        }
        for(int i=indx;i<s.length();i++)
        {
            if(hs.contains(s.substring(indx,i+1)))
            {
                String curr=s.substring(indx,i+1);
                res.append(curr);
                res.append(" ");
                findWord(i+1,s,ans,hs,j,res);
                res.delete(res.length()-(curr.length()+1),res.length());
            }
        }
    }
}
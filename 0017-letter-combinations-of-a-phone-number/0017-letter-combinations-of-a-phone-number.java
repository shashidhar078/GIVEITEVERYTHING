class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        letCombo("",digits,ans);
        return ans;
    }
    public static void letCombo(String p,String str,List<String> ans)
    {
        if(str.equals(""))
        {
            ans.add(p);
            return;
        }
        int digit=str.charAt(0)-'0';
        int i=(digit-2)*3;
        if(digit>7)
        {
            i=i+1;
        }
        int len=i+3;
        if(digit==7||digit==9)
        {
            // i=i+1;
            len=len+1;
        }
        for(;i<len;i++)
        {
            char ch=(char)('a'+i);
            letCombo(p+ch,str.substring(1),ans);
        }
    }
}
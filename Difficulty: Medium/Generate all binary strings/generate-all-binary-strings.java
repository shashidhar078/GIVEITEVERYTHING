class Solution {
    public ArrayList<String> binstr(int n) {
        // code here
        ArrayList<String> res=new ArrayList<>();
        generate(n,"",res);
        return res;
    }
    public static void generate(int n,String ans,ArrayList<String> res)
    {
        if(ans.length()==n)
        {
            res.add(ans);
            return;
        }
        generate(n,ans+'0',res);
        generate(n,ans+'1',res);
    }
}

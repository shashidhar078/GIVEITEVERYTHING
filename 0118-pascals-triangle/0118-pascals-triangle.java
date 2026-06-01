class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ls=new ArrayList<>();
        List<Integer> re=new ArrayList<>();
        re.add(1);
        ls.add(re);
        
        for(int i=2;i<=numRows;i++)
        {
            List<Integer> r=new ArrayList<>();
            int ans=1;
            r.add(1);
            for(int j=1;j<i;j++)
            {
                ans*=(i-j);
                ans=(ans/j);
                r.add(ans);
            }
            ls.add(r);
        }
       return ls;
    }
}
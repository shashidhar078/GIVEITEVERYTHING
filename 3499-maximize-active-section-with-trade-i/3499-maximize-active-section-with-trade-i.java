class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ones=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
            {
                ones++;
            }
        }
        ArrayList<Character> typeC=new ArrayList<>();
        ArrayList<Integer> len=new ArrayList<>();
        String t='1'+s+'1';

        int i=0;
        while(i<t.length())
        {
            char ch=t.charAt(i);
            int cnt=0;
            while(i<t.length()&&t.charAt(i)==ch)
            {
                cnt++;
                i++;
            }
            typeC.add(ch);
            len.add(cnt);
        }

        //find block
        int best=0;
        int max=0;
        for(int j=1;j<len.size()-1;j++)
        {
            if(typeC.get(j)=='1'&&typeC.get(j-1)=='0'&&typeC.get(j+1)=='0')
            {
                max=Math.max(best,len.get(j-1)+len.get(j+1));
                best=Math.max(best,max);
            }
        }

        return ones+best;
    }
}
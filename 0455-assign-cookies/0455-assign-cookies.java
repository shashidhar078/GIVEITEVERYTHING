class Solution {
    public int findContentChildren(int[] g, int[] s) {
        //lets make it simple by appying simple sorting technique and two pointers approach 

        Arrays.sort(g);
        Arrays.sort(s);

        int count=0;
        int ls=0;
        int rg=0;
        while(ls<s.length&&rg<g.length)
        {
            if(s[ls]>=g[rg])
            {
                count++;
                rg++;
            }
            ls++;
        }
        return count;
    }
}
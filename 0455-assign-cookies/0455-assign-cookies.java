class Solution {
    public int findContentChildren(int[] g, int[] s) {
        //lets make it simple with two pointers approach
        //by sorting the two arrays so we could assign cookies properly


        Arrays.sort(g);
        Arrays.sort(s);

        int l=0;
        int r=0;

        int m=g.length;
        int n=s.length;

        int count=0;
        while(l<n&&r<m)
        {
            if(s[l]>=g[r])
            {
                count++;
                r++;
                // l++;
            }
            l++;
        }
        return count;
    }
}
class Solution {
    class Pair{
        String node;
        int steps;
        Pair(String node,int steps)
        {
            this.node=node;
            this.steps=steps;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        Set<String> st=new HashSet<>();

        for(int i=0;i<wordList.size();i++)
        {
            st.add(wordList.get(i));
        }
        st.remove(beginWord);

        while(!q.isEmpty())
        {
            String curr=q.peek().node;
            int steps=q.peek().steps;
            if(curr.equals(endWord))
            {
                return steps;
            }
            q.remove();
            for(int i=0;i<curr.length();i++)
            {
                for(char ch='a';ch<='z';ch++)
                {
                    char[] charr=curr.toCharArray();
                    charr[i]=ch;
                    String str=new String(charr);
                    if(st.contains(str))
                    {
                        q.add(new Pair(str,steps+1));
                        st.remove(str);
                    }
                }
            }
        }
        return 0;
    }
}
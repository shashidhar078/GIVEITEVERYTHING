class Solution {
    public String smallestSubsequence(String s) {
        Stack<Character> st=new Stack<>();
        StringBuilder stb=new StringBuilder();
        HashSet<Character> hs=new HashSet<>();
        HashMap<Character,Integer> lastIndex=new HashMap<>();

        for(int i=0;i<s.length();i++)
        {
            lastIndex.put(s.charAt(i),i);
        }    
        int j=0;
        while(j<s.length())
        {
            if(!hs.contains(s.charAt(j)))
            {
                // if(!st.isEmpty()&&st.peek()<=s.charAt(j))
                // {
                //     st.push(s.charAt(j));
                // }
                if(!st.isEmpty()&&st.peek()>s.charAt(j))
                {
                    while(!st.isEmpty()&&st.peek()>s.charAt(j)&&j<lastIndex.get(st.peek()))
                    {
                        char c=st.pop();
                        hs.remove(c);
                    }
                }
                st.push(s.charAt(j));
                hs.add(s.charAt(j));
            }
            
            j++;
        }
        while(!st.isEmpty())
        {
            stb.append(st.pop());
        }
        return stb.reverse().toString();
    }
}
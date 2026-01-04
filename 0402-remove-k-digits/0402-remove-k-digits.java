class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st=new Stack<>();
        StringBuilder stb=new StringBuilder();
        for(int i=0;i<num.length();i++)
        {
            while(!st.isEmpty()&&k>0&&st.peek()>num.charAt(i))
            {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        while(k>0)
        {
            st.pop();
            k--;
        }
        if(st.isEmpty())
        {
            return "0";
        }
        while(!st.isEmpty())
        {
            stb.append(st.peek());
            st.pop();
        }
      stb.reverse();  // bring number to correct order

        StringBuilder res = new StringBuilder();
        int i = 0;

        // skip leading zeros
        while (i < stb.length() && stb.charAt(i) == '0') {
            i++;
        }

        // append rest
        while (i < stb.length()) {
            res.append(stb.charAt(i));
            i++;
        }

        return res.length() == 0 ? "0" : res.toString();

    }
}
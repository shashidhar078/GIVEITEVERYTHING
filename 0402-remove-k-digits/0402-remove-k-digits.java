class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<num.length();i++)
        {
            int n=num.charAt(i)-'0';
            if(!st.isEmpty()&&st.peek()>n)
            {
                while(!st.isEmpty()&&st.peek()>n&&k>0)
                {
                    st.pop();
                    k--;
                }
            }
            st.push(n);
        }
        StringBuilder stb=new StringBuilder();
        while(k>0)
        {
            st.pop();
            k--;
        }
        while(!st.isEmpty())
        {
            stb.append(st.pop());
        }
        StringBuilder stb2=new StringBuilder();
        stb2=stb.reverse();
            while(stb2.length() > 0 && stb2.charAt(0) == '0') {
        stb2.deleteCharAt(0);
    }
        if(stb2.length()==0)
        {
            return "0";
        }
        String finalResult=stb2.toString();
        return finalResult;
    }
}
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        String sr=s.trim();
        if(sr.length()%2!=0)
        {
            return false;
        }
        else 
        {
            for(int i=0;i<sr.length();i++)
            {
                if(sr.charAt(i)=='(')
                {
                    st.push(')');
                }
                else if(sr.charAt(i)=='[')
                {
                    st.push(']');
                }
                else if(sr.charAt(i)=='{')
                {
                    st.push('}');
                }
                else if(st.isEmpty()||st.pop()!=sr.charAt(i))
                {
                    return false;
                }
            }
           
        }
        if(!(st.isEmpty()))
        {
            return false;
        }
        return true;
         
    }
}
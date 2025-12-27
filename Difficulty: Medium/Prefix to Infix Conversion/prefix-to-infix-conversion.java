// User function Template for Java

class Solution {
    static String preToInfix(String pre_exp) {
        // code here
        String exp=pre_exp;
        int i=exp.length()-1;
        Stack<String> st=new Stack<>();
        String op=new String();
        while(i>=0)
        {
            op=Character.toString(exp.charAt(i));
            if(exp.charAt(i)>='A'&&exp.charAt(i)<='Z'||
            exp.charAt(i)>='a'&&exp.charAt(i)<='z'||
            exp.charAt(i)>='0'&&exp.charAt(i)<='9')
            {
                st.push(op);
            }
            else
            {
                StringBuilder stb=new StringBuilder();
                String t1=st.peek();
                st.pop();
                String t2=st.peek();
                st.pop();
                stb.append('(');
                stb.append(t1);
                stb.append(op);
                stb.append(t2);
                stb.append(')');
                st.push(stb.toString());
            }
            i--;
        }
        return st.peek();
    }
}

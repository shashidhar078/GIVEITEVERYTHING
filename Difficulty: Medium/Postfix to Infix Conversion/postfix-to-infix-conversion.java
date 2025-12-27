// User function Template for Java

class Solution {
    static String postToInfix(String exp) {
        // code here
        int i=0;
        Stack<String> st=new Stack<>();
        
        int n=exp.length();
        String op=new String();
        while(i<n)
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
                stb.append(t2);
                stb.append(op);
                stb.append(t1);
                stb.append(')');
                st.push(stb.toString());
            }
            i++;
        }
        return st.peek();
    }
}

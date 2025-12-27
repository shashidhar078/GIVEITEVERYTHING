class Solution {
    public static String infixToPostfix(String s) {
        // code here
        int i=0;
        StringBuilder ans=new StringBuilder();
        Stack<Character> st=new Stack<>();
        int n=s.length();
        while(i<n)
        {
            if(s.charAt(i)>='A'&&s.charAt(i)<='Z'||
            s.charAt(i)>='a'&&s.charAt(i)<='z'||
            s.charAt(i)>='0'&&s.charAt(i)<='9')
            {
                ans.append(s.charAt(i));
            } 
            else if(s.charAt(i)=='(')
            {
                st.push(s.charAt(i));
            }
            else if(s.charAt(i)==')')
            {
                while(!(st.isEmpty())&&st.peek()!='(')
                {
                    ans.append(st.peek());
                    st.pop();
                }
                st.pop();
            }
            else 
            {
               while (!st.isEmpty() && 
      (priority(s.charAt(i)) < priority(st.peek()) ||
      (priority(s.charAt(i)) == priority(st.peek()) && s.charAt(i) != '^')))
        {
                    ans.append(st.peek());
                    st.pop();
                }
                st.push(s.charAt(i));
            }
            i++;
        }
        while(!(st.isEmpty()))
        {
            ans.append(st.peek());
            st.pop();
        }
        return ans.toString();
    }
    public static int priority(char a)
    {
        if(a=='^')
        {
            return 3;
        }
        else if(a=='*'||a=='/')
        {
            return 2;
        }
        else if(a=='+'||a=='-')
        {
            return 1;
        }
        return -1;
    }
}
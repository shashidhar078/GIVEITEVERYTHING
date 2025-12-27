class Solution {
    public String infixToPrefix(String s) {
        // code here
        s=reverse(s);
       StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') sb.append(')');
            else if (c == ')') sb.append('(');
            else sb.append(c);
        }
        String strOrg = sb.toString();

        StringBuilder ans=new StringBuilder();
        Stack<Character> st=new Stack<>();
        int i=0;
        int n=s.length();
        while(i<n)
        {
            if(strOrg.charAt(i)>='A'&&strOrg.charAt(i)<='Z'||
            strOrg.charAt(i)>='a'&&strOrg.charAt(i)<='z'||
            strOrg.charAt(i)>='0'&&strOrg.charAt(i)<='9')
            {
                ans.append(strOrg.charAt(i));
            }
            else if(strOrg.charAt(i)=='(')
            {
                st.push(strOrg.charAt(i));
            }
            else if(strOrg.charAt(i)==')')
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
                while(!st.isEmpty()&& 
                (priority(strOrg.charAt(i))<priority(st.peek())||
                (priority(strOrg.charAt(i))==priority(st.peek())&&
                strOrg.charAt(i)=='^')))
                {
                    ans.append(st.peek());
                    st.pop();
                }
                st.push(strOrg.charAt(i));
            }
            i++;
        }
        while (!st.isEmpty()) {
    ans.append(st.pop());
}

        return ans.reverse().toString();
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
    public static String reverse(String s)
    {
        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.reverse();
        String reversedString = stringBuilder.toString();
        return reversedString;
    }
}
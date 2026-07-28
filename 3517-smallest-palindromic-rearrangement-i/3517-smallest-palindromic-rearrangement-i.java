class Solution {
    public String smallestPalindrome(String s) {
        char[] ch=new char[s.length()/2];
        int i=0;
        for(i=0;i<s.length()/2;i++)
        {
            ch[i]=s.charAt(i);
        }
        Arrays.sort(ch);
        ArrayList<Character> arr=new ArrayList<>();
        for(char a:ch)
        {
            arr.add(a);
        }
        Collections.reverse(arr);
        StringBuilder stb=new StringBuilder();
        for(int j=0;j<ch.length;j++)
        {
            stb.append(ch[j]);
        }
        if(s.length()%2==1)
        {
            stb.append(s.charAt(s.length()/2));
        }
        for(char c:arr)
        {
            stb.append(c);
        }
        return stb.toString();
    }
}
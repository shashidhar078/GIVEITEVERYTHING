class Solution {
    public int balancedStringSplit(String s) {
        //simple approach by following counting both l and r 
        //incrementing and decrementing a common variable 
        //whenever that common variable reaches 0 then we increment a count

        int count=0;
        int balance=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='R')
            {
                balance++;
            }
            else if(s.charAt(i)=='L')
            {
                balance--;
            }
            if(balance==0)
            {
                count++;
            }
        }
        return count;
    }
}
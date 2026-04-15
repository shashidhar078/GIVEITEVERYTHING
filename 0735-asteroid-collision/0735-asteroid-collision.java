class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<asteroids.length;i++)
        {
           while(!st.isEmpty()&&st.peek()>0&&asteroids[i]<0&&st.peek()<Math.abs(asteroids[i]))
           {
            st.pop();
           }
           if(!st.isEmpty()&&st.peek()>0&&asteroids[i]<0&&st.peek()==Math.abs(asteroids[i]))
           {
                st.pop();
                continue;
           }
           if(st.isEmpty()||asteroids[i]>0||st.peek()<0)
           {
            st.push(asteroids[i]);
           }
        }
        int[] res=new int[st.size()];
        for(int i=st.size()-1;i>=0;i--)
        {
            res[i]=st.pop();
        }
        return res;
    }
}
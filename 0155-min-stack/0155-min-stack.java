class MinStack {
    public Stack<Integer> st;
    public Stack<Integer> st2;
    public MinStack() {
        st=new Stack<>();
         st2=new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(st2.isEmpty())
        {
            st2.push(val);
        }
        else
        {
            st2.push(Math.min(st2.peek(),val));
        }
        
    }
    
    public void pop() {
        st.pop();
        st2.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return st2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
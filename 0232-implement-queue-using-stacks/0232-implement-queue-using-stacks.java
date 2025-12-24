class MyQueue {
    public Stack<Integer> s1;
    public Stack<Integer> s2;
    public MyQueue() {
        s1=new Stack<>();
        s2=new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if(!(s2.isEmpty()))
        {
           return  s2.pop();
        }
        else
        {
            int s=s1.size();
            for(int i=1;i<=s;i++)
            {
                s2.push(s1.pop());
            }
           return s2.pop();
        }
    }
    
    public int peek() {
         if(!(s2.isEmpty()))
        {
            return s2.peek();
        }
        else
        {
            int s=s1.size();
            for(int i=1;i<=s;i++)
            {
                s2.push(s1.pop());
            }
            return s2.peek();
        }
    }
    
    public boolean empty() {
        return s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
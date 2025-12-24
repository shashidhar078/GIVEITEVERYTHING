class MyStack {
    public Queue<Integer> q;
    public MyStack() {
       q=new LinkedList<>();
    }
    
    public void push(int x) {
        q.offer(x);
        int s=q.size();
        for(int i=1;i<s;i++)
        {
            q.offer(q.peek());
            q.poll();
           
        }
    }
    
    public int pop() {
        if(q.isEmpty())
        {
            System.out.println("it is empty");
        }
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        if(q.size()>0)
        {
            return false;
        }
        return true;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
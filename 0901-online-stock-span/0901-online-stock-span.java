class StockSpanner {

     ArrayList<Integer> arr;
    Stack<Integer> st;
    int i=0;
    public StockSpanner() {
       arr=new ArrayList<>();
            st=new Stack<>();
       
    }
    
    public int next(int price) {
        // arr.add(price);
        // int count=1;
        // int num=price;
        // for(int i=arr.size()-2;i>=0;i--)
        // {
        //     if(arr.get(i)<=num)
        //     {
        //         count++;
        //     }
        //     else
        //     {
        //         break;
        //     }
        // }
        // return count;
        
        int count=0;
        arr.add(price);
        // if(st.isEmpty())
        // {
        //     st.add(i);
        // }
        while(!st.isEmpty()&&price>=arr.get(st.peek()))
        {
            st.pop();
        }
        count=st.isEmpty()?1:i-st.peek();
        if(st.isEmpty()||arr.get(st.peek())>price)
        {
            st.push(i);
        }
        i++;
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
class StockSpanner {

     ArrayList<Integer> arr;
    public StockSpanner() {
       arr=new ArrayList<>();
        // StockSpanner sp=new StockSpanner();
    }
    
    public int next(int price) {
        arr.add(price);
        int count=1;
        int num=price;
        for(int i=arr.size()-2;i>=0;i--)
        {
            if(arr.get(i)<=num)
            {
                count++;
            }
            else
            {
                break;
            }
        }
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
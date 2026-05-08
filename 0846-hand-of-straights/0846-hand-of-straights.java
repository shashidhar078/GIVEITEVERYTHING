class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        //if it is not going to fit for groupSize return false
        if((hand.length%groupSize)!=0)
        {
            return false;
        }

        HashMap<Integer,Integer> hs=new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        //Count your frequencies 
        for(int i=0;i<hand.length;i++)
        {
            hs.put(hand[i],hs.getOrDefault(hand[i],0)+1);
        }

        //build min heap inorder to start from smallest card initially

        for(int i:hs.keySet())
        {
            pq.add(i);
            // System.out.println(i);
        }

        //check for consecutiveness now
        while(!pq.isEmpty())
        {
            int start=pq.peek();

            //force consecutive building 
            for(int i=start;i<groupSize+start;i++)
            {
                if(hs.getOrDefault(i,0)==0)
                {
                    return false;
                }
                int count=hs.get(i);
                count--;
                hs.put(i,count);
                if(hs.get(i)==0)
                {
                    if(i!=pq.peek())
                    {
                        return false;
                    }
                    pq.poll();
                }
            }
            
        } 
        return true;
    }
}
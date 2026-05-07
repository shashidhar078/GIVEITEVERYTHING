class Solution {
    public int leastInterval(char[] tasks, int n) {
        //count the frequencies to know how many tasks are scheduled

        HashMap<Character,Integer> hs=new HashMap<>();
        int time=0;
        for(int i=0;i<tasks.length;i++)
        {
            hs.put(tasks[i],hs.getOrDefault(tasks[i],0)+1);
            // System.out.println(hs.get(tasks[i]));
        }

        //we are considering higher freq inorder maintain proper cycle
        //with given intervals so we consider of implpmenting with MaxHeap
        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
        for(int a:hs.values())
        {
            pq.add(a);
        }

        int cycle=n+1;

        while(!pq.isEmpty())
        {
            ArrayList<Integer> arr=new ArrayList<>();

            int i=0;

            while(i<cycle&&!pq.isEmpty())
            {
                int c=pq.poll();

                c--;

                if(c>0)
                {
                    arr.add(c);
                }

                time++;
                i++;
            }

            for(int a:arr)
            {
                pq.add(a);
            }

            if(!pq.isEmpty())
            {
                time+=(cycle-i);    
            }
        }
        return time;
    }
}
class Solution {
    public void nearlySorted(int[] arr, int k) {
        // code here
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int indx=0;
        // for(int i=0;i<=k;i++)
        // {
        //     pq.add(arr[i]);
        // }
        // for(int i=k+1;i<arr.length;i++)
        // {
        //   arr[indx]=pq.poll();
        //   indx++;
        //   pq.add(arr[i]);
        // }
        // while(!pq.isEmpty())
        // {
        //     arr[indx]=pq.poll();
        //     indx++;
        // }
        for(int i=0;i<arr.length;i++)
        {
          pq.add(arr[i]);
          if(pq.size()>k)
          {
              arr[indx]=pq.poll();
              indx++;
          }
        }
        while(!pq.isEmpty())
        {
            arr[indx]=pq.poll();
            indx++;
        }
        
    }
}

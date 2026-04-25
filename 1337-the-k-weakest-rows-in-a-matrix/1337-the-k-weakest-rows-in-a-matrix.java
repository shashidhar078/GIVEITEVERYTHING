class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int count=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>(
            (a,b)->{
                if(a[0]==b[0])
                {
                    return b[1]-a[1]; //index tie
                }
                return b[0]-a[0]; //based upon the count
            }
        );
        for(int i=0;i<mat.length;i++)
        {
            count=0;
            for(int j=0;j<mat[i].length;j++)
            {
                if(mat[i][j]==1)
                {
                    count++;
                }
                else
                {
                    break;
                }
            }
            pq.add(new int[]{count,i});
            if(pq.size()>k)
            {
                pq.poll();
            }
        }
        int[] res=new int[k];
        for(int i=k-1;i>=0;i--)
        {
            res[i]=pq.poll()[1];
        }
        return res;
    }
}
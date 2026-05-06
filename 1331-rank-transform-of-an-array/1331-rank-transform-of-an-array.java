class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if(arr.length==0)
        {
            return arr;
        }
        HashMap<Integer,Integer> hs=new HashMap<>();
        int[] res=new int[arr.length];
        int count=1;
        int[] a=new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            a[i]=arr[i];
        }
        Arrays.sort(a);
        hs.put(a[0],count);
        for(int i=1;i<a.length;i++)
        {
            if(a[i]!=a[i-1])
            {
                count++;
                 hs.put(a[i],count);
            }
            else
            {
                hs.put(a[i],count);
            }
        }
        for(int i=0;i<arr.length;i++)
        {
            res[i]=hs.getOrDefault(arr[i],0);
        }
        return res;
    }
}
class Solution {
    public int candy(int[] ratings) {
        //this solution is slope intution based 
        int sum=1;
        int i=1;
        int n=ratings.length;
        int peak=0;
        int down=0;
        while(i<n)
        {
            if(ratings[i]==ratings[i-1])
            {
                sum=sum+1;
                i++;
                continue;
            }
            peak=1;
            while(i<n&&ratings[i]>ratings[i-1])
            {
                peak=peak+1;
                sum=sum+peak;
                i++;
            }
            down=1;
            while(i<n&&ratings[i]<ratings[i-1])
            {
                sum=sum+down;
                i++;
                 down=down+1;
            }
            if(down>peak)
            {
                sum+=(down-peak);
            }
        }
        return sum;
    }
}
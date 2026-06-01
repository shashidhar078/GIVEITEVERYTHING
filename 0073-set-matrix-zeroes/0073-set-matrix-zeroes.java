class Solution {
    public void setZeroes(int[][] matrix) {
        //we can make it simple by applying simple logic where we could 
        //go with following o(m+n) probably a better solution 

        int[] col=new int[matrix[0].length];
        int[] row=new int[matrix.length];
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
         for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(row[i]==1||col[j]==1)
                {
                   matrix[i][j]=0;
                }
            }
        }
        
    }
}
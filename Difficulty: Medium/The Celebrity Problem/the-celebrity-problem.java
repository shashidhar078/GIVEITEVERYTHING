class Solution {
    public int celebrity(int mat[][]) {
        // code here
        int n=mat.length;
       int top=0;
       int down=n-1;
       while(top<down)
       {
           if(mat[top][down]==1)
           {
               top++;
           }
           else if(mat[down][top]==1)
           {
               down--;
           }
           else
           {
               top++;
               down--;
           }
       }
       int j=0;
       for(int i=0;i<n;i++)
       {
           if(i==top)
           {
               continue;
           }
           if(mat[top][i]!=0||mat[i][top]!=1)
            {
                    return -1;
            }
       }
       return top;
    }
}
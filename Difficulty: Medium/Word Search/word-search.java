class Solution {
    public boolean isWordExist(char[][] mat, String word) {
        // Code here
         int n=mat.length;
        int m=mat[0].length;
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                
                if(mat[i][j]==word.charAt(0))
                {
                    if(search(i,j,mat,word,0,n,m))
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean search(int i,int j,char[][] mat,String word,int k,int n,int m)
    {
       
        if(k==word.length())
        {
            return true;
        }
        if(i<0||j<0||i==n||j==m||mat[i][j]!=word.charAt(k))
        {
            return false;
        }
        char ch=mat[i][j];
        mat[i][j]='#';
        boolean op1=search(i+1,j,mat,word,k+1,n,m);
        boolean op2=search(i,j+1,mat,word,k+1,n,m);
        boolean op3=search(i-1,j,mat,word,k+1,n,m);
        boolean op4=search(i,j-1,mat,word,k+1,n,m);
        mat[i][j]=ch;
        return op1||op2||op3||op4;
    }
}
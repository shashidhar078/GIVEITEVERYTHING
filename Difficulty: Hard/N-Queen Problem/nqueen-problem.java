class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> ls=new ArrayList<>();
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]='.';
            }
        }
        possibleQueen(ans,ls,n,board,0);
        return ans;
    }
    public static void possibleQueen(ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> ls,int n,char[][] board,int index)
    {
        if(index==n)
        {
            ans.add(new ArrayList<>(ls));
            return;
        }
        
        for(int i=0;i<n;i++)
        {
            if(ifPossible(i,index,board,n))
            {
                 board[i][index]='Q';
                 ls.add(i+1);
                 possibleQueen(ans,ls,n,board,index+1);
                 board[i][index]='.';
                 ls.remove(ls.size()-1);
            }
           
        }
       
    }
    public static boolean ifPossible(int row,int col,char[][] board,int n)
    {
        int r=row;
        int c=col;
        
        //lower left diagonal check 
        while(r<n&&c>=0)
        {
            if(board[r][c]=='Q')
            {
                return false;
            }
            r++;
            c--;
        }
        
        //left side check 
        
        r=row;
        c=col;
        
        while(c>=0)
        {
            if(board[r][c]=='Q')
            {
                return false;
            }
            c--;
        }
        
        
        //upper diagonal check 
        r=row;
        c=col;
        
        
        while(r>=0&&c>=0)
        {
            if(board[r][c]=='Q')
            {
                return false;
            }
            r--;
            c--;
        }
        
        
        return true;
    }
}
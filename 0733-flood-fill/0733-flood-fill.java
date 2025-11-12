class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            //understood flood filling alogorithm and its use case
            int oldColor=image[sr][sc];
            int n=image.length;
            int m=image[0].length;
            if(oldColor==color)
            {
                return image;
            }
            flood(sr,sc,image,oldColor,color,n,m);
            return image;
    }
    public static void flood(int i,int j,int[][] image,int oldColor,int newColor,int n,int m)
    {
        if(i<0||j<0||i==n||j==m||image[i][j]!=oldColor)
        return;
        image[i][j]=newColor;
        flood(i+1,j,image,oldColor,newColor,n,m);
        flood(i-1,j,image,oldColor,newColor,n,m);
        flood(i,j+1,image,oldColor,newColor,n,m);
        flood(i,j-1,image,oldColor,newColor,n,m);
    }
}
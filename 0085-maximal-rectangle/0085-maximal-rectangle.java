class Solution {
    public int maximalRectangle(char[][] matrix) {
            int maxArea=0;
            int n=matrix.length;
            int m=matrix[0].length;
            int area=0;
            int[][] preSum=new int[n][m];
            for(int j=0;j<m;j++)
            {
                int sum=0;
                for(int i=0;i<n;i++)
                {
                    int num=matrix[i][j]-'0';
                     sum+=num;
                    if(matrix[i][j]=='0')
                    {
                        sum=0;
                    }
                    preSum[i][j]=sum;
                }
            }
            for(int i=0;i<n;i++)
            {
                area=findMaxArea(preSum[i]);
                maxArea=Math.max(area,maxArea);
            }
            return maxArea;
    }
    public static int findMaxArea(int[] heights)
    {
         Stack<Integer> st=new Stack<>();
        int maxArea=0;
        int area=0;
        int pse=0;
        int nse=0;
        int n=heights.length;
        for(int i=0;i<heights.length;i++)
        {
            while(!st.isEmpty()&&heights[st.peek()]>heights[i])
            {
                int ele=st.peek();
                st.pop();
                pse=st.isEmpty()?-1:st.peek();
                area=heights[ele]*(i-pse-1);
                maxArea=Math.max(area,maxArea);
            }
            st.push(i);
        }
        while(!st.isEmpty())
        {
            nse=n;
            int ele=st.peek();
            st.pop();
            pse=st.isEmpty()?-1:st.peek();
            area=heights[ele]*(nse-pse-1);
            maxArea=Math.max(area,maxArea);
            
        }
        return maxArea;
    }
}
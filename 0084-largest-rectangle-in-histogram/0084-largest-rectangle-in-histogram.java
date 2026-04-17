class Solution {
    public int largestRectangleArea(int[] heights) {
        // int[] pse=new int[heights.length];
        // int[] nse=new int[heights.length];
        // pse=funPse(heights);
        // nse=funNse(heights);
        // int maxArea=0;
        // int area=0;
        // for(int i=0;i<heights.length;i++)
        // {
        //     area=heights[i]*(nse[i]-pse[i]-1);
        //     maxArea=Math.max(area,maxArea);
        // }
        // return maxArea;
        //optimal solution
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
    //brute force approach
    // public static int[] funNse(int[] arr)
    // {
    //     Stack<Integer> st=new Stack<>();
    //     ArrayList<Integer> res=new ArrayList<>();
    //     for(int i=arr.length-1;i>=0;i--)
    //     {
    //         if(st.isEmpty())
    //         {
    //             res.add(arr.length);
    //         }
    //         else if(!st.isEmpty()&&arr[st.peek()]<arr[i])
    //         {
    //             res.add(st.peek());
    //         }
    //         else if(!st.isEmpty()&&arr[st.peek()]>=arr[i])
    //         {
    //             while(!st.isEmpty()&&arr[st.peek()]>=arr[i])
    //             {
    //                 st.pop();
    //             }
    //             if(st.isEmpty())
    //             {
    //                 res.add(arr.length);
    //             }
    //             else
    //             {
    //                 res.add(st.peek());
    //             }
    //         }
    //         st.push(i);
    //     }
    //     Collections.reverse(res);
    //     int[] fres=new int[arr.length];
    //     for(int i=0;i<arr.length;i++)
    //     {
    //         fres[i]=res.get(i);
    //     }
    //     return fres;
    // }
    // public static int[] funPse(int[] arr)
    // {
    //     Stack<Integer> st=new Stack<>();
    //     ArrayList<Integer> res=new ArrayList<>();
    //     for(int i=0;i<arr.length;i++)
    //     {
    //         if(st.isEmpty())
    //         {
    //             res.add(-1);
    //         }
    //         else if(!st.isEmpty()&&arr[st.peek()]<arr[i])
    //         {
    //             res.add(st.peek());
    //         }
    //         else if(!st.isEmpty()&&arr[st.peek()]>=arr[i])
    //         {
    //             while(!st.isEmpty()&&arr[st.peek()]>=arr[i])
    //             {
    //                 st.pop();
    //             }
    //             if(st.isEmpty())
    //             {
    //                 res.add(-1);
    //             }
    //             else
    //             {
    //                 res.add(st.peek());
    //             }
    //         }
    //         st.push(i);
    //     }
    //     int[] fres=new int[arr.length];
    //     for(int i=0;i<arr.length;i++)
    //     {
    //         fres[i]=res.get(i);
    //     }
    //     return fres;
    // }
}
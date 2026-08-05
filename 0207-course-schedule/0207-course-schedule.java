class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> q=new LinkedList<>();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }

        int[] indegree=new int[numCourses];

        for(int i=0;i<prerequisites.length;i++)
            {
                int u = prerequisites[i][0];   // course
                int v = prerequisites[i][1];   // prerequisite

                adj.get(v).add(u);
                indegree[u]++;
            }


        for(int i=0;i<indegree.length;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }
        int count=0;
        while(!q.isEmpty())
        {
            int currnode=q.peek();
            q.remove();
            count++;
            for(int i:adj.get(currnode))
            {
                indegree[i]--;
               if(indegree[i]==0)
               {
                q.add(i);
               } 
            }
        }
        if(count==numCourses)
        {
            return true;
        }
        return false;
    }
}
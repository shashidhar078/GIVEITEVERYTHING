class Solution {
    boolean graphColoring(int v, int[][] edges, int m) {

        // Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<v; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e : edges){
            int u = e[0];
            int w = e[1];
            adj.get(u).add(w);
            adj.get(w).add(u);  // undirected
        }

        int[] color = new int[v];
        return solve(0, adj, m, v, color);
    }

    public static boolean solve(int node, ArrayList<ArrayList<Integer>> adj,
                                int m, int v, int[] color) {

        if(node == v) return true;

        for(int col = 1; col <= m; col++) {
            if(isPossible(node, adj, col, color)) {
                color[node] = col;

                if(solve(node + 1, adj, m, v, color))
                    return true;

                color[node] = 0; // backtrack
            }
        }

        return false;
    }

    public static boolean isPossible(int node, ArrayList<ArrayList<Integer>> adj,
                                     int col, int[] color) {

        for(int nei : adj.get(node)) {
            if(color[nei] == col)
                return false;
        }

        return true;
    }
}

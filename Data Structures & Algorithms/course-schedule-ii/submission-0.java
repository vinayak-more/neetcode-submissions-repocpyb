class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new LinkedList<>();
        int n = numCourses;
        for(int i = 0; i < n; i++){
            adjList.add(new LinkedList<>());
        }
        for(int[] edge : prerequisites){
            adjList.get(edge[0]).add(edge[1]);
        }
        List<Integer> order = topo(adjList);
        int[] result = new int[order.size()];
        int i = 0;
        for(int o : order){
            result[i++] = o;
        }
        return result;
    }

    private List<Integer> topo(List<List<Integer>> adj){
        int n = adj.size();
        List<Integer> list = new ArrayList<>(n);
        boolean[] visited = new boolean[n];
        boolean[] stack = new boolean[n];
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            if(hasCycle(adj, i, list, visited, stack)) return Collections.emptyList();
        }
        return list;
    }

    private boolean hasCycle(List<List<Integer>> adj, int i, List<Integer> order, boolean[] visited, boolean[] stack){
        if(stack[i]) return true;
        if(visited[i]) return false;
        stack[i] = true;
        for(int ne : adj.get(i)){
            if(hasCycle(adj, ne, order, visited, stack)) return true;
        }
        visited[i] = true;
        stack[i] = false;
        order.add(i);
        return false;
    }
}

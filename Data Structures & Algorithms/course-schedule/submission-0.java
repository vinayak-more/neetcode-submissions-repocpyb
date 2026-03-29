class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>(numCourses);
        for(int i = 0; i < numCourses; i++){
            adjList.add(new LinkedList<>());
        }
        for(int[] edge : prerequisites){
            adjList.get(edge[0]).add(edge[1]);
        }
        return !hasCycle(adjList);
    }

    private boolean hasCycle(List<List<Integer>> adjList){
        int n = adjList.size();
        boolean[] visited = new boolean[n];
        boolean[] stack = new boolean[n];
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            if(dfs(adjList, i, visited, stack)) return true;
        }
        return false;
    }

    private boolean dfs(List<List<Integer>> adjList, int node, boolean[] visited, boolean[] stack){
        if(stack[node]) return true;
        stack[node] = true;
        for(int ne : adjList.get(node)){
            if(dfs(adjList, ne, visited, stack)) return true;
        }
        visited[node] = true;
        stack[node] = false;
        return false;
    }
}

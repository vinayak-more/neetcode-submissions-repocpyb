class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       List<List<Integer>> adjList = buildAdjList(numCourses, prerequisites);
       boolean[] inStack = new boolean[numCourses];
       boolean[] visited = new boolean[numCourses];
       for(int i = 0; i < numCourses; i++){
            if(!visited[i]){
                Arrays.fill(inStack, false);
                boolean canFinish = dfs(adjList, i, visited, inStack);
                if(!canFinish) return false;

            }
       }
       return true;
    }

    private List<List<Integer>> buildAdjList(int numCourses, int[][] prerequisites){
        List<List<Integer>> adjList = new ArrayList<>(numCourses);
        for(int i = 0; i < numCourses; i++){
            adjList.add(new LinkedList<>());
        }
        for(int[] req : prerequisites ){
            adjList.get(req[1]).add(req[0]);
        }
        return adjList;
    }

    private boolean dfs(List<List<Integer>> adjList, int root, boolean[] visited, boolean[] inStack){
        inStack[root] = true;
        visited[root] = true;

        for(int node : adjList.get(root)){
            if(inStack[node]) return false;
            if(visited[node]) continue;
            if(!dfs(adjList, node, visited, inStack)) return false;
        }

        inStack[root] = false;
        return true;
    }
}

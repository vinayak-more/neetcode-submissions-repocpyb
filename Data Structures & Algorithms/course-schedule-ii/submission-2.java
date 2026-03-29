class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = buildAdjList(numCourses, prerequisites);
        Holder holder = new Holder(numCourses);
        for(int i = 0; i < numCourses; i++){
            if(!holder.visited[i]){
                boolean canFinish = dfs(adjList, i, holder);
                if(!canFinish) return new int[]{};
            }
        }
        return holder.result;
    }

    private boolean dfs(List<List<Integer>> adjList, int root, Holder holder) {
        holder.stack[root] = true;
        holder.visited[root] = true;

        for(int node : adjList.get(root)){
            if(holder.stack[node]) return false;
            if(holder.visited[node]) continue;
            boolean canFinish = dfs(adjList, node, holder);
            if(!canFinish) return false;
        }

        holder.stack[root] = false;
        holder.result[holder.count--] = root;
        return true;
    }

    private List<List<Integer>> buildAdjList(int numCourses, int[][] prereqs){
        List<List<Integer>> adjList = new ArrayList<>(numCourses);
        for(int i = 0; i < numCourses; i++){
            adjList.add(new LinkedList<>());
        }
        for(int[] pre : prereqs){
            adjList.get(pre[1]).add(pre[0]);
        }
        return adjList;
    }
}
class Holder{
    int[] result;
    boolean[] stack;
    boolean[] visited;
    int count;
    Holder(int n){ 
        this.count = n - 1;
        this.result = new int[n];
        this.stack = new boolean[n];
        this.visited = new boolean[n];

    }
}

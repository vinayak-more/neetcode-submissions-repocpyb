class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adjList = buildAdjList(n, times);
        int[] cost = new int[n+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int visited = 0;
        pq.offer(new int[]{k, 0});

        while(!pq.isEmpty() && visited < n){
            int[] node = pq.poll();
            if(node[1] < cost[node[0]] ){
                cost[node[0]] = node[1];
                for(int[] neighbor : adjList.get(node[0])){
                    pq.offer(new int[]{neighbor[0], neighbor[1] + cost[node[0]]});
                }
            }
        }

        int max = 0;
        for(int i = 1; i <= n; i++){
            max = Math.max(max, cost[i]);
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }

    private List<List<int[]>> buildAdjList(int n, int[][] times){
        List<List<int[]>> adjList = new ArrayList<>(n+1);
        for(int i = 0; i < n+1; i++){
            adjList.add(new LinkedList<>());
        }
        for(int[] time : times){
            adjList.get(time[0]).add(new int[] {time[1], time[2]}); //2 size array, 0th ele is to node, 1st ele is weight of edge
        }
        return adjList;
    }
}

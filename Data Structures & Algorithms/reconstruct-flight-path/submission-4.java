class Solution {
    private static final LinkedList<String> EMPTY_LIST = new LinkedList<String>();
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Queue<String>> adjMap = buildAdjMap(tickets);
        LinkedList<String> result = new LinkedList<>();
        dfs(adjMap, "JFK", result);
        return result;
    }

    private void dfs(Map<String, Queue<String>> map, String root, LinkedList<String> result){
        Queue<String> neighbor = map.getOrDefault(root, EMPTY_LIST);
        while(!neighbor.isEmpty()){
            String next = neighbor.poll();
            dfs(map, next, result);
        }
        result.addFirst(root);
    }

    private Map<String, Queue<String>> buildAdjMap(List<List<String>> tickets){
        Map<String, Queue<String>> map = new HashMap<>();
        for(List<String> ticket : tickets){
            map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        return map;
    }
}

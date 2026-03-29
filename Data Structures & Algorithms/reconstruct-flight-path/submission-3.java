class Solution {
    private static final LinkedList<String> EMPTY_LIST = new LinkedList<String>();
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, LinkedList<String>> adjMap = buildAdjMap(tickets);
        LinkedList<String> result = new LinkedList<>();
        dfs(adjMap, "JFK", result);
        return result;
    }

    private void dfs(Map<String, LinkedList<String>> map, String root, LinkedList<String> result){
        LinkedList<String> neighbor = map.getOrDefault(root, EMPTY_LIST);
        while(!neighbor.isEmpty()){
            String next = neighbor.removeFirst();
            dfs(map, next, result);
        }
        result.addFirst(root);
    }

    private Map<String, LinkedList<String>> buildAdjMap(List<List<String>> tickets){
        Map<String, LinkedList<String>> map = new HashMap<>();
        for(List<String> ticket : tickets){
            map.putIfAbsent(ticket.get(0), new LinkedList<>());
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        for(LinkedList<String> value : map.values()){
            Collections.sort(value);
        }
        return map;
    }
}

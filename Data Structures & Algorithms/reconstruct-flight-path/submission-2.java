class Solution {
    private static final LinkedList<String> EMPTY_LIST = new LinkedList<String>();
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, LinkedList<String>> adjMap = buildAdjMap(tickets);
        List<String> result = new LinkedList<>();
        dfs(adjMap, "JFK", result);
        Collections.reverse(result);
        return result;
    }

    private void dfs(Map<String, LinkedList<String>> map, String root, List<String> result){
        LinkedList<String> neighbor = map.getOrDefault(root, EMPTY_LIST);
        while(!neighbor.isEmpty()){
            String next = neighbor.removeFirst();
            dfs(map, next, result);
            //neighbor.addFirst(next);
        }
        result.add(root);
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

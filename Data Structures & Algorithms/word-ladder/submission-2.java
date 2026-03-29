class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Map<String, List<String>> adj = new HashMap<>();
        updateAdj(beginWord, wordList, 0, adj);
        for(int i = 0; i < wordList.size(); i++){
            updateAdj(wordList.get(i), wordList, i + 1, adj);
        }
        return bfs(beginWord, endWord, adj);
        
    }

    private void updateAdj(String source, List<String> wordList, int index, Map<String, List<String>> adj){
        for(int i = index; i < wordList.size(); i++){
            String word = wordList.get(i);
            if(isNeighbour(source, word)){
                adj.putIfAbsent(source, new LinkedList<>());
                adj.putIfAbsent(word, new LinkedList<>());
                adj.get(word).add(source);
                adj.get(source).add(word);
            }
        }
    }

    private boolean isNeighbour(String a, String b){
        int count = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) count++;
            if(count > 1) return false;
        }
        return count == 1;
    }

    private int bfs(String source, String target, Map<String, List<String>> adj){
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(source);
        visited.add(source);
        int level = 0;
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++){
                String node = queue.poll();
                if(node.equals(target)) return level + 1;
                if(!adj.containsKey(node)) continue;
                for(String neb : adj.get(node)){
                    if(visited.contains(neb)) continue;
                    visited.add(neb);
                    queue.offer(neb);
                }
            }
            level++;
        }
        return 0;
    }
}

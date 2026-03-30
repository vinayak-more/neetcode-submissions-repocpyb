class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adj = buildAdj(words);
        LinkedList<Character> result = new LinkedList<>();
        Set<Character> visited = new HashSet<>();
        Set<Character> stack = new HashSet<>();

        for(char c : adj.keySet()){
            if(!visited.contains(c) && dfs(c, adj, visited, stack, result)){
                return "";
            }
        }
        StringBuilder sb = new StringBuilder();
        result.forEach(c -> sb.append(c));
        return sb.toString();
    }

    private boolean dfs(char c, 
        Map<Character, Set<Character>> adj, 
        Set<Character> visited, 
        Set<Character> stack,
        LinkedList<Character> result){
            visited.add(c);
            stack.add(c);

            for(char neb : adj.get(c)){
                if(stack.contains(neb)) return true;
                if(visited.contains(neb)) continue;
                if(dfs(neb, adj, visited,stack, result)) return true;
            }

            stack.remove(c);
            result.addFirst(c);
            return false;
    }

    private Map<Character, Set<Character>> buildAdj(String[] words){
        Map<Character, Set<Character>> adj = new HashMap<>();
        for(String word : words){
            for(char c : word.toCharArray()){
                if(!adj.containsKey(c))
                    adj.put(c, new HashSet<>());
            }
        }

        for(int i = 0; i < words.length - 1; i++){
            String w1 = words[i];
            String w2 = words[i + 1];
            int minLength = Math.min(w1.length(), w2.length());
            if(w1.length() > w2.length() 
            && w1.substring(0, minLength).equals(w2)) return Collections.emptyMap();
            for(int j = 0; j < minLength; j++){
                if(w1.charAt(j) != w2.charAt(j)){
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }
        return adj;
    }

    
}

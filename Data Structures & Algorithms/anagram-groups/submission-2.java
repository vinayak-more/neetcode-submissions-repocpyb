class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        char[] chars;
        String key;
        for(String str : strs){
            chars = str.toCharArray();
            Arrays.sort(chars);
            key = new String(chars);
            map.putIfAbsent(key, new LinkedList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}

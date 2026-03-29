class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
List<List<String>> result = new LinkedList<>();
List<String> temp;
Map<Character, Integer> freq;
for(int i = 0; i < strs.length; i++){
	if(strs[i] == null) continue;
	temp = new LinkedList<>();
	temp.add(strs[i]);
	freq = getFreqMap(strs[i]);
	for(int j = i + 1; j < strs.length; j++){
		if(strs[j] == null) continue;
		if(isAnagram(freq, strs[j])){
			temp.add(strs[j]);
			strs[j] = null;
}
}
result.add(temp);
}
return result;
    }

    public boolean isAnagram(Map<Character, Integer> sFreq, String t){
		Map<Character, Integer> freq = new HashMap<>(sFreq);
		for(char character : t.toCharArray()){
			if(!freq.containsKey(character)) return false;
			freq.compute(character, (key, value)-> value == 1 ? null : value - 1);
}
return freq.isEmpty();
    }
	
	public Map<Character, Integer> getFreqMap(String s){
	Map<Character, Integer> freq = new HashMap<>();
		for(char character : s.toCharArray()){
			freq.put(character, freq.getOrDefault(character, 0) + 1);
}
return freq;

}
}




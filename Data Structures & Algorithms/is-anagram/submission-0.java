class Solution {
    public boolean isAnagram(String s, String t) {
if(s.length() != t.length()) return false;
		
		Map<Character, Integer> freq = new HashMap<>();
		for(char character : s.toCharArray()){
			freq.put(character, freq.getOrDefault(character, 0) + 1);
}
for(char character : t.toCharArray()){
	if(!freq.containsKey(character)) return false;
	freq.compute(character, (key, value) -> value == 1 ? null : value - 1);
}
return freq.isEmpty();

    }
}

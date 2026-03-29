class Solution {
    public boolean checkInclusion(String s1, String s2) {
        	Map<Character, Integer> freq = getFreqMap(s1);
		
		int start = 0, end = 0;
		while(end < s2.length()){
			if(freq.containsKey(s2.charAt(end))){
				Map<Character, Integer> temp = new HashMap<>(freq);
				while(end < s2.length()){
					if(!temp.containsKey(s2.charAt(end))) break;
					temp.compute(s2.charAt(end), (key,value)-> value == 1 ? null : value - 1);
					end++;
				}
				if(temp.isEmpty()) return true;
			}
				start++;
				end = start;
			
		}
		return false;
	}
	
	private Map<Character, Integer> getFreqMap(String str){
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < str.length(); i++){
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
		}
		return map;
	}

}

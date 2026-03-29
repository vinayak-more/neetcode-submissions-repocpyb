class Solution {
    public boolean checkInclusion(String s1, String s2) {
		if(s1.length() > s2.length()) return false;

		int[] s1Map = new int[26];
		int[] s2Map = new int[26];
		
		for(int i = 0; i < s1.length(); i++){
			s1Map[s1.charAt(i) - 'a']++;

		}

		for(int i = 0; i < s1.length() - 1; i++){
			s2Map[s2.charAt(i) - 'a']++;

		}
				
		int start = 0, end = s1.length() - 1;
		while(end < s2.length()){
			s2Map[s2.charAt(end) - 'a']++;
			if(matches(s1Map, s2Map)) return true;
			s2Map[s2.charAt(start) - 'a']--;
			start++;
			end++;
		}	
		return false;
        }

	private boolean matches(int[] a, int[] b){
		for(int i = 0; i < a.length; i++){
			if(a[i] != b[i]) return false;
		}
		return true;
	}

}

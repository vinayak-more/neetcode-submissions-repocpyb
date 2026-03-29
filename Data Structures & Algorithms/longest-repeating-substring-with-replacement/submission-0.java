class Solution {
    public int characterReplacement(String s, int k) {
        	int[] freq = new int[26];
		int start = 0, end = start, max = 0;
		while(end < s.length()){
			freq[s.charAt(end) - 'A']++;
			while(!validWindow(freq, k)){
				freq[s.charAt(start) - 'A']--;
				start++;
			}
			max = Math.max(max, end - start + 1);
			end++;
		}
		return max;
	}

	private boolean validWindow(int[] freq, int k){
		int max = 0, sum = 0;
		for(int i = 0; i < freq.length; i++){
			sum += freq[i];
			max = Math.max(max, freq[i]);
		}
		return (sum - max) <= k;
	}

}

class Solution {
    public int lengthOfLongestSubstring(String str) {
        int start = 0, end = -1, max = 0;
		Set<Character> set = new HashSet<>();
		while(end < str.length() - 1){
			end++;	
			while(set.contains(str.charAt(end))){
				set.remove(str.charAt(start));
				start++;
			}
			set.add(str.charAt(end));
			max = Math.max(max, end - start + 1);
		}
		return max;

    }
}

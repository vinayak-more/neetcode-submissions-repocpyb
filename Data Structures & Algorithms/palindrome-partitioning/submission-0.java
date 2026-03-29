class Solution {
 public List<List<String>> partition(String str) {
		List<List<String>> result = new LinkedList<>();
		solve(str, 0, new LinkedList<>(), result);
        	return result;
    	}
	
	private void solve(String str, int index, Deque<String> dq, List<List<String>> result){
		if(index == str.length()){
			result.add(new ArrayList<>(dq));
			return;
		}
	
		for(int i = index; i < str.length(); i++){
			if(!isPalindrome(str, index, i)) continue;
			dq.addLast(str.substring(index, i+1));
			solve(str, i + 1, dq, result);
			dq.removeLast();
		}
	}
	
	private boolean isPalindrome(String str, int start, int end){
		while(start < end){
			if(str.charAt(start) != str.charAt(end)) return false;
			start++;
			end--;
		}
		return true;
	}

}

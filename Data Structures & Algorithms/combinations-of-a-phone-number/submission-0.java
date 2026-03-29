class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return Collections.emptyList();

        char[][] letters = new char[digits.length()][];
		int i = 0;
		for(char ch : digits.toCharArray()){
			letters[i++] = getLetters(ch);
		}
		List<String> result = new LinkedList<>();
		solve(letters, 0, new StringBuilder(), result);
		return result;
    	}
	
	private void solve(char[][] letters, int index, StringBuilder sb, List<String> result){
		if(index == letters.length){
			result.add(sb.toString());
			return;
		}
		
		for(int i = 0 ; i < letters[index].length; i++){
			sb.append(letters[index][i]);
			solve(letters, index + 1, sb, result);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
	
	private char[] getLetters(char digit){
		switch(digit){
			case '2' : return new char[]{'a','b','c'};
			case '3' : return new char[]{'d','e','f'};
			case '4' : return new char[]{'g','h','i'};
			case '5' : return new char[]{'j','k','l'};
			case '6' : return new char[]{'m','n','o'};
			case '7' : return new char[]{'p','q','r', 's'};
			case '8' : return new char[]{'t','u','v'};
			case '9' : return new char[]{'w','x','y', 'z'};
			default : return new char[0];
		}
	}

}

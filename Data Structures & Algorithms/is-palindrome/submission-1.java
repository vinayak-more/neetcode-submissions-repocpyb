class Solution {
    public boolean isPalindrome(String str){
		if(str == null || str.length() == 0 ) return false;
		if(str.length() == 1 ) return true;
		
		int left = 0, right = str.length() - 1;
		
		while(left < right){
			while(!isAlphaNumeric(str.charAt(left)) && left < right) left++;
			while(!isAlphaNumeric(str.charAt(right)) && left < right) right--;
			if(!isEqual(str.charAt(left), str.charAt(right))) return false;
			left++;
			right--;
		}
		
		return true;
	}

	private boolean isAlphaNumeric(char ch){
		return 	(ch >= 'a' && ch <='z') ||
			(ch >= 'A' && ch <='Z') ||
			(ch >= '0' && ch <='9');
	}
	
	private boolean isEqual(char a, char b){
		if( a >= 'A' && a <='Z' ) a += 32;
		if( b >= 'A' && b <='Z' ) b += 32;
		return a == b;
		
	}
}

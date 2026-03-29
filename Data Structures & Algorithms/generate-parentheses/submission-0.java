class Solution {
    public List<String> generateParenthesis(int n){
		List<String> result = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		solve(0, 0, n, sb, result);
		return result;
	}

	private void solve(int open, int close, int n, StringBuilder sb, List<String> result){
		if(open == n && close == n){
			result.add(sb.toString());
			return;
		}
		if(open < n ){
			sb.append("(");
			solve(open + 1, close, n, sb, result);
			sb.deleteCharAt(sb.length() - 1);
		}
		if(close < open){
			sb.append(")");
			solve(open, close + 1, n, sb, result);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

}

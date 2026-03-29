class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Boolean[][] dp = new Boolean[s.length()][s.length()];
        return solve(s, 0, 0, dict, new StringBuilder(), dp);
    }

    private boolean solve(String s, int index, int end, Set<String> dict, StringBuilder sb, Boolean[][] dp){
        if(end == s.length()) return sb.isEmpty();
        if(dp[index][end] != null) return dp[index][end];
        sb.append(s.charAt(end));
        if(dict.contains(sb.toString())){
            return dp[index][end] = solve(s, end, end + 1, dict, new StringBuilder(), dp) || solve(s, index, end + 1, dict, sb, dp);
        } else {
            return dp[index][end] = solve(s, index, end + 1, dict, sb, dp);
        }
    }
}

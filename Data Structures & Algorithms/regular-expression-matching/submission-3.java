class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()+1][p.length()+1];
        return solve(s, 0, p, 0, dp);
    }

    private boolean solve(String s, int i, String p, int j, Boolean[][] dp){
        if(i == s.length() && j == p.length()) return true;
        if(i == s.length()) return j == p.length() - 2 && p.charAt(j+1) == '*' ? true : false;
        if(j == p.length()) return false;
        if(dp[i][j] != null) return dp[i][j];
        if(j + 1 < p.length() && p.charAt(j + 1) == '*'){
            if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
                return  dp[i][j] = solve(s, i, p, j+2, dp) ||
                        solve(s, i+1, p, j, dp) ||
                        solve(s, i+1, p, j + 2, dp);
            } else {
                return dp[i][j] = solve(s, i, p, j+2, dp);
            }
        }
        if(p.charAt(j) == '.' || s.charAt(i) == p.charAt(j) ) 
            return dp[i][j] = solve(s, i+1, p, j + 1, dp);
        return dp[i][j] = false;
    }
}

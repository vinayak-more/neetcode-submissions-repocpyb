class Solution {
    public int numDistinct(String s, String t) {
        return solve(0, 0, s, t, new Integer[s.length()][t.length()]);
    }

    private int solve(int i, int j, String s, String t, Integer[][] dp){
        if(j == t.length()) return 1;
        if( i == s.length()) return 0;
        if(dp[i][j] != null) return dp[i][j];
        
        int total = solve(i+1, j, s, t, dp);
        if(s.charAt(i) == t.charAt(j))
            total += solve(i+1, j+1, s, t, dp);
            
        return dp[i][j] = total;
    }
}

class Solution {
    private String s1;
    private String s2;
    private String s3;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];
        return solve(0, 0, 0, dp);

    }

    private boolean solve(int i, int j, int k, Boolean[][] dp){
        if(i == s1.length() && j == s2.length()) return true;

        if(dp[i][j] != null) return dp[i][j];
        if(i < s1.length() && j < s2.length() && s1.charAt(i) == s2.charAt(j) && s2.charAt(j) == s3.charAt(k)){
            return dp[i][j] =  solve(i + 1, j, k + 1, dp) || solve(i, j + 1, k + 1, dp);
        }
        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)){
            return dp[i][j] =  solve(i + 1, j, k + 1, dp);
        }
        if(j < s2.length() && s2.charAt(j) == s3.charAt(k)){
            return dp[i][j] = solve(i, j + 1, k + 1, dp);
        }
        return dp[i][j] = false;
    }
}

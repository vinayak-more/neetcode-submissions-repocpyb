class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] dp = new Integer[text1.length()][text2.length()];
        return solve(text1.toCharArray(), 0, text2.toCharArray(), 0, dp);
    }

    private Integer solve(char[] ch1, int i, char[] ch2, int j, Integer[][] dp){
        if(i == ch1.length || j == ch2.length) return 0;
        if(dp[i][j] != null) return dp[i][j];
        if(ch1[i] == ch2[j]) return dp[i][j] = solve(ch1, i+1, ch2, j+1, dp) + 1;
        return dp[i][j] = Math.max(solve(ch1, i + 1, ch2, j, dp), solve(ch1, i, ch2, j + 1, dp));
    }
}

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for(int i = text1.length() - 1; i >= 0; i--){
            for(int j = text2.length() - 1; j >= 0; j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                } 
            }
        }
        return dp[0][0];
        
    }

    public int longestCommonSubsequence1(String text1, String text2) {
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

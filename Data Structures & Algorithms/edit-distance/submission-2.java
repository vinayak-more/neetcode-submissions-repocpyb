class Solution {
    String s;
    String t;
    public int minDistance(String word1, String word2) {
        s = word1;
        t = word2;
        //Integer[][] dp = new Integer[s.length()][t.length()];
        //return solve(0, 0, dp);
        return solve(s, t);
    }

    private int solve(int i, int j, Integer[][] dp){
        if(i == s.length()){
            return t.length() - j;
        }
        if( j == t.length()){
            return s.length() - i;
        }
        if(dp[i][j] != null) return dp[i][j];

        int cost = Integer.MAX_VALUE;
        if(s.charAt(i) == t.charAt(j)){
            cost = solve(i + 1, j + 1, dp);
        }
        else {
            cost = Math.min(solve(i, j + 1, dp) + 1, solve(i + 1, j, dp) + 1);
            cost = Math.min(solve(i + 1, j + 1, dp) + 1, cost);
        }
        return dp[i][j] = cost;
    }

    private int solve(String s, String t){
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        dp[s.length()][t.length()] = 0;
        for(int j = 0; j < t.length(); j++){
            dp[s.length()][j] = t.length() - j;
        }
        for(int i = 0; i < s.length(); i++){
            dp[i][t.length()] = s.length() - i;
        }

        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = t.length() - 1; j >= 0; j--){
                if(s.charAt(i) == t.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                }else{
                    dp[i][j] = Math.min(dp[i+1][j+1], Math.min(dp[i+1][j], dp[i][j+1])) + 1;
                }
            }
        }
        return dp[0][0];
    }
}

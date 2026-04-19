class Solution {
    String s;
    String t;
    public int minDistance(String word1, String word2) {
        s = word1;
        t = word2;
        Integer[][] dp = new Integer[s.length()][t.length()];
        return solve(0, 0, dp);
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
}

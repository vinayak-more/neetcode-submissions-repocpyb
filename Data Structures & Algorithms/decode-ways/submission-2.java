class Solution {
    public int numDecodings(String s) {
        return solve(0, s, new int[s.length()]);
    }

    private int solve(int index, String str, int[] dp){
        if(index > str.length()) return 0;
        if(index == str.length()) return 1;
        if(str.charAt(index) == '0') return 0;
        if(dp[index] != 0) return dp[index];
        if(str.charAt(index) == '1'){
            if(index + 1 < str.length()
                && '0' == str.charAt(index + 1)){
                    return dp[index] = solve(index + 2, str, dp);
                }
            return dp[index] = solve(index + 1, str, dp)
            + solve(index + 2, str, dp);
        }
        else if(str.charAt(index) == '2'){
            if  ( 
                index + 1 < str.length()
                && '0' <= str.charAt(index + 1)
                && str.charAt(index + 1) <= '6'
                ){
                    return dp[index] = solve(index + 1, str, dp)
                    + solve(index + 2, str, dp);
            } else {
                return dp[index] = solve(index + 1, str, dp);
            }
        }
        else {
            return dp[index] = solve(index + 1, str, dp);
        }
    }
}

class Solution {
    public int numDecodings(String s) {
        return solve(0, s, new int[s.length()]);
    }

    private int solve(int index, String str, int[] dp){
        if(index == str.length()) return 1;
        if(str.charAt(index) == '0') return 0;
        if(dp[index] != 0) return dp[index];
        
        int result = solve(index + 1, str, dp);
        if( index + 1 < str.length()
        && (str.charAt(index) == '1' || 
        (str.charAt(index) == '2' && str.charAt(index + 1) < '7'))){
            result +=solve(index + 2, str, dp);
        }
        return dp[index] = result;
    }
}

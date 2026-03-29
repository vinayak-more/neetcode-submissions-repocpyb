class Solution {
    public int climbStairs(int n) {
        
        return fibo(n, new int[n+1]);
    }

    public int fibo(int n, int[] dp){
        if( n <= 2) return n;
        if(dp[n] != 0) return dp[n];
        return dp[n] = fibo(n - 1, dp) + fibo(n - 2, dp);
    }
}

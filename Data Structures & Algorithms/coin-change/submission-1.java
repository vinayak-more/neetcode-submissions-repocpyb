class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        //Arrays.fill(dp, -1);
        int ans = solve(coins, coins.length - 1, amount, dp);
        if(ans >= Short.MAX_VALUE) return -1;
        return ans;
    }

    private int solve(int[] coins, int index, int amount, int[][] dp){
        if(index < 0) return Short.MAX_VALUE;
        if( amount == 0) return 0;
        if(dp[index][amount] != 0) return dp[index][amount];
        if(amount >= coins[index]){
            return dp[index][amount] = min( 
                solve(coins, index, amount - coins[index], dp) + 1,
                solve(coins, index - 1, amount - coins[index], dp) + 1,
                solve(coins, index - 1, amount, dp)
            );
        }else {
            return dp[index][amount] = solve(coins, index - 1, amount, dp);
        }
    }

    private int min(int... nums){
        int min = nums[0];
        for(int n : nums){
            min = Math.min(min, n);
        }
        return min;
    }
}

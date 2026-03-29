class Solution {
    public int coinChange(int[] coins, int cost) {
        if (cost == 0) return 0;
        int[][] dp = new int[coins.length][cost+1];
        //base cases
        //amount is 0 then we need 0 coins
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 0;
        }
        //when only the first coin is available
        for(int i = 1; i <= cost; i++){
            if (i % coins[0] == 0) dp[0][i] = i / coins[0];
            else dp[0][i] = Short.MAX_VALUE;
        }

        for(int index = 1; index < dp.length; index++){
            for(int amount = 1; amount < dp[index].length; amount++){
                if(amount >= coins[index]){
                    dp[index][amount] = min(
                        dp[index][amount - coins[index]] + 1,
                        dp[index - 1][amount]
                    );
                } else {
                    dp[index][amount] = dp[index - 1][amount];
                }
            }
        }
        int result = dp[coins.length - 1][cost];
        return result >= Short.MAX_VALUE ? -1 : result;
    }
    public int coinChangeRecursive(int[] coins, int amount) {
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

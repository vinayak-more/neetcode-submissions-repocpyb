class Solution {
    public int change(int amount, int[] coins) {
        return solve(coins, 0, amount, new int[coins.length][amount + 1]);
    }

    private int solve(int[] coins, int index, int amount, int[][] dp){
        if(amount == 0) return 1;
        if(index == coins.length) return 0;
        if(dp[index][amount] != 0) return dp[index][amount];
        int total = solve(coins, index + 1, amount, dp);
        if(coins[index] <= amount){
            total += solve(coins, index, amount - coins[index], dp);
        }
        return dp[index][amount] = total;
        
    }
}

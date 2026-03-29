class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[][] dp = new Integer[n][2];
        return solve(prices, 0, 1, dp); // start at day 0, can buy
    }

    private int solve(int[] prices, int index, int canBuy, Integer[][] dp) {
        if (index >= prices.length) return 0;

        if (dp[index][canBuy] != null) {
            return dp[index][canBuy];
        }

        int skip = solve(prices, index + 1, canBuy, dp);
        int take;

        if (canBuy == 1) {
            // Buy today
            take = -prices[index] + solve(prices, index + 1, 0, dp);
        } else {
            // Sell today (cooldown → index + 2)
            take = prices[index] + solve(prices, index + 2, 1, dp);
        }

        dp[index][canBuy] = Math.max(skip, take);
        return dp[index][canBuy];
    }
}

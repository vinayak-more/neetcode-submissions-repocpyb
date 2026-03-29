class Solution {
    private static final int BUY = 0;
    private static final int SELL = 1;
    public int maxProfit(int[] prices) {
        Integer[][] dp = new Integer[prices.length][2];
        return solve(prices, 0, BUY, 0, dp);
    }

    private int solve(int[] prices, int index, int action, int buyPrice, Integer[][] dp){
        if(index >= prices.length) return 0;
        if(action == BUY && dp[index][action] != null) return dp[index][action];
        if(action == BUY){
            return dp[index][action] = Math.max(
                solve(prices, index + 1, BUY, buyPrice, dp), //DONT BUY at this price
                solve(prices, index + 1, SELL, prices[index], dp) //BUY at this price
            );
        } else {
            return dp[index][action] = Math.max(
                solve(prices, index + 1, SELL, buyPrice, dp),
                solve(prices, index + 2, BUY, 0, dp) + (prices[index] - buyPrice)//SELL at this price
            );
        }
    }
}

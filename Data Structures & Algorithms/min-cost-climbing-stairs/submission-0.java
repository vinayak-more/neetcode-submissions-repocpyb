class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1);
        int costFromIndex0 = jump(cost, 0, dp);
        Arrays.fill(dp, -1);
        int costFromIndex1 = jump(cost, 1, dp);
        return Math.min(costFromIndex0, costFromIndex1);
    }

    private int jump(int[] cost, int index, int[] dp){
        if(index >= cost.length) return 0;
        if(dp[index] != -1) return dp[index];
        return dp[index] = Math.min(jump(cost, index + 1, dp), jump(cost, index + 2, dp)) + cost[index];
    }
}

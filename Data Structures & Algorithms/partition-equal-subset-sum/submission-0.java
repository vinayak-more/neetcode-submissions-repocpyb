class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 == 1) return false;
        Boolean[][] dp = new Boolean[nums.length][sum / 2 + 1];
        return solve(nums, 0, 0, sum / 2, dp);
    }

    private boolean solve(int[] nums, int index, int sum, int target, Boolean[][] dp){
        if(sum == target) return true;
        if(sum > target) return false;
        if(index == nums.length) return false;
        if(dp[index][sum] != null) return dp[index][sum];
        return dp[index][sum] = solve(nums, index + 1, sum + nums[index], target, dp) ||
                solve(nums, index + 1, sum, target, dp);
    }
}

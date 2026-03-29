class Solution {
    public int lengthOfLIS(int[] nums) {
        int max = 0;
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            max = Math.max(solve(nums, i, dp), max);
        }
        return max;
    }

    private int solve(int[] nums, int index, int[] dp){
        if(index == nums.length) return 0;
        if(dp[index] != 0) return dp[index];
        int max = 0;
        for(int i = index + 1; i < nums.length; i++){
            if(nums[i] > nums[index]){
                max = Math.max(max, solve(nums, i, dp));
            }
        }
        return max + 1;
    }
}

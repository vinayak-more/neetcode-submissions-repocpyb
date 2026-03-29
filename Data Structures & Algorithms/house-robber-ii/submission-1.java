class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int robFromIndex0 = rob(nums, 0, nums.length - 1, dp);
        Arrays.fill(dp, -1);
        int robFromIndex1 = rob(nums, 1, nums.length, dp);
        return Math.max(robFromIndex0, robFromIndex1);
    }

    public int rob(int[] nums, int index, int end, int[] dp){
        if(index >= end) return 0;
        if(dp[index] != -1) return dp[index];
        return dp[index] = Math.max(
                nums[index] + rob(nums, index + 2, end, dp), 
                rob(nums, index + 1, end, dp)
        );
    }
}

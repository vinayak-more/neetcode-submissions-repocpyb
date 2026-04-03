class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(0, nums, dp);
    }

    public int solve(int index, int[] nums, int[] dp){
        if(index >= nums.length - 1) return 0;
        if(dp[index] != -1) return dp[index];
        int min = 1000000;
        int start = index;
        int end = Math.min(nums.length - 1, index + nums[index]);
        for(int i = start + 1; i <= end; i++){
            min = Math.min(min, 1 + solve(i, nums, dp));
        }
        return dp[index] = min;
    }
}

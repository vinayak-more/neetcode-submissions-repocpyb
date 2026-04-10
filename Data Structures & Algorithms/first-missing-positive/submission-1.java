class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] < 0) nums[i] = 0;
        }

        for(int i = 0; i < n; i++){
            int value = Math.abs(nums[i]);
            if(1 <= value && value <= n){
                int index = value - 1;
                if(nums[index] == 0){
                    nums[index] = - (n+1);
                } else if(nums[index] > 0) {
                    nums[index] *= -1;
                }
            }
        }
        int i = 0;
        for(i = 1; i <= n; i++){
            if(nums[i - 1] >= 0) break;
        }
        return i;
    }
}
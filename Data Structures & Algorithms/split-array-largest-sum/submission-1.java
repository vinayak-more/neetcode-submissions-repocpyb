class Solution {
    public int splitArray(int[] nums, int k) {
        int left = Arrays.stream(nums).max().orElse(1);
        int right = Arrays.stream(nums).sum();
        int result = right;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(canSplit(nums, mid, k)){
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private boolean canSplit(int[] nums, int maxSum, int k){
        int curSum = 0;
        int subarrays = 1;
        for(int num : nums){
            curSum += num;
            if(curSum > maxSum){
                subarrays++;
                if(subarrays > k) return false;
                curSum = num;
            }
        }
        return true;
    }
}
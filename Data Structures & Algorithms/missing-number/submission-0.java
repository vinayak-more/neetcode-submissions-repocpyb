class Solution {
    public int missingNumber(int[] nums) {
        int mask = 0;
        for(int i = 0; i <= nums.length; i++){
            mask ^= i;
        }
        for(int num : nums){
            mask ^= num;
        }
        return mask;
    }
}

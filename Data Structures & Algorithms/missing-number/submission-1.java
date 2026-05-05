class Solution {
    public int missingNumber(int[] nums) {
        int mask = 0;
        mask ^= nums.length;
        for(int i = 0; i < nums.length; i++){
            mask ^= i;
            mask ^= nums[i];
        }
        return mask;
    }
}

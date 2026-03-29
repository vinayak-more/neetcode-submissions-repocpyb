class Solution {
    public int maxProduct(int[] nums) {
        int prefix = 0, suffix = 0, max = nums[0];

        for(int i = 0; i < nums.length; i++){
            prefix = nums[i] * (prefix == 0 ? 1 : prefix);
            suffix = nums[ nums.length - 1 - i] * (suffix == 0 ? 1 : suffix);
            max = Math.max(max , Math.max(prefix, suffix));
        }
        return max;
    }


}

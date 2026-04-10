class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int smallestPositive = 1;
        for(int num : nums){
            if(num <= 0 ) continue;
            if(num > smallestPositive){
                return smallestPositive;
            } else {
                smallestPositive = num + 1;
            }
        }
        return smallestPositive;
    }
}
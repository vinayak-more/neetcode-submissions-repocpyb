class Solution {
   public List<List<Integer>> threeSum(int[] nums){
		List<List<Integer>> result = new LinkedList<>();
		Arrays.sort(nums);
		int target;
		for(int i = 0; i < nums.length; i++){
			if(i > 0 && nums[i] == nums[i-1]) continue;
			target = -nums[i];
			int left = i + 1, right = nums.length - 1;
			int sum;
			while(left < right){
				sum = nums[left] + nums[right];
				if(sum == target){
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;
					right--;
					while(left < right && nums[left - 1] == nums[left]) left++;
					while(left < right && nums[right + 1] == nums[right]) right--;
				}
				else if(sum > target) right--;
				else left++;
			}
		}
		return result;
	}
}

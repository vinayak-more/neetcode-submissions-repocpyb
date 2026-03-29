class Solution {
    public int[] twoSum(int[] nums, int target) {
       		Map<Integer, Integer> location = new HashMap<>();
		int num;
		for(int i = 0; i < nums.length; i++){
			num = nums[i];
			if(location.containsKey(target - num)){
				return new int[]{location.get(target - num), i};
			}
			location.put(num, i);
}
return new int[0];
 
    }
}

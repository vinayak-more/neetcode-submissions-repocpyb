class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        	Map<Integer, Integer> freq = buildFreq(nums);
		List<List<Integer>> result = new LinkedList<>();
		nums = new int[freq.size()];
		int i =0;
		for(Integer key: freq.keySet()){
			nums[i++] = key;
		} 
		solve(nums, 0, freq, new LinkedList<>(), result);
		return result;
    	}
	
	private void solve(int[] nums, int index, Map<Integer, Integer> freq, Deque<Integer> dq, List<List<Integer>> result){
		if(index == nums.length) {
			result.add(new ArrayList<>(dq));
			return;
		}
		if(freq.get(nums[index]) == 0){
			solve(nums, index + 1, freq, dq, result);
			return;
		}
		solve(nums, index + 1, freq, dq, result);
		freq.put(nums[index], freq.get(nums[index]) - 1);
		dq.addLast(nums[index]);
		solve(nums, index, freq, dq, result);
		freq.put(nums[index], freq.get(nums[index]) + 1);
		dq.removeLast();
		
	}

	private Map<Integer, Integer> buildFreq(int[] nums){
		Map<Integer, Integer> freq = new HashMap<>();
		for(int num : nums){
			freq.put(num, freq.getOrDefault(num, 0) + 1);
		}
		return freq;
	}

}

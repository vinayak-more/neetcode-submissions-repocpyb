class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
		solve(nums, 0, new boolean[nums.length], new LinkedList<>(), result);
		return result;
    }
    private void solve(int[] nums, int index, boolean[] taken, Deque<Integer> dq, List<List<Integer>> result){
		if(index == nums.length){
			result.add(new ArrayList<>(dq));
			return;
		}
		for(int i = 0; i < nums.length; i++){
			if(taken[i]) continue;
			taken[i] = true;
			dq.addLast(nums[i]);
			solve(nums, index + 1, taken, dq, result);
			taken[i] = false;
			dq.removeLast();
		}
	}

}

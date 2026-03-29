class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
		solve(nums, 0, new LinkedList<>(), result);
		return result;
    }
    private void solve(int[] nums, int index, Deque<Integer> dq, List<List<Integer>> result){
		if(index == nums.length){
			result.add(new ArrayList<>(dq));
			return;
		}
		solve(nums, index + 1, dq, result);
		dq.addLast(nums[index]);
		solve(nums, index + 1, dq, result);
		dq.removeLast();
	}

}

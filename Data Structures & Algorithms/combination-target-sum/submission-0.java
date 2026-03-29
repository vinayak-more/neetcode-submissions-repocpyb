class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
		solve(nums, 0, 0, target, new LinkedList<>(), result);
		return result;
    }
    private void solve(int[] nums, int index, int sum, int target, Deque<Integer> dq, List<List<Integer>> result){
		if(sum == target){
			result.add(new ArrayList<>(dq));
			return;
		}
		if(sum > target) return;
		if(index == nums.length) return;
		solve(nums, index + 1, sum, target, dq, result);
		dq.addLast(nums[index]);
		solve(nums, index, sum + nums[index], target, dq, result);
		dq.removeLast();
	}
}

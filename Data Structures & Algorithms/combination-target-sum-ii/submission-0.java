class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        	Arrays.sort(candidates);
		Holder holder = new Holder();
		solve(candidates, 0, 0, target, holder);
		return holder.result;
    	}
	
	private void solve(int[] nums, int index, int sum, int target, Holder holder){
		if(sum == target){
			holder.result.add(new ArrayList<>(holder.dq));
			return;
		}
		if(sum > target || index == nums.length) return;
		holder.dq.addLast(nums[index]);
		solve(nums, index + 1, sum + nums[index], target, holder);
		holder.dq.removeLast();
		while(index + 1 < nums.length && nums[index] == nums[index+1]) index++;
		solve(nums, index + 1, sum, target, holder);
	} 
}

class Holder{
	Deque<Integer> dq = new LinkedList<>();
	List<List<Integer>> result = new LinkedList<>();
}

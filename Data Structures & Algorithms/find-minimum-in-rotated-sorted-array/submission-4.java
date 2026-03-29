class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.min(nums[0], nums[1]);

      int left = 0, right = nums.length - 1, mid;
		while(left < right){
			mid = (left + right)/2;
			if(mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid];
			else {
				if(nums[mid] < nums[0] ) right = mid - 1;
				else{
					if(nums[mid] > nums[right] ) left = mid + 1;
					else right = mid - 1;
				}
			}
		}
		return nums[left];

    }
}

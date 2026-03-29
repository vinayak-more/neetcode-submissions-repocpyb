class Solution {
        public int maxArea(int[] heights) {
        	int start = 0, end = heights.length - 1, max = 0;
		while(start < end ){
			max = Math.max(max, (end - start) * Math.min(heights[start], heights[end]));
			if(heights[start] < heights[end]) start++;
			else end--;
		}
		return max;
    	}
}

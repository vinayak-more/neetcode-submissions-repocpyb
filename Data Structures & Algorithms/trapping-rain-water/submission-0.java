class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        for(int i = 1; i < height.length; i++){
            left[i] = Math.max(left[i-1], height[i]);
        }
        right[height.length - 1] = height[height.length - 1];
        for(int i = height.length - 2; i >= 0; i--){
            right[i] = Math.max(right[i+1], height[i]);
        }
        int[] min = new int[height.length];
        for(int i = 0; i < min.length; i++){
            min[i] = Math.min(left[i], right[i]);
        }
        int result = 0;
        for(int i = 0; i < min.length; i++){
            result += (min[i] - height[i]);
        }
        return result;
    }
}

//0 2 0 3 1 0 1 3 2 1
//0 2 2 3 3 3 3 3 3 3
//3 3 3 3 3 3 3 3 2 1
//0 2 2 3 3 3 3 3 2 1
//0 0 2 0 2 3 2 0 0 0

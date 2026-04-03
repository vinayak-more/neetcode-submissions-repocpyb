class Solution {
    public boolean canJump(int[] nums) {
       int currMax = 0;
       int curr;
       Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
       queue.offer(new int[]{nums[0], 0});

       while(!queue.isEmpty() && currMax < nums.length - 1){
            int[] pos = queue.poll();
            while(pos[0] + pos[1] > currMax && currMax < nums.length - 1){
                currMax++;
                queue.offer(new int[]{nums[currMax], currMax});
            }
        }
        return currMax == nums.length - 1 ? true : false;
    }
}

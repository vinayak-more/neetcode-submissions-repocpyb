class KthLargest {

    Queue<Integer> queue;
    int k;

    public KthLargest(int k, int[] nums) {
        this.queue = new PriorityQueue<>();
        this.k = k;
        for(int num : nums){
            add(num);
        }
    }
    
    public int add(int val) {
        queue.offer(val);
        if(queue.size() > k) queue.poll();
        return queue.peek();
    }
}

class MedianFinder {
    private final Queue<Integer> minHeap;
    private final Queue<Integer> maxHeap;
    int size;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        size = 0;
    }
    
    public void addNum(int num) {
        size++;
        maxHeap.offer(num);
        if(maxHeap.size() - minHeap.size() > 1){
            minHeap.offer(maxHeap.poll());
        }
        if(!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()){
            int temp = minHeap.poll();
            minHeap.offer(maxHeap.poll());
            maxHeap.offer(temp);
        }
        System.out.println(maxHeap + " : " + minHeap);
    }
    
    public double findMedian() {
        if(size % 2 == 0)
            return (maxHeap.peek() + minHeap.peek()) / 2d;
        else return maxHeap.peek();
    }
}

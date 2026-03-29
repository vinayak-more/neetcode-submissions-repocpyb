class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> b - a); //Max Heap
        for(int s : stones){
            pq.offer(s);
        }
        int x, y;
        while(pq.size() > 1){
            x = pq.poll();
            y = pq.poll();
            pq.offer(x - y);
        }
        return pq.peek();
    }
}

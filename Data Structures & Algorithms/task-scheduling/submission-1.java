class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        for(char task : tasks){
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }
        Queue<Task> pq = new PriorityQueue<>();
        Queue<Task> queue = new LinkedList<>();
        for(Integer count : freq.values()){
            queue.offer(new Task(count));
        }

        int curr = 0;
        Task task;
        while(!queue.isEmpty() || !pq.isEmpty()){
            while( !queue.isEmpty() && queue.peek().clock < curr) pq.offer(queue.poll());
            if(!pq.isEmpty()){
                task = pq.poll();
                task.count--;
                if(task.count > 0){
                    task.clock = curr + n;
                    queue.offer(task);
                }
            }
            curr++;
        }

        return curr-1;

    }
}
class Task implements Comparable<Task>{
    int count = 0;
    int clock = 0;

    Task(int count){
        this.count = count;
    }

    public int compareTo(Task other){
        return other.count - this.count;
    }
}

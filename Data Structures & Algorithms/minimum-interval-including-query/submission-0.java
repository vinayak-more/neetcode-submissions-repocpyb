class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] result = new int[queries.length];
        int[][] query = new int[queries.length][2];
        for(int i = 0; i < queries.length; i++){
            query[i][0] = queries[i];
            query[i][1] = i;
        }
        Queue<int[]> queue = new PriorityQueue<>((a,b) -> (a[1] - a[0] + 1) - (b[1] - b[0] + 1));
        Arrays.sort(query, (a,b)-> a[0] - b[0]);
        Arrays.sort(intervals, (a,b)-> a[0] - b[0]);
        int intervalIndex = 0;
        for(int i = 0; i < query.length; i++){
            // while(intervalIndex < intervals.length && 
            //         !(intervals[intervalIndex][0] <= query[i][0] && 
            //     query[i][0] <= intervals[intervalIndex][1])){
            //         intervalIndex++;
            //     }
            while(intervalIndex < intervals.length && 
                intervals[intervalIndex][0] <= query[i][0]){
                queue.offer(intervals[intervalIndex]);
                intervalIndex++;
            }
            while(!queue.isEmpty() && queue.peek()[1] < query[i][0]) queue.poll();
            //queue.forEach(arr -> System.out.print(Arrays.toString(arr)+","));
            //System.out.println();
            if(queue.isEmpty()) result[query[i][1]] = -1;
            else result[query[i][1]] = queue.peek()[1] - queue.peek()[0] + 1; 
        }
        return result;
    }
}

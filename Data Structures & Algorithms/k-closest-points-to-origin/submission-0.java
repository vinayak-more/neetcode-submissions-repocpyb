class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<Point> queue = new PriorityQueue<>();
        for(int[] point : points){
            queue.offer(new Point(point));
            if(queue.size() > k) queue.poll();
        }
        int[][] result = new int[k][];
        for(int i = 0; i < k; i++){
            result[i] = queue.poll().coordinates;
        }
        return result;

    }
}
class Point implements Comparable<Point>{
    int[] coordinates;
    int distance;

    Point(int[] co){
        this.coordinates = co;
        distance = co[1] * co[1] + co[0] * co[0];
    }

    public int compareTo(Point point){
        return point.distance - this.distance;
    }

}

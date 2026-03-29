class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) ->{
            if(a[1] == b[1]) return b[0] - a[0];
            return a[1] - b[1];
        });
        int remove = 0;
        int[] prev = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            if(isNonOverlapping(prev, intervals[i])){
               prev = intervals[i];
            } else {
                remove++;
            }
        }
        return remove;
    }

    private boolean isNonOverlapping(int[] a, int[] b){
        return a[1] <= b[0];
    }
}

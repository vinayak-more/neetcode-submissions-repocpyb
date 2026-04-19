class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, int[]> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.putIfAbsent(s.charAt(i), new int[]{i, i});
            map.get(s.charAt(i))[1] = i;
        }
        List<int[]> intervals = new ArrayList<>(map.values());
        List<int[]> nonOverlappingIntervals = nonOverlappingIntervals(intervals);
        List<Integer> result = new LinkedList<>();
        for(int[] interval : nonOverlappingIntervals){
            result.add(interval[1] - interval[0] + 1);
        }
        return result;
    }

    private List<int[]> nonOverlappingIntervals(List<int[]> intervals){
        Collections.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] prev = intervals.remove(0);
        List<int[]> result = new LinkedList<>();
        for(int[] interval : intervals){
            if(prev[1] <= interval[0]){
                result.add(prev);
                prev = interval;
            } else {
                prev[1] = Math.max(prev[1], interval[1]);
            }
        }
        result.add(prev);
        return result;
    }
}

class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        List<int[]> list = new LinkedList<>();
        for(int[] triple : triplets){
            if(triple[0] <= target[0] && triple[1] <= target[1] && triple[2]<= target[2]){
                list.add(triple);
            }
        }
        if(list.isEmpty()) return false;
        int[] result = list.get(0);
        list.remove(0);
        for(int[] t : list){
            result[0] = Math.max(result[0], t[0]);
            result[1] = Math.max(result[1], t[1]);
            result[2] = Math.max(result[2], t[2]);
        }
        if(result[0] == target[0] && result[1] == target[1] && result[2] == target[2]){
            return true;
        } else {
            return false;
        }
    }
}

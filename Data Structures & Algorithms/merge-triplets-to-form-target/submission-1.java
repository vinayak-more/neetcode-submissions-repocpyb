class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> found = new HashSet<>();
        for(int[] triple : triplets){
            if(triple[0] <= target[0] && triple[1] <= target[1] && triple[2]<= target[2]){
                for(int i = 0; i < target.length; i++){
                    if(triple[i] == target[i]){
                        found.add(i);
                    }
                }
            }
        }
        return found.size() == 3;
    }
}

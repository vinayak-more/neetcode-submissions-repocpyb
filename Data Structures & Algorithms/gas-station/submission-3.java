class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) return -1;
        int bal = 0;
        int max = Integer.MIN_VALUE, startIndex = 0;
        for(int i = 0; i < gas.length; i++){
            bal += (gas[i] - cost[i]);
            if(bal < 0){
                bal = 0;
                startIndex = i + 1;
            }
        }
        return startIndex;
    }
}

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        if(groupSize == 1) return true;
        Arrays.sort(hand);
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int num : hand){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        while(!map.isEmpty()){
            Integer cur = map.firstKey() - 1;
            System.out.println(map);
            for(int i = 0; i < groupSize; i++){
                if(map.isEmpty()) return false;
                if(!map.containsKey(cur + 1)) return false;
                cur = cur + 1;
                if(map.get(cur) == 1) map.remove(cur);
                else map.put(cur, map.get(cur) - 1);
            }
        }
        return true;
    }
}

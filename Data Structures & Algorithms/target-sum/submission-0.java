class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(0, nums, target, new HashMap<>());
    }

    public int solve(int index, int[] nums, int target, Map<Pair, Integer> map){
        if(index == nums.length) return target == 0 ? 1 : 0; 
        Pair p = new Pair(index, target);
        if(map.containsKey(p)) return map.get(p);
        int ways = solve(index + 1, nums, target + nums[index], map) 
                + solve(index + 1, nums, target - nums[index], map);
        map.put(p, ways);
        return ways;
    }
}
class Pair{
    int a; int b;
    Pair(int a, int b){
        this.a = a;
        this.b = b;
    }

    public int hashCode(){
        return Objects.hash(a, b);
    }

    public boolean equals(Object other){
        if(other instanceof Pair){
            Pair p = (Pair) other;
            return p.a == this.a && p.b == this.b;
        }
        return false;
    }
}

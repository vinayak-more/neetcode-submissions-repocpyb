class Solution {
    public boolean hasDuplicate(int[] array) {
        Set<Integer> set = new HashSet<>();
		for(int num : array){
			if(set.contains(num)) return true;
			set.add(num);
		}
        return false;

    }
}

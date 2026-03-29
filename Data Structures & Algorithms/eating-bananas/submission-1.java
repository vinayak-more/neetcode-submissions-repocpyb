class Solution {
   public int minEatingSpeed(int[] piles, int h) {
		int left = 1, right = piles[0], mid, hours;
        	for(int pile : piles){
			left = Math.min(left, pile);
			right = Math.max(right, pile);
		}
		int ans = right;
		while(left <= right){
			mid = left + (right - left)/2;
			hours = calcHours(piles, mid);
			if(hours <= h){
				ans = Math.min(ans, mid);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return ans;
	}
		
	private int calcHours(int[] piles, int rate){
		int total = 0;
		for(int pile : piles){
			total += pile / rate;
			if(pile % rate != 0) total++;
		}
		return total;
	}

}

class Solution {
    public int maxProfit(int[] prices){
		int buyPrice = prices[0], max = 0, profit = 0;
		for(int i = 1; i < prices.length; i++){		
			profit = prices[i] - buyPrice;
			max = Math.max(max, profit);
			buyPrice = Math.min(buyPrice, prices[i]); 
		}
		return max;
	}

}

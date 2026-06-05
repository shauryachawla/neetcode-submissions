class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minBuy = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++) {
            minBuy = Math.min(prices[i], minBuy);
            maxProfit = Math.max(maxProfit, prices[i] - minBuy);
        }
        return maxProfit;
    }
}

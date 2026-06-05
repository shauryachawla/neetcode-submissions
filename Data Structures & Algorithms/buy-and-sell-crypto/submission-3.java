class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int minBuy = Integer.MAX_VALUE;
        for(int sell : prices) {
            minBuy = Math.min(minBuy, sell);
            result = Math.max(result, sell - minBuy);
        }
        return result;
    }
}

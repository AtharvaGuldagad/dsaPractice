package BuyLowSellLow;

public class Solution {
    public int maxProfit(int[] prices) {
        int minp=prices[0];
        int maxprof=0;

        for (int i=0;i<prices.length;i++) {
            minp=Math.min(minp,prices[i]);
            maxprof=Math.max(maxprof,prices[i]-minp);
        }
        return maxprof;
    }
}

package org.carlosbello.leetcode.problems;

/**
 * 121. Best Time to Buy and Sell Stock [easy] https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int max = 0;
        int bestBy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < bestBy) {
                bestBy = prices[i];
            } else if (prices[i] - bestBy > max) {
                max = prices[i] - bestBy;
            }
        }
        return max;
    }
}

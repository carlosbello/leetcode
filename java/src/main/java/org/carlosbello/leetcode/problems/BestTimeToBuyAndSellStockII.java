package org.carlosbello.leetcode.problems;

/**
 * 122. Best Time to Buy and Sell Stock II [easy] https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimeToBuyAndSellStockII {
    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int income = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i-1]) {
                income += prices[i-1] - min;
                min = prices[i];
            }
        }
        income += prices[prices.length - 1] - min;
        return income;
    }
}

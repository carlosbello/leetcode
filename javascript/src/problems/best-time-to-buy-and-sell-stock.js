/**
 * 121. Best Time to Buy and Sell Stock [easy] https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    let min = prices[0];
    let max = -1;
    let income = 0;
    for (let i = 1; i < prices.length; i++) {
        if (prices[i] < min) {
            min = prices[i];
            max = -1;
        } else if (prices[i] > max) {
            max = prices[i];
            income = Math.max(income, max - min);
        }
    }
    return income;
};

module.exports = { maxProfit };

/**
 * 1176. Diet Plan Performance https://leetcode.com/problems/diet-plan-performance/
 *
 * @param {number[]} calories
 * @param {number} k
 * @param {number} lower
 * @param {number} upper
 * @return {number}
 */
const dietPlanPerformance = (calories, k, lower, upper) => {
    const performance = currentCaloriesTotal =>
        currentCaloriesTotal < lower ? -1 : currentCaloriesTotal > upper ? 1 : 0;

    let currentCaloriesRangeTotal = calories.slice(0, k).reduce((total, c) => total + c, 0);
    let performanceTotal = performance(currentCaloriesRangeTotal);
    for (let i = 1; i <= calories.length - k; i++) {
        currentCaloriesRangeTotal += calories[i + k - 1] - calories[i - 1];
        performanceTotal += performance(currentCaloriesRangeTotal);
    }
    return performanceTotal;
};

module.exports = dietPlanPerformance;

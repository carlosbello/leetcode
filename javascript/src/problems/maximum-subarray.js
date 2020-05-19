/**
 * 53. Maximum Subarray [easy] https://leetcode.com/problems/maximum-subarray/
 * 
 * @param {number[]} nums
 * @return {number}
 */
const maxSubArray = nums => {
    let max = Number.NEGATIVE_INFINITY;
    let currentSum = Number.NEGATIVE_INFINITY;
    for (let num of nums) {
        currentSum = Math.max(num, currentSum + num);
        max = Math.max(max, currentSum);
    }
    return max;
};

module.exports = { maxSubArray };
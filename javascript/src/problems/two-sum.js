/**
 * 1. Two Sum [Easy] https://leetcode.com/problems/two-sum/
 * 
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
const twoSum = (nums, target) => {
    const numToIndex = new Map();
    for (let i = 0; i < nums.length; i++) {
        let numToLookUp = target - nums[i];
        if (numToIndex.has(numToLookUp)) {
            return [numToIndex.get(numToLookUp), i];
        } else {
            numToIndex.set(nums[i], i);   
        }        
    }
    return [];
};

module.exports = { twoSum };
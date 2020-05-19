/**
 * 283. Move Zeroes [easy] https://leetcode.com/problems/move-zeroes/
 * 
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
const moveZeroes = nums => {
    let zeros = 0;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] === 0) {
            zeros++;
        } else {
            nums[i-zeros] = nums[i];
        }
    }
    for (let i = nums.length - zeros; i < nums.length; i++) {
        nums[i] = 0;
    }
};

module.exports = { moveZeroes };
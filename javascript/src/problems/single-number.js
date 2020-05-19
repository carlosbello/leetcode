/**
 * 136. Single Number [easy] https://leetcode.com/problems/single-number/
 * 
 * @param {number[]} nums
 * @return {number}
 */
const singleNumber = nums => {
    const seen = new Set();
    for (let n of nums) {
        if (seen.has(n)) {
            seen.delete(n);
        } else {
            seen.add(n);
        }
    }
    return seen.values().next().value;
};

module.exports = { singleNumber };

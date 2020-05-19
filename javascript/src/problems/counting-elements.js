/**
 * 1426. Counting Elements [easy] https://leetcode.com/problems/counting-elements/
 * 
 * @param {number[]} arr
 * @return {number}
 */
const countElements = arr => {
    const sortedArr = Array.from(arr).sort((a,b) => a - b);
    let count = 0;
    let currentCount = 1;
    for (let i = 1; i < sortedArr.length; i++) {
        if (sortedArr[i-1] === sortedArr[i]) {
            currentCount++;
        } else {
            if (sortedArr[i-1] === sortedArr[i] - 1) {
                count += currentCount;
            }
            currentCount = 1;
        }
    }
    return count;
};

module.exports = { countElements };

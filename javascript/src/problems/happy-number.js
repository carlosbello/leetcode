/**
 * 202. Happy Number [easy] https://leetcode.com/problems/happy-number/
 * 
 * @param {number} n
 * @return {boolean}
 */
const isHappy = n => {
    const generateNext = n => n.toString().split('').reduce((newN, d) => newN + d ** 2, 0);
    const generated = new Set();
    let nextN = n;
    while (nextN !== 1 && !generated.has(nextN)) {
        generated.add(nextN);
        nextN = generateNext(nextN);
    }
    return nextN === 1;
};

module.exports = { isHappy };

/**
 * 867. Transpose Matrix https://leetcode.com/problems/transpose-matrix/
 *
 * @param {number[][]} A
 * @return {number[][]}
 */
const transpose = A => {
    if (A.length == 0) {
        return [];
    }
    const B = new Array(A[0].length);
    for (let i in A[0]) {
        B[i] = new Array(A.length);
        for (let j in A) {
            B[i][j] = A[j][i];
        }
    }
    return B;
};

module.exports = { transpose };

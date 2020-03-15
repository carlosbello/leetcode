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

/**
 * 73. Set Matrix Zeroes 
 * 
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
const setZeroes = (matrix) => {
    if (matrix.length == 0) {
        return;
    }
    const rows = new Array(matrix.length);
    const cols = new Array(matrix[0].length);
    for (let i in matrix) {
        for (let j in matrix[0]) {
            if (matrix[i][j] == 0) {
                rows[i] = true;
                cols[j] = true;
            }
        }
    }

    for (let i in matrix) {
        for (let j in matrix[0]) {
            if (rows[i] || cols[j]) {
                matrix[i][j] = 0;
            }
        }
    }
};

module.exports = { transpose, setZeroes };

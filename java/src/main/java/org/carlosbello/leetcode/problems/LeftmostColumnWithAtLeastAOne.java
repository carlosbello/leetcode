package org.carlosbello.leetcode.problems;

import java.util.List;

/**
 * 1428. Leftmost Column with at Least a One [medium] https://leetcode.com/problems/leftmost-column-with-at-least-a-one/
 */
public class LeftmostColumnWithAtLeastAOne {
    private int getFirstRowWithOne(int col, BinaryMatrix binaryMatrix, int rows, int cols) {
        int row = 0;
        while (row < rows && binaryMatrix.get(row, col) == 0) {
            row ++;
        }
        return row < rows ? row : -1;
    }

    private int getLeftMostColWithOne(int row, int col, BinaryMatrix binaryMatrix) {
        while (col >= 0 && binaryMatrix.get(row, col) == 1) {
            col--;
        }
        return col + 1;
    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        var dimensions = binaryMatrix.dimensions();
        int rows = dimensions.get(0);
        int cols = dimensions.get(1);

        int firstRowWithOne = -1;
        int leftMostCol = cols;

        do {
            firstRowWithOne = getFirstRowWithOne(leftMostCol - 1, binaryMatrix, rows, cols);
            if (firstRowWithOne >= 0) {
                leftMostCol = getLeftMostColWithOne(firstRowWithOne, leftMostCol - 1, binaryMatrix);
            }
        } while (firstRowWithOne >= 0 && leftMostCol > 0);

        return leftMostCol < cols ? leftMostCol : -1;
    }

    interface BinaryMatrix {
        int get(int row, int col);
        List<Integer> dimensions();
    }
}

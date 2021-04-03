package org.carlosbello.leetcode.problems;

/**
 * 1812. Determine Color of a Chessboard Square [easy] https://leetcode.com/problems/determine-color-of-a-chessboard-square/
 */
public class DetermineColorOfAChessboardSquare {
    public boolean squareIsWhite(String coordinates) {
        boolean evenRow = (coordinates.charAt(0) - 'a') % 2 == 0;
        boolean evenCol = ((coordinates.charAt(1) - '1') + 1) % 2 == 0;
        return evenRow && evenCol || !evenRow && !evenCol;
    }
}

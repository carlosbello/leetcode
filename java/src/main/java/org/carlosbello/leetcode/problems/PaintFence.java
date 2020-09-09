package org.carlosbello.leetcode.problems;

/**
 * 276. Paint Fence [easy] https://leetcode.com/problems/paint-fence/
 */
public class PaintFence {
    int[][] numWaysKnown;
    int colorsCount;

    private int numWaysExcluding(int n, boolean canRepeat) {
        if (n == 1) {
            return canRepeat ? colorsCount : (colorsCount - 1);
        }
        int crIndex = canRepeat ? 0 : 1;

        if (numWaysKnown[n][crIndex] == -1) {
            numWaysKnown[n][crIndex] = canRepeat
                    ? (colorsCount - 1) * numWaysExcluding(n - 1, true) + numWaysExcluding(n - 1, false)
                    : (colorsCount - 1) * numWaysExcluding(n - 1, true);
        }

        return numWaysKnown[n][crIndex];
    }

    public int numWays(int n, int k) {
        if (n == 0) return 0;
        if (n == 1) return k;
        numWaysKnown = new int[n][2];
        for (int[] nw: numWaysKnown) {
            nw[0] = nw[1] = -1;
        }
        colorsCount = k;

        return k * numWaysExcluding(n - 1, true);
    }
}

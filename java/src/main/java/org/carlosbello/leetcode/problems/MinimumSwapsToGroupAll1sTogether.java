package org.carlosbello.leetcode.problems;

/**
 * 1151. Minimum Swaps to Group All 1's Together [medium] https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/
 */
public class MinimumSwapsToGroupAll1sTogether {
    public int minSwaps(int[] data) {
        int onesGroupSize = 0;
        for (int number: data) {
            onesGroupSize += number;
        }
        if (onesGroupSize == 0 || onesGroupSize == data.length) return 0;


        int zeroesInWindow = 0;
        for (int i = 0; i < onesGroupSize; i++) {
            zeroesInWindow -= data[i] - 1;
        }
        int minSwaps = zeroesInWindow;

        for (int i = 1; i <= data.length - onesGroupSize; i++) {
            zeroesInWindow += (data[i - 1] - 1) - (data[i + onesGroupSize - 1] - 1);
            minSwaps = Math.min(minSwaps, zeroesInWindow);
        }

        return minSwaps;
    }
}

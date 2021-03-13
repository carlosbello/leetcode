package org.carlosbello.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 957. Prison Cells After N Days [medium] https://leetcode.com/problems/prison-cells-after-n-days/
 */
public class PrisonCellsAfterNDays {
    private String toBinString(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for(int d: digits) {
            sb.append(d);
        }
        return sb.toString();
    }

    private int[] toBinArray(int val) {
        int[] binArr = new int[8];
        String binString  = Integer.toBinaryString(val);
        int start = 8 - binString.length();
        for (int i = 0; i < binString.length(); i++) {
            binArr[start + i] = binString.charAt(i) == '1' ? 1 : 0;
        }
        return binArr;
    }

    /**
     * My first approach was a basic nested iteration comparing cells[i-1] == cells[i+1] but I got a "Time Limit Exceeded".
     * Then I thought it would be enough changing to a bit manipulation approach to avoid the second cycle, but it algo
     * got the "Time Limit Exceeded" result.
     * Then the cycle detection speed it up enough. Probably the first basic approach would have worked as well.
     */
    public int[] prisonAfterNDays(int[] cells, int n) {
        int currentDay = Integer.parseInt(toBinString(cells), 2);
        Map<Integer, Integer> days = new HashMap<>();
        boolean cycleFound = false;

        for (int day = 1; day <= n; day++) {
            if (!cycleFound) {
                if (days.containsKey(currentDay)) {
                    int pendingDays = n - day;
                    int cycleSize = day - days.get(currentDay);
                    int pendingDaysAfterCycleRepetitions = pendingDays % cycleSize;
                    day = n - pendingDaysAfterCycleRepetitions;
                    cycleFound = true;
                } else {
                    days.put(currentDay, day);
                }
            }

            int shifter = currentDay << 2;
            int result = ~ (currentDay ^ shifter) >> 1;
            currentDay = result & 126;
        }

        return toBinArray(currentDay);
    }
}

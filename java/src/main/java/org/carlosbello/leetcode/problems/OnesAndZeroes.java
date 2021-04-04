package org.carlosbello.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 474. Ones and Zeroes [medium] https://leetcode.com/problems/ones-and-zeroes/
 */
public class OnesAndZeroes {
    private Map<Integer, Integer> solution;

    private int findMax(int current, String[] strs, int m, int n) {
        if (current >= strs.length) return 0;

        int currentCase = current * 1000000 + m * 1000 + n;
        if (solution.containsKey(currentCase)) return solution.get(currentCase);

        String str = strs[current];
        int oneCount = (int)str.chars().filter(c -> c == '1').count();
        int zeroCount = str.length() - oneCount;

        boolean currentCanBeIncluded = zeroCount <= m && oneCount <= n;
        int includingCurrent = currentCanBeIncluded
            ? 1 + findMax(current + 1, strs, m - zeroCount, n - oneCount)
            : 0;
        int excludingCurrent = findMax(current + 1, strs, m, n);

        int max = Math.max(includingCurrent, excludingCurrent);
        solution.put(currentCase, max);

        return max;
    }

    public int findMaxForm(String[] strs, int m, int n) {
        solution = new HashMap<>();
        return findMax(0, strs, m, n);
    }
}

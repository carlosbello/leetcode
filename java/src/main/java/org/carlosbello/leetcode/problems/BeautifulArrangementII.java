package org.carlosbello.leetcode.problems;

/**
 * 667. Beautiful Arrangement II [medium] https://leetcode.com/problems/beautiful-arrangement-ii/
 */
public class BeautifulArrangementII {
    public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        if (k == 1) {
            for (int i = 0; i < n; i++) {
                result[i] = i + 1;
            }
        } else {
            k++;
            for (int i = 0, p = 1; i < n; i++, p++, k--) {
                if (k >= p) {
                    result[i] = k;
                    i++;
                }
                if (i < n) {
                   result[i] = p < k ? p : i + 1; 
                }
            }
        }
        return result;
    }
}

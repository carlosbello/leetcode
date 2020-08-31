package org.carlosbello.leetcode.problems;

/**
 * 29. Divide Two Integers [medium] https://leetcode.com/problems/divide-two-integers/
 */
public class DivideTwoIntegers {
    /**
     * Brute force.
     */
    public int divide(int dividend, int divisor) {
        boolean positiveResult = Math.min(dividend, divisor) >= 0 || Math.max(dividend, divisor) < 0;
        int division = 1;
        int negDivisor = divisor < 0 ? divisor : -divisor;
        int negDividend = dividend < 0 ? dividend : -dividend;
        int divisionTimesDivisor = negDivisor;

        if (dividend == 0 || negDivisor < negDividend) {
            return 0;
        }
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (negDivisor == -1) {
            return positiveResult ? Math.abs(dividend) : -Math.abs(dividend);
        }

        while (divisionTimesDivisor > negDividend && divisionTimesDivisor < 0) {
            division++;
            divisionTimesDivisor += negDivisor;
        }

        if (divisionTimesDivisor < negDividend || divisionTimesDivisor >= 0) {
            division--;
        }
        return positiveResult ? division : -division;
    }
}

package org.carlosbello.leetcode.problems;

/**
 * 50. Pow(x, n) [medium] https://leetcode.com/problems/powx-n/
 */
public class PowXN {
    public double myPow(double x, int n) {
        if (n == 0 || x == 1.0) {
            return 1;
        }
        double base = n > 0 ? x : (1/x);
        double exponent = n < 0 ? n : -n;
        int lastExponent = -1;
        double result = base;
        while (lastExponent * 2 < 0 && lastExponent * 2 >= exponent) {
            result *= result;
            lastExponent *= 2;
        }
        for (int i = lastExponent; i > exponent; i--) {
            result *= base;
        }
        return result;
    }
}

package org.carlosbello.leetcode.problems;

/**
 * 326. Power of Three [easy] https://leetcode.com/problems/power-of-three/
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n == 1) return true;
        if (n < 3) return false;
        return n % 3 == 0 && isPowerOfThree(n / 3);
    }
}

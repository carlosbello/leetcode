package org.carlosbello.leetcode.problems;

/**
 * 509. Fibonacci Number [easy] https://leetcode.com/problems/fibonacci-number/
 */
public class FibonacciNumber {
    public int fib(int n) {
        if (n == 0) return 0;

        int fi_p = 0;
        int fi = 1;
        for (int i = 2; i <= n; i++) {
            int t1 = fi;
            fi += fi_p;
            fi_p = t1;
        }
        return fi;
    }
}

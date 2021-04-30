package org.carlosbello.leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 970. Powerful Integers [medium] https://leetcode.com/problems/powerful-integers/
 */
public class PowerfulIntegers {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> solutions = new HashSet<>();
        double xPowI;
        double yPowJ;

        if (x * y == 1) return bound < 2 ? List.of() : List.of(2);

        if (x / y == x || y / x == y) {
            int xy = x * y;
            for (int i = 0;1 + (xPowI = Math.pow(xy, i)) <= bound; i++) {
                solutions.add((int)(1 + xPowI));
            }
            return new ArrayList<>(solutions);
        }

        for (int i = 0;(xPowI = Math.pow(x, i)) <= bound; i++) {
            for (int j = 0;xPowI + (yPowJ = Math.pow(y, j)) <= bound; j++) {
                solutions.add((int)(xPowI + yPowJ));
            }
        }

        return new ArrayList<>(solutions);
    }
}

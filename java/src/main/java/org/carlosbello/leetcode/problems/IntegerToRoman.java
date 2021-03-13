package org.carlosbello.leetcode.problems;

import java.util.Arrays;

/**
 * 12. Integer to Roman [medium] https://leetcode.com/problems/integer-to-roman/
 */
public class IntegerToRoman {
    private static final String[][] ROMANS_BY_POWER_RANGE = new String[][] {
            {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
            {"", "M", "MM", "MMM"},
    };

    private int[] reversedDigits(int num) {
        int[] digits = new int[4];
        int digitCount = 0;
        do {
            int rest = num / 10;
            int digit = num - rest * 10;
            num = rest;
            digits[digitCount] = digit;
            digitCount++;
        } while (num > 0);

        return Arrays.copyOf(digits, digitCount);
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] digits = reversedDigits(num);
        for (int power = 0; power < digits.length; power++) {
            int digit = digits[power];
            sb.insert(0, ROMANS_BY_POWER_RANGE[power][digit]);
        }
        return sb.toString();
    }
}

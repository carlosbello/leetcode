package org.carlosbello.leetcode.problems;

/**
 * 8. String to Integer (atoi) [medium] https://leetcode.com/problems/string-to-integer-atoi/
 */
public class StringToIntegerAtoi {
    private boolean isASign(char c) {
        return c == '+' || c == '-';
    }

    private boolean isANumber(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isASignOrANumber(char c) {
        return isASign(c) || isANumber(c);
    }

    public int myAtoi(String str) {
        StringBuilder numberStr = new StringBuilder();
        int currentCharPos = 0;
        int result = 0;

        while (currentCharPos < str.length() && str.charAt(currentCharPos) == ' ') {
            currentCharPos++;
        }
        if (currentCharPos >= str.length() || !isASignOrANumber(str.charAt(currentCharPos))) {
            return 0;
        }

        numberStr.append(str.charAt(currentCharPos));
        currentCharPos++;
        while (currentCharPos < str.length() && isANumber(str.charAt(currentCharPos))) {
            numberStr.append(str.charAt(currentCharPos));
            currentCharPos++;
        }

        if (isASign(numberStr.charAt(0)) && numberStr.length() == 1) {
            return 0;
        }

        try {
            result = Integer.valueOf(numberStr.toString());
        } catch (Exception e) {
            result = numberStr.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return result;
    }
}

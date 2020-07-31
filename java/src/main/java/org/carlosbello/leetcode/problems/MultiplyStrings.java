package org.carlosbello.leetcode.problems;

/**
 * 43. Multiply Strings [medium] https://leetcode.com/problems/multiply-strings/
 */
public class MultiplyStrings {
    /**
     * Assuming that a and b are digits
     */
    private int[] multiplyWithRest(int a, int b, int rest) {
        int c = a * b + rest;
        return new int[] { c / 10, c % 10 };
    }

    /**
     * Assuming that a and b are digits
     */
    private int[] sumWithRest(int a, int b, int rest) {
        int c = a + b + rest;
        return new int[] { c / 10, c % 10};
    }

    /**
     * Assume:
     * 1. num1.length == num2.length
     * 2. the first digit won't have a rest after the sum
     */
    private int[] sum(int[] num1, int[] num2) {
        int[] result = new int[num1.length];
        int rest = 0;

        for(int i = num1.length - 1; i >= 0; i--) {
            int[] tempSum = sumWithRest(num1[i], num2[i], rest);
            result[i] = tempSum[1];
            rest = tempSum[0];
        }

        return result;
    }

    private String join(int[] num) {
        StringBuilder sb = new StringBuilder();
        int digitIndex = 0;
        while (digitIndex < num.length && num[digitIndex] == 0) {
            digitIndex++;
        }
        while(digitIndex < num.length) {
            sb.append(num[digitIndex]);
            digitIndex++;
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    private int[] toDigitsArray(String num) {
        return num.chars().map(d -> d - '0').toArray();
    }

    public String multiply(String num1, String num2) {
        int[] num1Digits = toDigitsArray(num1);
        int[] num2Digits = toDigitsArray(num2);
        int[] result = new int[num1Digits.length + num2Digits.length];

        for (int num2Index = num2Digits.length - 1, num2DigitProcessing = 0;
             num2Index >= 0;
             num2Index--, num2DigitProcessing++) {

            int rest = 0;
            int[] tempResult = new int[result.length];

            for (int num1Index = num1Digits.length - 1, num1DigitProcessing = 0;
                 num1Index >= 0;
                 num1Index--, num1DigitProcessing++) {

                int[] tempMult = multiplyWithRest(num1Digits[num1Index], num2Digits[num2Index], rest);
                tempResult[tempResult.length - (num1DigitProcessing + num2DigitProcessing + 1)] =
                        tempMult[1];
                rest = tempMult[0];
            }
            tempResult[tempResult.length - (num1Digits.length + num2DigitProcessing + 1)] = rest;
            result = sum(result, tempResult);
        }

        return join(result);
    }
}

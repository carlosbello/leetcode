package org.carlosbello.leetcode.problems;

/**
 * 67. Add Binary [easy] https://leetcode.com/problems/add-binary/
 */
public class AddBinary {
    private int[] addWithRest(int d1, int d2, int rest) {
        int sum = d1 + d2 + rest;
        return new int[] {sum / 2, sum % 2};
    }

    private int[] toBitArray(String numbers) {
        return numbers.chars().map(d -> d - '0').toArray();
    }

    public String addBinary(String a, String b) {
        int[] aBits = toBitArray(a);
        int[] bBits = toBitArray(b);
        int[] biggerNumberBits = aBits.length >= bBits.length ? aBits : bBits;

        StringBuilder sb = new StringBuilder();
        int sizeOfSmaller = Math.min(aBits.length, bBits.length);
        int rest = 0;

        for (int current = 1; current <= sizeOfSmaller; current++) {
            int[] tempSum = addWithRest(
                    aBits[aBits.length - current],
                    bBits[bBits.length - current],
                    rest
            );
            sb.append(tempSum[1]);
            rest = tempSum[0];
        }

        for (int current = biggerNumberBits.length - sizeOfSmaller - 1; current >= 0; current--) {
            int[] tempSum = addWithRest(
                    biggerNumberBits[current],
                    0,
                    rest
            );
            sb.append(tempSum[1]);
            rest = tempSum[0];
        }

        if (rest > 0) {
            sb.append(rest);
        }

        return sb.reverse().toString();
    }
}

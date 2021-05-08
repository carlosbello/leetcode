package org.carlosbello.leetcode.problems;

import java.math.BigInteger;

/**
 * 906. Super Palindromes [hard] https://leetcode.com/problems/super-palindromes/
 */
public class SuperPalindromes {
    private static final char[] MID_DIGITS = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public boolean isPalindrome(BigInteger n) {
        var s = n.toString();
        var left = 0;
        var right = s.length() - 1;
        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }
        return left >= right;
    }

    private BigInteger buildPalindrome(int n, Character mid) {
        var start = String.valueOf(n);
        var sb = new StringBuilder(start);
        sb.reverse();
        if (mid != null) sb.insert(0, mid);
        sb.insert(0, start);
        return new BigInteger(sb.toString());
    }

    public int superpalindromesInRange(String left, String right) {

        var start = new BigInteger(left);
        var end = new BigInteger(right);
        int count = 0;

        for (int i = 1; i < 10; i++) {
            var test = BigInteger.valueOf(i).pow(2);

            if (test.compareTo(end) > 0) return count;

            count += (test.compareTo(start) >= 0 && isPalindrome(test)) ? 1 : 0;
        }

        for (int i = 1; true; i++) {
            var pal = buildPalindrome(i, null);
            var test = pal.pow(2);

            if (test.compareTo(end) > 0) return count;

            count += (test.compareTo(start) >= 0 && isPalindrome(test)) ? 1 : 0;

            for (Character c: MID_DIGITS) {
                pal = buildPalindrome(i, c);
                test = pal.pow(2);

                count += (test.compareTo(start) >= 0 && test.compareTo(end) <= 0 && isPalindrome(test))
                    ? 1 : 0;
            }
        }
    }
}

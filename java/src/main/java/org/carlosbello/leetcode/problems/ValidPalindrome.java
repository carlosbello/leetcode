package org.carlosbello.leetcode.problems;

/**
 * 125. Valid Palindrome [easy] https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String lowerS = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        boolean valid = true;
        while (start < end && valid) {
            if (!Character.isLetterOrDigit(lowerS.charAt(start))) {
                start++;
            } else if (!Character.isLetterOrDigit(lowerS.charAt(end))) {
                end--;
            } else {
                valid &= lowerS.charAt(start) == lowerS.charAt(end);
                start++;
                end--;
            }
        }
        return valid;
    }
}

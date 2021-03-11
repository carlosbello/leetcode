package org.carlosbello.leetcode.problems;

/**
 * 5. Longest Palindromic Substring [medium] https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {
    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        return start >= end;
    }

    /**
     * Slower solution. Can't use memoization because of a memory limit exceeded error if used a Map
     */
    public String longestPalindrome1(String s) {
        if (s == null || s.isEmpty())  return s;

        String longestPal = "";
        for (int start = 0;
             start < s.length() - longestPal.length();
             start++) {
            String currentLongestPal = "";
            for (int end = s.length();
                 end > start && currentLongestPal.isEmpty();
                 end--) {
                String section = s.substring(start, end);
                if (isPalindrome(section)) {
                    currentLongestPal = section;
                }
                if (currentLongestPal.length() > longestPal.length()) {
                    longestPal = currentLongestPal;
                }
            }
        }
        return longestPal;
    }

    private String getLongestPalindrome(String s, int center) {
        int start = center;
        int end = center;
        while (0 <= start && s.charAt(start) == s.charAt(center)) start--;
        while (end < s.length() && s.charAt(end) == s.charAt(center)) end++;

        while (0 <= start && end < s.length() &&
                s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }

    /**
     * Faster solution. No memoization needed because the palindromes are build, not checked.
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.isEmpty())  return s;

        int midPoint = s.length() / 2;
        String longestPal = getLongestPalindrome(s, midPoint);
        for (int displacement = 1;
             2 * (midPoint - displacement) + 1 >  longestPal.length();
             displacement++) {
            String longestPalFromLeftCenter = getLongestPalindrome(s, midPoint - displacement);
            String longestPalFromRightCenter = getLongestPalindrome(s, midPoint + displacement);
            if (longestPalFromLeftCenter.length() > longestPal.length()) {
                longestPal = longestPalFromLeftCenter;
            }
            if (longestPalFromRightCenter.length() > longestPal.length()) {
                longestPal = longestPalFromRightCenter;
            }
        }

        return longestPal;
    }

    /**
     * Another slow (but accepted) solution.
     */
    public String longestPalindrome3(String s) {
        String longestPalindrome = s.substring(0, 1);
        for (int start = 0; start < s.length() - longestPalindrome.length(); start++) {
            StringBuilder currentWordBuilder = new StringBuilder();
            StringBuilder reverseWordBuilder = new StringBuilder();
            currentWordBuilder.append(s.charAt(start));
            reverseWordBuilder.append(s.charAt(start));

            for (int end = start + 1; end < s.length(); end++) {
                currentWordBuilder.append(s.charAt(end));
                reverseWordBuilder.insert(0, s.charAt(end));
                String currentWord = currentWordBuilder.toString();
                if (currentWord.equals(reverseWordBuilder.toString()) && currentWord.length() > longestPalindrome.length()) {
                    longestPalindrome = currentWord;
                }
            }
        }
        return longestPalindrome;
    }
}

package org.carlosbello.leetcode.problems;

/**
 * 32. Longest Valid Parentheses [hard] https://leetcode.com/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {
    private int valueAt(String s, int  index) {
        return s.charAt(index) == '(' ? +1 : -1;
    }

    public int longestValidParentheses(String s) {
        int start = 0;
        int longest = 0;

        while (start < s.length() - 1) {
            int balance = valueAt(s, start);
            int end = start + 1;
            int longer = 0;
            while (balance >= 0 && end < s.length()) {
                balance += valueAt(s, end);
                end++;
                if (balance == 0 && end - start > longer) {
                    longer = end - start;
                    longest = Math.max(longer, longest);
                }
            }
            if (balance >= 0) {
                start += longer > 0 ? longer : 1;
            } else {
                start = end;
            }
        }

        return longest;
    }

    /**
     * Slower but simpler and accepted solution
     */
    public int longestValidParentheses2(String s) {
        int start = 0;
        int longest = 0;

        while (start + longest < s.length()) {
            int value = s.charAt(start) == '(' ? 1 : -1;
            for (int end = start + 1; end < s.length() && value >= 0; end++) {
                value += s.charAt(end) == '(' ? 1 : -1;
                if (value == 0 && end - start + 1 > longest) {
                    longest = end - start + 1;
                }
            }

            start++;
        }

        return longest;
    }
}

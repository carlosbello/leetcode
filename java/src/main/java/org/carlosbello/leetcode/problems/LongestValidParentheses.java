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
}

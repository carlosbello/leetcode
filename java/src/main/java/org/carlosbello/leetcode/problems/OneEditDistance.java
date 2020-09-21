package org.carlosbello.leetcode.problems;

/**
 * 161. One Edit Distance [medium] https://leetcode.com/problems/one-edit-distance/
 */
public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if (s.length() > t.length()) return isOneEditDistance(t, s);
        if (Math.abs(s.length() - t.length()) > 1) return false;

        int index = 0;
        while (index < s.length() && s.charAt(index) == t.charAt(index)) {
            index++;
        }
        return s.length() == t.length()
                ? index < s.length() && s.substring(index + 1).equals(t.substring(index + 1))
                : s.substring(index).equals(t.substring(index + 1));
    }
}

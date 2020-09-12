package org.carlosbello.leetcode.problems;

/**
 * 392. Is Subsequence [easy] https://leetcode.com/problems/is-subsequence/
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        if (s.length() == 0) return true;

        int indexOfHead = t.indexOf(s.charAt(0));
        return indexOfHead >= 0 &&
                isSubsequence(s.substring(1), t.substring(indexOfHead + 1));
    }
}

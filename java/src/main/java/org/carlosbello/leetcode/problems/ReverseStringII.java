package org.carlosbello.leetcode.problems;

/**
 * 541. Reverse String II [easy] https://leetcode.com/problems/reverse-string-ii/
 */
public class ReverseStringII {
    public String reverseStr(String s, int k) {
        StringBuilder ns = new StringBuilder();
        int start = 0;
        while (start < s.length()) {
            StringBuilder reverser = new StringBuilder();

            int end = Math.min(start + k, s.length());
            reverser.append(s.substring(start, end));
            reverser.reverse();
            ns.append(reverser.toString());
            start = end + k;

            ns.append(s.substring(end, Math.min(start,  s.length())));
        }
        return ns.toString();
    }
}

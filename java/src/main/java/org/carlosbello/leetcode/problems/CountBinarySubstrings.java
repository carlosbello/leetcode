package org.carlosbello.leetcode.problems;

/**
 * 696. Count Binary Substrings [easy] https://leetcode.com/problems/count-binary-substrings/
 */
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        if (s.length() < 1) return 0;
        if (s.length() == 2) return s.charAt(0) != s.charAt(1) ? 1 : 0;

        char currCharSeq = s.charAt(0);
        int prevCount = 0;
        int currCount = 1;
        int substringCount = 0;
        for (int i = 1; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar == currCharSeq) {
                currCount++;
                if (prevCount > 0) {
                    prevCount--;
                    substringCount++;
                }
            } else {
                prevCount = currCount - 1;
                currCharSeq = currChar;
                currCount = 1;
                substringCount++;
            }
        }
        return substringCount;
    }
}

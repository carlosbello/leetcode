package org.carlosbello.leetcode.problems;

/**
 * 76. Minimum Window Substring [hard] https://leetcode.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {
    private static final int DIC_SIEZE = 'z' - 'A' + 1;

    private int[] buildTDic(String t) {
        int[] dic = new int[DIC_SIEZE];
        for (char c: t.toCharArray()) {
            dic[c - 'A']++;
        }
        return dic;
    }

    private int countUniqueChar(int[] dic) {
        int count = 0;
        for (int value : dic) {
            if (value > 0) {
                count++;
            }
        }
        return count;
    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length() || s.length() + t.length() == 0) return "";

        int[] tdic = buildTDic(t);
        int tcars = countUniqueChar(tdic);
        int[] wdic = new int[DIC_SIEZE];
        int minLeft = 0;
        int minRight = 0;
        int right;
        int wProcessedCars = 0;

        for (right = 0; right < s.length() && wProcessedCars < tcars; right++) {
            int currentCharIndex = s.charAt(right) - 'A';
            if (tdic[currentCharIndex] > 0) {
                wdic[currentCharIndex]++;
                if (wdic[currentCharIndex] == tdic[currentCharIndex]) {
                    wProcessedCars++;
                }
            }
        }

        if (wProcessedCars < tcars) return "";

        minRight = right;
        boolean isValidWindow = true;

        for (int left = 0; isValidWindow && left < s.length(); left++) {
            int currentCharIndex = s.charAt(left) - 'A';
            if (tdic[currentCharIndex] == 0) {
                if (right - left - 1 < minRight - minLeft) {
                    minLeft = left + 1;
                    minRight = right;
                }
                continue;
            }
            wdic[currentCharIndex]--;
            if (wdic[currentCharIndex] >= tdic[currentCharIndex]) {
                if (right - left - 1 < minRight - minLeft) {
                    minLeft = left + 1;
                    minRight = right;
                }
                continue;
            }

            char lookForChar = s.charAt(left);
            isValidWindow = false;

            for (;right < s.length() && !isValidWindow; right++) {
                currentCharIndex = s.charAt(right) - 'A';
                if (tdic[currentCharIndex] > 0) {
                    wdic[currentCharIndex]++;
                }
                isValidWindow = s.charAt(right) == lookForChar;
            }
        }

        return s.substring(minLeft, minRight);
    }
}

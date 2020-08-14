package org.carlosbello.leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 567. Permutation in String [medium] https://leetcode.com/problems/permutation-in-string/
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1Chars = new HashMap<>();
        for (char c: s1.toCharArray()) {
            s1Chars.put(c, s1Chars.getOrDefault(c, 0) + 1);
        }
        int searchLength = s1.length();

        for (int i = 0; i <= s2.length() - searchLength; i++) {
            Map<Character, Integer> fragmentCharCount = new HashMap<>();
            int count = 0;
            while (count < searchLength && s1Chars.containsKey(s2.charAt(i+count)) &&
                    fragmentCharCount.getOrDefault(s2.charAt(i+count), 0) < s1Chars.get(s2.charAt(i+count))) {
                fragmentCharCount.put(s2.charAt(i+count), fragmentCharCount.getOrDefault(s2.charAt(i+count), 0) + 1);
                count++;
            }
            if (count == searchLength) {
                return true;
            }
        }

        return false;
    }

    private String sort(String s) {
        char[] sChars = s.toCharArray();
        Arrays.sort(sChars);
        return new String(sChars);
    }

    /**
     * This works but gets a Time Limit Exceeded for very long inputs given the not optimal repeated sorting processes
     */
    public boolean checkInclusion1(String s1, String s2) {
        String sortedS1 = sort(s1);
        int searchLength = s1.length();

        for (int i = 0; i <= s2.length() - searchLength; i++) {
            String sortedFragment = sort(s2.substring(i, i+searchLength));
            if (sortedFragment.equals(sortedS1)) {
                return true;
            }
        }

        return false;
    }
}

package org.carlosbello.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters [medium] https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seenChars = new HashSet<>();
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            seenChars.clear();
            seenChars.add(s.charAt(i));

            for (int j = i + 1; j < s.length() && !seenChars.contains(s.charAt(j)); j++) {
                seenChars.add(s.charAt(j));
            }
            maxLength = Math.max(maxLength, seenChars.size());
        }

        return maxLength;
    }
}

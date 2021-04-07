
package org.carlosbello.leetcode.problems;

import java.util.Set;

/**
 * 1704. Determine if String Halves Are Alike [easy] https://leetcode.com/problems/determine-if-string-halves-are-alike/
 */
public class DetermineIfStringHalvesAreAlike {
    private static final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public boolean halvesAreAlike(String s) {
        int leftVowels = 0;
        int rightVowels = 0;

        for (int left = 0, right = s.length() - 1; left < right; left++, right--) {
            leftVowels += vowels.contains(s.charAt(left)) ? 1 : 0;
            rightVowels += vowels.contains(s.charAt(right)) ? 1 : 0;
        }

        return leftVowels == rightVowels;
    }
}
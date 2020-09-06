package org.carlosbello.leetcode.problems;

import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * 791. Custom Sort String [medium] https://leetcode.com/problems/custom-sort-string/
 */
public class CustomSortString {
    int[] buildCharPresedence(String s) {
        int[] precedence = new int[26];

        for (int charIndex = 0; charIndex < s.length(); charIndex++) {
            precedence[s.charAt(charIndex) - 'a'] = charIndex;
        }

        return precedence;
    }

    public String customSortString(String S, String T) {
        int[] charPrecedence = buildCharPresedence(S);
        Comparator<Integer> compareChar = (c1, c2) -> charPrecedence[c1 - 'a'] - charPrecedence[c2 - 'a'];

        return T.chars().boxed()
                .sorted(compareChar)
                .map(i -> String.valueOf((char)i.intValue()))
                .collect(Collectors.joining());
    }
}

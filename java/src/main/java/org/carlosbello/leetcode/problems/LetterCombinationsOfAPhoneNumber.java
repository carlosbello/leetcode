package org.carlosbello.leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 17. Letter Combinations of a Phone Number [medium] https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsOfAPhoneNumber {
    Map<Character, List<String>> phoneMap = Map.of(
            '2', List.of("a", "b", "c"),
            '3', List.of("d", "e", "f"),
            '4', List.of("g", "h", "i"),
            '5', List.of("j", "k", "l"),
            '6', List.of("m", "n", "o"),
            '7', List.of("p", "q", "r", "s"),
            '8', List.of("t", "u", "v"),
            '9', List.of("w", "x", "y", "z"));

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return List.of();
        }
        if (digits.length() == 1) {
            return phoneMap.get(digits.charAt(0));
        }

        var letterList = phoneMap.get(digits.charAt(0));
        var newCombinations = new ArrayList<String>();
        var combinations = letterCombinations(digits.substring(1));

        for (String letter: letterList) {
            for (String combination: combinations) {
                newCombinations.add(letter + combination);
            }
        }

        return newCombinations;
    }
}
